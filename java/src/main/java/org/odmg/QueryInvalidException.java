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
* Copyright 2003, 2004, 2005, 2006, 2007, 2008, 2009 Peter Baumann /
rasdaman GmbH.
*
* For more information please see <http://www.rasdaman.org>
* or contact Peter Baumann via <baumann@rasdaman.com>.
*/
package org.odmg;

/**
* This exception is thrown if the query is not a valid OQL query.
* @author   David Jordan (as Java Editor of the Object Data Management Group)
* @version ODMG 3.0
*/

public class QueryInvalidException extends QueryException {
    /**
    * Construct an instance of the exception.
    */
    public QueryInvalidException() {
        super();
    }

    /**
    * Construct an instance of the exception.
    * @param    msg A string indicating why the <code>OQLQuery</code> instance does not
    * represent a valid OQL query.
    */
    public QueryInvalidException(String msg) {
        super(msg);
    }
}

