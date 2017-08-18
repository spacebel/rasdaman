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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with rasdaman community.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015 Peter Baumann /
 rasdaman GmbH.
 *
 * For more information please see <http://www.rasdaman.org>
 * or contact Peter Baumann via <baumann@rasdaman.com>.
 */

///<reference path="../../common/_common.ts"/>
///<reference path="../ows/ows_all.ts"/>
///<reference path="CoverageSubtypeParent.ts"/>

module wcs {
    export class CoverageSummary extends ows.Description {
        public CoverageId:string;
        public CoverageSubtype:string;
        public CoverageSubtypeParent:CoverageSubtypeParent;
        public WGS84BoundingBox:ows.WGS84BoundingBox[];
        public BoundingBox:ows.BoundingBox[];
        public Metadata:ows.Metadata[];
        public DisplayFootprint:boolean;

        public constructor(source:rasdaman.common.ISerializedObject) {
            super(source);

            rasdaman.common.ArgumentValidator.isNotNull(source, "source");
            // Don't display checkbox to show/hide coverages's footprints if they are not displayable.
            this.DisplayFootprint = null;

            this.CoverageId = source.getChildAsSerializedObject("wcs:CoverageId").getValueAsString();
            this.CoverageSubtype = source.getChildAsSerializedObject("wcs:CoverageSubtype").getValueAsString();

            if (source.doesElementExist("wcs:CoverageSubtypeParent")) {
                this.CoverageSubtypeParent = new CoverageSubtypeParent(source.getChildAsSerializedObject("wcs:CoverageSubtypeParent"));
            }

            this.WGS84BoundingBox = [];
            source.getChildrenAsSerializedObjects("ows:WGS84BoundingBox").forEach(o=> {
                this.WGS84BoundingBox.push(new ows.WGS84BoundingBox(o));
            });

            this.BoundingBox = [];
            source.getChildrenAsSerializedObjects("ows:BoundingBox").forEach(o=> {
                this.BoundingBox.push(new ows.BoundingBox(o));
            });

            this.Metadata = [];
            source.getChildrenAsSerializedObjects("ows:Metadata").forEach(o=> {
                this.Metadata.push(new ows.Metadata(o));
            });
        }
    }
}