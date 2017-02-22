/*
 * This file is part of rasdaman community.
 *
 * Rasdaman community is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Rasdaman community is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU  General Public License for more details.
 *
 * You should have received a copy of the GNU  General Public License
 * along with rasdaman community.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2003 - 2016 Peter Baumann / rasdaman GmbH.
 *
 * For more information please see <http://www.rasdaman.org>
 * or contact Peter Baumann via <baumann@rasdaman.com>.
 */
package petascope.wcps2.handler;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import petascope.exceptions.PetascopeException;
import petascope.wcps2.error.managed.processing.InvalidAxisNameException;
import petascope.wcps2.metadata.model.Axis;
import petascope.wcps2.metadata.model.Subset;
import petascope.wcps2.metadata.model.WcpsCoverageMetadata;
import petascope.wcps2.metadata.service.AxisIteratorAliasRegistry;
import petascope.wcps2.metadata.service.RasqlTranslationService;
import petascope.wcps2.metadata.service.SubsetParsingService;
import petascope.wcps2.metadata.service.WcpsCoverageMetadataService;
import petascope.wcps2.result.WcpsResult;
import petascope.wcps2.result.parameters.DimensionIntervalList;
import petascope.wcps2.result.parameters.SubsetDimension;

/**
 * Translation class for slice/trim expression in wcps.
 * <code>
 * $c[x(0:10),y(0:100)]
 * </code>
 * translates to
 * <code>
 * c[0:10,0:100]
 * </code>
 *
 * @author <a href="mailto:alex@flanche.net">Alex Dumitru</a>
 * @author <a href="mailto:vlad@flanche.net">Vlad Merticariu</a>
 */
public class SubsetExpressionHandler {

    public static WcpsResult handle(WcpsResult coverageExpression, DimensionIntervalList dimensionIntervalList,
                                    AxisIteratorAliasRegistry axisIteratorAliasRegistry,
                                    WcpsCoverageMetadataService wcpsCoverageMetadataService,
                                    RasqlTranslationService rasqlTranslationService, SubsetParsingService subsetParsingService) throws PetascopeException {

        String rasql = coverageExpression.getRasql();
        String template = TEMPLATE.replace("$covExp", rasql);

        WcpsCoverageMetadata metadata = coverageExpression.getMetadata();               
        List<SubsetDimension> subsetDimensions = dimensionIntervalList.getIntervals();
        
        // Validate axis name before doing other processes.
        validateSubsets(metadata, subsetDimensions);

        //check in the list of subsets the ones that do not contain "$" and use only those
        // subset dimension without "$"
        List<SubsetDimension> pureSubsetDimensions = subsetParsingService.getPureSubsetDimensions(subsetDimensions);
        // subset dimension with "$"
        List<SubsetDimension> axisIteratorSubsetDimensions = subsetParsingService.getAxisIteratorSubsetDimensions(subsetDimensions);

        // Only apply subsets if subset dimensions don't contain the "$"
        List<Subset> numericSubsets = subsetParsingService.convertToNumericSubsets(pureSubsetDimensions, metadata, false);

        // Update the coverage expression metadata with the new subsets
        wcpsCoverageMetadataService.applySubsets(true, metadata, numericSubsets);

        //now the metadata contains the correct geo and rasdaman subsets
        // NOTE: if subset dimension has "$" as axis iterator, just keep it and don't translate it to numeric as numeric subset.
        String rasqlSubset = "";

        // NOTE: in case of coverage constant e.g: <[-1:1,-1:1],-1,0,1,....> it should not replace the interval inside the "< >"
        if (rasql.contains("<") || !rasql.contains("[")) {
            String dimensions = rasqlTranslationService.constructRasqlDomain(metadata.getAxes(),
                                axisIteratorSubsetDimensions, axisIteratorAliasRegistry);
            rasqlSubset = template.replace("$dimensionIntervalList", dimensions);
        } else {
            // update the interval of the existing expression in template string
            // e.g: trim(c[0:5,0:100,89], {90:90}) -> c[0:5,90:90,89]
            // need to replace the interval correctly
            String tmp = rasql.substring(rasql.indexOf("[") + 1, rasql.indexOf("]"));
            String[] intervals = tmp.split(",");

            String axisName = subsetDimensions.get(0).getAxisName();
            Axis axis = metadata.getAxisByName(axisName);
            int axisOrder = axis.getRasdamanOrder();

            String dimension = rasqlTranslationService.constructRasqlDomain(axis, axisIteratorSubsetDimensions, axisIteratorAliasRegistry);
            intervals[axisOrder] = dimension;

            // 0:5,0:100,89
            String intervalsStr = "[" + StringUtils.join(intervals, ",") + "]";
            rasqlSubset = rasql.replaceAll("\\[.*?\\]", intervalsStr);
        }

        // NOTE: DimensionIntervalList with Trim expression can contain slicing as well (e.g: c[t(0), Lat(0:20), Long(30)])
        // then the slicing axis also need to be removed from coverage metadata.
        wcpsCoverageMetadataService.stripSlicingAxes(metadata, subsetDimensions);

        // Fit to sample space for grid and geo bound of X-Y axes
        // NOTE: only fit if the axis is mentioned in the subsets (e.g: if coverage has 2 axes: Lat, Long), then c[Lat(20.5)] will only fit for Lat axis
        // don't change anything on Long axis
        subsetParsingService.fitToSampleSpaceRegularAxes(numericSubsets, metadata);

        WcpsResult result = new WcpsResult(metadata, rasqlSubset);
        return result;
    }

    /**
     * Validate axis name from subset
     * e.g: c[LAT(12)] is not valid and throw exception
     * @param subsetDimensions
     */
    private static void validateSubsets(WcpsCoverageMetadata metadata, List<SubsetDimension> subsetDimensions) {
        String axisName = null;
        for (SubsetDimension subset:subsetDimensions) {
            axisName = subset.getAxisName();
            boolean isExist = false;
            for (Axis axis : metadata.getAxes()) {           
                if (axis.getLabel().equals(axisName)) {
                    isExist = true;
                    break;
                }
            }
            
            if (!isExist) {
                // subset does not contains valid axis name
                throw new InvalidAxisNameException(axisName);
            }
        }
    }

    private final static String TEMPLATE = "$covExp[$dimensionIntervalList]";
}