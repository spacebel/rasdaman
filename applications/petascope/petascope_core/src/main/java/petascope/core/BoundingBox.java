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
 * Copyright 2003 - 2017 Peter Baumann / rasdaman GmbH.
 *
 * For more information please see <http://www.rasdaman.org>
 * or contact Peter Baumann via <baumann@rasdaman.com>.
*/

package petascope.core;

import java.math.BigDecimal;

/**
 * Model class to store bbox values from WCPS encode()
 * 
 * WCPS: encode(c) with c bounding box is (Lat (0:20), Long(20:30) and crs is EPSG:4326)
 * translates to
 * Rasql: select(...., {\"geoReference\": 
 *                          { \"bbox\": { \"xmin\": 20, \"xmax\": 30, \"ymin\": 0, \"ymax\": 20},
 *                     \"crs\": \"EPSG:4326\" } })
 * 
 * NOTE:  if nodata= 1 single value, it will be applied to all bands,
 *        and if nodata = array of values then each value is applied to each band separately.
 * 
 * @author <a href="mailto:bphamhuu@jacobs-university.net">Bang Pham Huu</a>
 */
public class BoundingBox {
    
    public BoundingBox() {
        
    }
    
    public BoundingBox(BigDecimal xmin, BigDecimal ymin, BigDecimal xmax, BigDecimal ymax) {
        this.xmin = xmin;
        this.ymin = ymin;
        this.xmax = xmax;
        this.ymax = ymax;
    }
    
    public BigDecimal getXMin() {
        return this.xmin;
    }
    
    public BigDecimal getYMin() {
        return this.ymin;
    }
    
    public BigDecimal getXMax() {
        return this.xmax;
    }
    
    public BigDecimal getYMax() {
        return this.ymax;
    }

    public void setXMin(BigDecimal xmin) {
        this.xmin = xmin;
    }

    public void setYMin(BigDecimal ymin) {
        this.ymin = ymin;
    }

    public void setXMax(BigDecimal xmax) {
        this.xmax = xmax;
    }

    public void setYMax(BigDecimal ymax) {
        this.ymax = ymax;
    }
    
    public String toString() {
        return "xmin=" + this.xmin.toPlainString() + ", ymin=" + this.ymin.toPlainString()
                + ", xmax=" + this.xmax.toPlainString() + ", ymax=" + this.ymax.toPlainString();
    }
    
    /**
     * return xmin,ymin,xmax,ymax representation
     */
    public String getRepresentation() {
        return "\"" + this.xmin.toPlainString() + "," + this.ymin.toPlainString() + "," + this.xmax.toPlainString() + "," + this.ymax.toPlainString() + "\"";
    }
    
    /**
     * In case it is needed to swap X for Y bounds.
     */
    public void swapXYOrder() {
        BigDecimal temp = new BigDecimal(this.xmin.toPlainString());
        this.xmin = new BigDecimal(this.ymin.toPlainString());
        this.ymin = temp;
        
        temp = new BigDecimal(this.xmax.toPlainString());
        this.xmax = new BigDecimal(this.ymax.toPlainString());
        this.ymax = temp;
    }
    
    /**
     * Parse a string representation, e.g: xmin,ymin,xmax,ymax to a BoundingBox object
     */
    public static BoundingBox parse(String representation) {
        String[] values = representation.split(",");
        return new BoundingBox(new BigDecimal(values[0]), new BigDecimal(values[1]), new BigDecimal(values[2]), new BigDecimal(values[3]));
    }
    
    /**
     * Check if this BBox intersects an input BBox on X or Y axis
     *       xmin,ymin,xmax,ymax          xmin,ymin,xmax,ymax
     * e.g: [-20, 20,  40,  50] intersects [-10, 30,  30,  40]
     */
    public boolean intersectsXorYAxis(BoundingBox inputBBox) {
        boolean matchX = (this.xmin.compareTo(inputBBox.getXMin()) <= 0 && this.xmax.compareTo(inputBBox.getXMin()) >= 0)
                       || (this.xmin.compareTo(inputBBox.getXMax()) <= 0 && this.xmax.compareTo(inputBBox.getXMax()) >= 0);
        
        boolean matchY = (this.ymin.compareTo(inputBBox.getYMin()) <= 0 && this.ymax.compareTo(inputBBox.getYMin()) >= 0)
                       || (this.ymin.compareTo(inputBBox.getYMax()) <= 0 && this.ymax.compareTo(inputBBox.getYMax()) >= 0);
        
        return matchX || matchY;
        
    }
    
    private BigDecimal xmin;
    private BigDecimal ymin;
    private BigDecimal xmax;
    private BigDecimal ymax;
}
