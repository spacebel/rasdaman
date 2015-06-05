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
/**
 * SOURCE: mddcoll.cc
 *
 * MODULE: cachetamgr
 * CLASS:  MDDColl
 *
 * COMMENTS:
 *   none
 *
*/

#include "config.h"
#include "mymalloc/mymalloc.h"

#include <iostream>
#include "mddcoll.hh"
#include "mddcolliter.hh"
#include "relmddif/dbmddset.hh"
#include "mddobj.hh"
#include "relmddif/dbmddobj.hh"
#include "reladminif/objectbroker.hh"
#include "raslib/rmdebug.hh"
#include "reladminif/oidif.hh"
#include "relcatalogif/collectiontype.hh"   // from base catalogif DBMS interface module
#include "reladminif/databaseif.hh"
#include "relmddif/dbmddset.hh"
#include "reladminif/eoid.hh"
#include "tilemgr/tile.hh"

#include "relcatalogif/settype.hh"
#include "relcatalogif/mdddomaintype.hh"
#include "relcatalogif/mdddimensiontype.hh"
#include "relcatalogif/alltypes.hh"
#include "catalogmgr/typefactory.hh"

// MDD and SET names required for returning the list of types
// they can be any string and are required just by the internal structure
#define MOCK_MDD_COLLECTION_NAME "RAS_NAMETYPE"
#define MOCK_SET_COLLECTION_NAME "RAS_NAMESETTYPE"


#include <cstring>

MDDColl::MDDColl(const CollectionType* newType, const char* name)
{
    RMDBGONCE(2, RMDebug::module_mddmgr, "MDDColl", "MDDColl(" << newType->getName() << ", " << (name?name:"null") << ") " << (r_Ptr)this);
    const char* theName = name;
    if (theName == NULL)
    {
        theName = "rasdaman temporary collection";
    }
    dbColl = new DBMDDSet(theName, newType);
}

const char*
MDDColl::getName() const
{
    return dbColl->getName();
}

const CollectionType*
MDDColl::getCollectionType() const
{
    return dbColl->getCollType();
}

unsigned long
MDDColl::getCardinality() const
{
    return dbColl->getCardinality();
}

bool
MDDColl::getOId(OId& pOId) const
{
    if (isPersistent())
    {
        pOId = dbColl->getOId();
        return true;
    }
    return false;
}

bool
MDDColl::getEOId(EOId& pEOId) const
{
    if (isPersistent())
    {
        pEOId = dbColl->getEOId();
        return true;
    }
    return false;
}

void
MDDColl::insert(const MDDObj* newObj)
{
    RMDBGIF(0, RMDebug::module_mddmgr, "MDDColl", if (newObj == 0) \
{
    \
    RMInit::dbgOut << "MDDColl::insert(const MDDObj*) assertion failed" << endl; \
    throw r_Error(MDD_NOT_VALID); \
    })
    RMDBGONCE(2, RMDebug::module_mddmgr, "MDDColl", "insert(" << (r_Ptr)newObj << ")")
    dbColl->insert(newObj->getDBMDDObjId());
    insertIntoCache(newObj);
    RMDBGIF(2, RMDebug::module_mddmgr, "MDDColl", dbColl->printStatus(0, RMInit::dbgOut);)
}

void
MDDColl::releaseAll()
{
    MDDObj* tempMDD = 0;
    while (!mddCache.empty())
    {
        tempMDD = (*mddCache.begin()).second;
        (*mddCache.begin()).second = NULL;
        delete tempMDD;
        mddCache.erase(mddCache.begin());
    }
}

MDDColl::~MDDColl()
{
    RMDBGONCE(2, RMDebug::module_mddmgr, "MDDColl", "~MDDColl() " << (r_Ptr)this);
    if (isPersistent())
        releaseAll();
    //else released by release transfer structures
}

MDDColl::MDDColl(const DBMDDSetId& coll)
    :dbColl(coll)
{
}

DBMDDSetId
MDDColl::getDBMDDSet() const
{
    return dbColl;
}

void
MDDColl::insertIntoCache(const MDDObj* objToInsert) const
{
    RMDBGONCE(2, RMDebug::module_mddmgr, "MDDColl", "insertIntoCache(" << (r_Ptr)objToInsert << ")")
    mddCache[objToInsert->getDBMDDObjId().ptr()] = const_cast<MDDObj*>(objToInsert);
}

MDDObj*
MDDColl::getMDDObj(const DBMDDObj* objToGet) const
{
    MDDObj* persMDDObjToGet = NULL;
    MDDObjMap::const_iterator i = mddCache.find(const_cast<DBMDDObj*>(objToGet));
    if (i != mddCache.end())
        persMDDObjToGet = static_cast<MDDObj*>((*i).second);
    else
    {
        persMDDObjToGet = new MDDObj(const_cast<DBMDDObj*>(objToGet));
        insertIntoCache(persMDDObjToGet);
    }
    return persMDDObjToGet;
}

bool
MDDColl::isPersistent() const
{
    return dbColl->isPersistent();
}

void
MDDColl::printStatus(unsigned int level, std::ostream& stream) const
{
    dbColl->printStatus(level, stream);
    char* indent = new char[level*2 +1];
    for (unsigned int j = 0; j < level*2 ; j++)
        indent[j] = ' ';
    indent[level*2] = '\0';
    stream << indent;
    for (MDDObjMap::iterator i = mddCache.begin(); i != mddCache.end(); i++)
    {
        stream << (r_Ptr)(*i).second;
    }
    delete[] indent;
    indent=0;
}

MDDCollIter*
MDDColl::createIterator() const
{
    MDDCollIter* iter = new MDDCollIter(const_cast<MDDColl*>(this));
    return iter;
}

void
MDDColl::remove(const MDDObj* obj)
{
    if (obj != NULL)
    {
        DBMDDObjId t2 = obj->getDBMDDObjId();
        dbColl->remove(t2);

        //remove from cache ;(
        MDDObjMap::iterator i = mddCache.find(t2.ptr());
        if(i != mddCache.end())
        {
            RMDBGONCE(2, RMDebug::module_mddmgr, "MDDColl", "remove(" << (r_Ptr)obj << ") found in cache")
            mddCache.erase(i);
        }
        else
        {
            RMDBGONCE(0, RMDebug::module_mddmgr, "MDDColl", "remove(" << (r_Ptr)obj << ") not in collection cache")
        }
    }
    else
    {
        RMDBGONCE(0, RMDebug::module_mddmgr, "MDDColl", "remove(MDDObj*) NULL");
        throw r_Error(MDD_NOT_VALID);
    }
}

/*
void
MDDColl::removeFromCache(const PersMDDObj* objToRemove)
    {
    DBMDDObj* objIdVoidAddress = objToRemove->getDBMDDObjId().ptr();
    MDDObjMap::iterator i = mddCache.find(objIdVoidAddress);

    if (i != mddCache.end())
        {
        persMDDObjToRemove = (*i).second;
        (*i).second = NULL;
        delete persMDDObjToRemove;
        mddCache.erase(i);
        RMDBGIF(0, RMDebug::module_mddmgr, "MDDColl", \
            if (mddCache.find(objIdVoidAddress) != mddCache.end()) \
                { \
                RMInit::dbgOut << "MDDColl::removeMDDObjfromCache() object multiple times in cache" << endl; \
                throw r_Error(MDD_EXISTS_MULTIPLE_TIMES); \
                })
        }
    else    {
        RMDBGONCE(0, RMDebug::module_mddmgr, "MDDColl", "removeMDDObjfromCache(" << objToRemove << ") not in collection")
        }
    }
*/

void
MDDColl::removeAll()
{
    dbColl->removeAll();
}


const char*
MDDColl::AllCollectionnamesName = "RAS_COLLECTIONNAMES";

const char*
MDDColl::AllStructTypesName = "RAS_STRUCT_TYPES";

const char*
MDDColl::AllMarrayTypesName = "RAS_MARRAY_TYPES";

const char*
MDDColl::AllSetTypesName = "RAS_SET_TYPES";

MDDColl*
MDDColl::createMDDCollection(const char* name, const CollectionType* ct) throw (r_Error)
{
    if (name == NULL)
    {
        RMDBGONCE(0, RMDebug::module_mddmgr, "MDDColl", "createMDDColl(NULL, colltype)")
        throw r_Error(r_Error::r_Error_NameNotUnique);
    }
    if (ct == NULL)
    {
        RMDBGONCE(0, RMDebug::module_mddmgr, "MDDColl", "createMDDColl(" << name << ", NULL)")
        throw r_Error(COLLTYPE_NULL);
    }
    if (!ct->isPersistent())
    {
        r_Error t(209);
        t.setTextParameter("type", ct->getName());
        RMDBGONCE(0, RMDebug::module_mddmgr, "MDDColl", "createMDDColl(" << name << ", " << ct->getName() << " not persistent)")
        throw t;
    }
    // may generate an exception:
    DBMDDSetId newDBColl = new DBMDDSet(name, ct);
    return new MDDColl(newDBColl);
}

MDDColl*
MDDColl::createMDDCollection(const char* name, const OId& o, const CollectionType* ct) throw (r_Error)
{
    // may generate an exception:
    if (name == NULL)
    {
        RMDBGONCE(0, RMDebug::module_mddmgr, "MDDColl", "createMDDColl(NULL, " << o << ", colltype)")
        throw r_Error(r_Error::r_Error_NameNotUnique);
    }
    if (ct == NULL)
    {
        RMDBGONCE(0, RMDebug::module_mddmgr, "MDDColl", "createMDDColl(" << name << ", " << o << ", NULL)")
        throw r_Error(COLLTYPE_NULL);
    }
    if (!ct->isPersistent())
    {
        r_Error t(209);
        t.setTextParameter("type", ct->getName());
        RMDBGONCE(0, RMDebug::module_mddmgr, "MDDColl", "createMDDColl(" << name << ", " << o << ", " << ct->getName() << " not persistent)")
        throw t;
    }
    DBMDDSetId newDBColl = new DBMDDSet(name, o, ct);
    return new MDDColl(newDBColl);
}

bool
MDDColl::dropMDDCollection(const char* name)
{
    return DBMDDSet::deleteDBMDDSet(name);
}

bool
MDDColl::dropMDDCollection(const OId& o)
{
    return DBMDDSet::deleteDBMDDSet(o);
}

MDDColl*
MDDColl::getMDDCollection(const OId& collOId) throw (r_Error)
{
    RMDBGENTER(2, RMDebug::module_mddmgr, "MDDColl", "getMDDCollection(" << collOId << ")")
    DBMDDSetId t(collOId);
    //this will throw an exception
    t->isModified();
    MDDColl* retval = new MDDColl(t);
    RMDBGEXIT(2, RMDebug::module_mddmgr, "MDDColl", "getMDDCollection(" << collOId << ") " << retval)
    return retval;
}

MDDColl*
MDDColl::getMDDCollection(const char* collName) throw (r_Error)
{
    RMDBGENTER(2, RMDebug::module_mddmgr, "MDDColl", "getMDDCollection(" << collName << ")")
    MDDColl* retval = 0;
    DBMDDSetId dbset;
    if (strcmp(collName, AllCollectionnamesName) == 0)
    {
        // the domains are required because rasql returns only arrays
        // since our result is a string it can be returned as a 1D char array
        r_Minterval transDomain("[0:*]");
        r_Minterval nameDomain("[0:0]");
        const BaseType* bt = TypeFactory::mapType("Char");
        MDDDomainType* mt = new MDDDomainType(MOCK_MDD_COLLECTION_NAME, bt, transDomain);
        TypeFactory::addTempType(mt);
        CollectionType* ct = new SetType(MOCK_SET_COLLECTION_NAME, mt);
        TypeFactory::addTempType(ct);
        retval = new MDDColl(ct, AllCollectionnamesName);
        OIdSet* list = ObjectBroker::getAllObjects(OId::MDDCOLLOID);
        MDDObj* transObj = 0;
        boost::shared_ptr<Tile> transTile;
        char* transName = 0;
        const char* nameBuffer = 0;
        size_t namelen = 0;
        while (!list->empty())
        {
            dbset = *(list->begin());
            RMDBGMIDDLE(2, RMDebug::module_mddmgr, "MDDColl", "Coll OId     : " << dbset.getOId())
            nameBuffer = dbset->getName();
            RMDBGMIDDLE(2, RMDebug::module_mddmgr, "MDDColl", "Coll Name    : " << nameBuffer)
            namelen = strlen(nameBuffer);
            RMDBGMIDDLE(2, RMDebug::module_mddmgr, "MDDColl", "Coll Name Len: " << namelen)
            transName = static_cast<char*>(mymalloc(sizeof(char) * (namelen + 1)));
            memset(transName, 0, namelen + 1);
            strcpy(transName, nameBuffer);
            RMDBGMIDDLE(2, RMDebug::module_mddmgr, "MDDColl", "Domain       : " << namelen)
            nameDomain[0].set_high(static_cast<r_Range>(namelen));
            transObj = new MDDObj(mt, nameDomain);
            transTile.reset(new Tile(nameDomain, bt, transName, 0, r_Array));
            transObj->insertTile(transTile);
            retval->insert(transObj);
            list->erase(list->begin());
        }
        delete list;
    }
    else if (strcmp(collName, AllStructTypesName) == 0)
    {
        // the domains are required because rasql returns only arrays
        // since our result is a string it can be returned as a 1D char array
        r_Minterval transDomain("[0:*]");
        r_Minterval nameDomain("[0:0]");
        const BaseType* bt = TypeFactory::mapType(CharType::Name);
        MDDDomainType* mt = new MDDDomainType(MOCK_MDD_COLLECTION_NAME, bt, transDomain);
        TypeFactory::addTempType(mt);
        CollectionType* ct = new SetType(MOCK_SET_COLLECTION_NAME, mt);
        TypeFactory::addTempType(ct);
        retval = new MDDColl(ct, AllStructTypesName);

        TypeIterator<StructType> structIter = TypeFactory::createStructIter();
        MDDObj* transObj = 0;
        Tile* transTile = 0;

        while (structIter.not_done())
        {
            StructType* typePtr       = structIter.get_element();
            char*       typeStructure = typePtr->getNewTypeStructure();

            std::string result = "";
            result.append("CREATE TYPE ");
            result.append(typePtr->getTypeName());
            result.append(" UNDER ");
            result.append(typeStructure);

            nameDomain[0].set_high(static_cast<r_Range>(result.length()));
            transObj = new MDDObj(mt, nameDomain);
            transTile = new Tile(nameDomain, bt, result.c_str(), 0, r_Array);
            transObj->insertTile(transTile);
            retval->insert(transObj);

            free( typeStructure );
            typeStructure = NULL;

            structIter.advance();
        }
    }
    else if (strcmp(collName, AllMarrayTypesName) == 0)
    {
        // the domains are required because rasql returns only arrays
        // since our result is a string it can be returned as a 1D char array
        r_Minterval transDomain("[0:*]");
        r_Minterval nameDomain("[0:0]");
        const BaseType* bt = TypeFactory::mapType(CharType::Name);
        MDDDomainType* mt = new MDDDomainType(MOCK_MDD_COLLECTION_NAME, bt, transDomain);
        TypeFactory::addTempType(mt);
        CollectionType* ct = new SetType(MOCK_SET_COLLECTION_NAME, mt);
        TypeFactory::addTempType(ct);
        retval = new MDDColl(ct, AllMarrayTypesName);

        TypeIterator<StructType> structIter = TypeFactory::createStructIter();
        MDDObj* transObj = 0;
        Tile* transTile = 0;

        TypeIterator<MDDType> mddIter = TypeFactory::createMDDIter();

        while (mddIter.not_done())
        {
            MDDType* typePtr = mddIter.get_element();
            char* typeStructure = typePtr->getNewTypeStructure();

            std::string result = "";
            result.append("CREATE TYPE ");
            result.append(typePtr->getTypeName());
            result.append(" UNDER ");
            result.append(typeStructure);

            nameDomain[0].set_high(static_cast<r_Range>(result.length()));
            transObj = new MDDObj(mt, nameDomain);
            transTile = new Tile(nameDomain, bt, result.c_str(), 0, r_Array);
            transObj->insertTile(transTile);
            retval->insert(transObj);

            free( typeStructure );
            typeStructure = NULL;

            mddIter.advance();
        }
    }
    else if (strcmp(collName, AllSetTypesName) == 0)
    {
        // the domains are required because rasql returns only arrays
        // since our result is a string it can be returned as a 1D char array
        r_Minterval transDomain("[0:*]");
        r_Minterval nameDomain("[0:0]");
        const BaseType* bt = TypeFactory::mapType(CharType::Name);
        MDDDomainType* mt = new MDDDomainType(MOCK_MDD_COLLECTION_NAME, bt, transDomain);
        TypeFactory::addTempType(mt);
        CollectionType* ct = new SetType(MOCK_SET_COLLECTION_NAME, mt);
        TypeFactory::addTempType(ct);
        retval = new MDDColl(ct, AllSetTypesName);

        TypeIterator<StructType> structIter = TypeFactory::createStructIter();
        MDDObj* transObj = 0;
        Tile* transTile = 0;

        TypeIterator<SetType> setIter = TypeFactory::createSetIter();
        while (setIter.not_done())
        {
            SetType* typePtr       = setIter.get_element();

            std::string result = "";
            result.append("CREATE TYPE ");
            result.append(typePtr->getTypeName());
            result.append(" UNDER SET { ");
            result.append(typePtr->getMDDType()->getTypeName());
            result.append(" }");

            DBMinterval* nullValues = typePtr->getNullValues();
            if (nullValues)
            {
                result.append(" NULL VALUES ");
                result.append(nullValues->get_string_representation());
            }

            nameDomain[0].set_high(static_cast<r_Range>(result.length()));
            transObj = new MDDObj(mt, nameDomain);
            transTile = new Tile(nameDomain, bt, result.c_str(), 0, r_Array);
            transObj->insertTile(transTile);
            retval->insert(transObj);

            setIter.advance();
        }

    }
    else
    {
        dbset = DBMDDSet::getDBMDDSet(collName);
        retval = new MDDColl(dbset);
    }
    RMDBGEXIT(2, RMDebug::module_mddmgr, "MDDColl", "getMDDCollection(" << collName << ") " << retval)
    return retval;
}

bool
MDDColl::removeMDDObject(const OId& collOId, const OId& mddOId)
{
    bool retval = true;
    DBMDDSetId coll(collOId);
    DBMDDObjId mdd(mddOId);

    if (coll.is_null())
    {
        //does not exist
        retval = false;
    }
    else
    {
        if (mdd.is_null())
        {
            retval = false;
        }
        else
        {
            coll->remove(mdd);
        }
    }
    return retval;
}

