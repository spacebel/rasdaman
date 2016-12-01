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
 * Copyright 2003 - 2014 Peter Baumann / rasdaman GmbH.
 *
 * For more information please see <http://www.rasdaman.org>
 * or contact Peter Baumann via <baumann@rasdaman.com>.
 */
package petascope.wcs2.handlers.wcst.helpers.update;

import petascope.ConfigManager;
import petascope.exceptions.rasdaman.RasdamanException;
import petascope.util.ras.RasUtil;

import java.io.File;
import java.io.IOException;

/**
 * @author <a href="merticariu@rasdaman.com">Vlad Merticariu</a>
 */
public class RasdamanNetcdfUpdater implements RasdamanUpdater {

    String affectedCollectionName;
    String affectedCollectionOid;
    String affectedDomain;
    File valuesFile;
    String shiftDomain;
    String rangeParameters;

    public RasdamanNetcdfUpdater(String affectedCollectionName, String affectedCollectionOid, String affectedDomain,
                                 File valuesFile, String shiftDomain, String rangeParameters) {
        this.affectedCollectionName = affectedCollectionName;
        this.affectedCollectionOid = affectedCollectionOid;
        this.affectedDomain = affectedDomain;
        this.valuesFile = valuesFile;
        this.shiftDomain = shiftDomain;
        this.rangeParameters = rangeParameters;
    }

    @Override
    public void update() throws RasdamanException, IOException {
        String queryString = UPDATE_TEMPLATE_FILE.replace("$collection", affectedCollectionName)
                             .replace("$domain", affectedDomain)
                             .replace("$oid", affectedCollectionOid)
                             .replace("$shiftDomain", shiftDomain)
                             .replace("$rangeParams", rangeParameters.replace("\"", "\\\""));
        RasUtil.executeUpdateFileStatement(queryString, valuesFile.getAbsolutePath(),
                                           ConfigManager.RASDAMAN_ADMIN_USER, ConfigManager.RASDAMAN_ADMIN_PASS);
    }

    private static final String UPDATE_TEMPLATE_FILE = "UPDATE $collection SET $collection$domain ASSIGN shift(decode($1, \"NetCDF\", \"$rangeParams\"), $shiftDomain) WHERE oid($collection) = $oid";
}
