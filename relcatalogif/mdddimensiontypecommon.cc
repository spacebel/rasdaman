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
#include "config.h"
#include "mymalloc/mymalloc.h"
#include "raslib/rmdebug.hh"
#include "mdddimensiontype.hh"
#ifdef __APPLE__
#include <sys/malloc.h>
#else
#include <malloc.h>
#endif
#include "basetype.hh"
#include "mdddomaintype.hh"
#include <iostream>
#include "reladminif/sqlerror.hh"
#include "reladminif/externs.h"
#include "reladminif/objectbroker.hh"
#include <stdio.h>
#include <cstring>

r_Bytes
MDDDimensionType::getMemorySize() const
{
    return MDDBaseType::getMemorySize() + sizeof(r_Dimension);
}

MDDDimensionType::MDDDimensionType(const OId& id) throw (r_Error)
    :   MDDBaseType(id),
        myDimension(0)
{
    RMDBGENTER(4, RMDebug::module_catalogif, "MDDDimensionType", "MDDDimensionType(" << myOId << ")");
    if (objecttype == OId::MDDDIMTYPEOID)
    {
        mySubclass = MDDDIMENSIONTYPE;
        readFromDb();
    }
    RMDBGEXIT(4, RMDebug::module_catalogif, "MDDDimensionType", "MDDDimensionType(" << myOId << ")");
}

MDDDimensionType::MDDDimensionType(const char* newTypeName, const BaseType* newBaseType, r_Dimension newDimension)
    :   MDDBaseType(newTypeName, newBaseType),
        myDimension(newDimension)
{
    objecttype = OId::MDDDIMTYPEOID;
    mySubclass = MDDDIMENSIONTYPE;
}

MDDDimensionType::MDDDimensionType()
    :   MDDBaseType("unnamed mdddimensiontype"),
        myDimension(0)
{
    objecttype = OId::MDDDIMTYPEOID;
    mySubclass = MDDDIMENSIONTYPE;
}

MDDDimensionType::MDDDimensionType(const MDDDimensionType& old)
    :   MDDBaseType(old)
{
    objecttype = OId::MDDDIMTYPEOID;
    myDimension = old.myDimension;
}

MDDDimensionType&
MDDDimensionType::operator=(const MDDDimensionType& old)
{
    // Gracefully handle self assignment
    if (this == &old)
        return *this;
    MDDBaseType::operator=(old);
    myDimension = old.myDimension;
    return *this;
}

char*
MDDDimensionType::getTypeStructure() const
{
    char dimBuf[255];
    sprintf(dimBuf, "%d", myDimension);
    RMDBGENTER(10, RMDebug::module_catalogif, "MDDDimensionType", "getTypeStructure()");
    RMDBGMIDDLE(10, RMDebug::module_catalogif, "MDDDimensionType", "myBaseType at " << myBaseType);
    char* baseType = myBaseType->getTypeStructure();
    RMDBGMIDDLE(10, RMDebug::module_catalogif, "MDDDimensionType", "basetype at " << baseType);
    char* result = static_cast<char*>(mymalloc(12 + strlen(baseType) + strlen(dimBuf)));

    strcpy(result, "marray <");
    strcat(result, baseType);
    strcat(result, ", ");
    strcat(result, dimBuf);
    strcat(result, ">");

    free(baseType);
    RMDBGEXIT(10, RMDebug::module_catalogif, "MDDDimensionType", "getTypeStructure() " << result);
    return result;
}

char* MDDDimensionType::getNewTypeStructure() const
{
    std::ostringstream ss;
    ss << "MARRAY { "
       << TypeFactory::getSyntaxTypeFromInternalType(std::string(myBaseType->getTypeName()))
       << " } , "
       << myDimension;

    std::string result = ss.str();
    return strdup(result.c_str());
}

void
MDDDimensionType::print_status( ostream& s ) const
{
    s << "\tr_Marray" << "<" << myBaseType->getTypeName() << "\t, " << myDimension << ">";
}

r_Dimension
MDDDimensionType::getDimension() const
{
    return myDimension;
}

MDDDimensionType::~MDDDimensionType()
{
    RMDBGENTER(4, RMDebug::module_catalogif, "MDDDimensionType", "~MDDDimensionType() " << myOId);
    validate();
    RMDBGEXIT(4, RMDebug::module_catalogif, "MDDDimensionType", "~MDDDimensionType() " << myOId);
}

int
MDDDimensionType::compatibleWith(const Type* aType) const
{
    RMDBGENTER(5, RMDebug::module_catalogif, "MDDDimensionType", "compatibleWith(" << aType->getName() << ") " << getName());
    int retval = 0;
    if( (static_cast<MDDType*>(const_cast<Type*>(aType)))->getSubtype() != MDDDOMAINTYPE && (static_cast<MDDType*>(const_cast<Type*>(aType)))->getSubtype() != MDDDIMENSIONTYPE )
    {
        RMDBGMIDDLE(6, RMDebug::module_catalogif, "MDDDimensionType", "not a domain- or dimensiontype");
        retval = 0;
    }
    else
    {
        // check BaseType first
        if( ! (myBaseType->compatibleWith((static_cast<MDDBaseType*>(const_cast<Type*>(aType)))->getBaseType())) )
        {
            RMDBGMIDDLE(6, RMDebug::module_catalogif, "MDDDimensionType", "basetypes are not compatible");
            retval = 0;
        }
        else
        {
            // check dimensionality
            if( (static_cast<MDDType*>(const_cast<Type*>(aType)))->getSubtype() == MDDDIMENSIONTYPE )
            {
                RMDBGMIDDLE(6, RMDebug::module_catalogif, "MDDDimensionType", "check for dimension equality");
                retval = (myDimension == (static_cast<MDDDimensionType*>(const_cast<Type*>(aType)))->getDimension());
            }
            else
            {
                if( (static_cast<MDDType*>(const_cast<Type*>(aType)))->getSubtype() == MDDDOMAINTYPE )
                {
                    RMDBGMIDDLE(6, RMDebug::module_catalogif, "MDDDimensionType", "check for dimension equality");
                    retval = ( (const_cast<MDDDimensionType*>(this))->myDimension == (static_cast<MDDDomainType*>(const_cast<Type*>(aType)))->getDomain()->dimension() );
                }
            }
        }
    }
    RMDBGEXIT(5, RMDebug::module_catalogif, "MDDDimensionType", "compatibleWith(" << aType->getName() << ") " << getName() << " " << retval);
    return retval;
}

