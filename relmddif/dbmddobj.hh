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
#ifndef _DBMDDOBJ_HH_
#define _DBMDDOBJ_HH_

#include "mddid.hh"
#include "raslib/mddtypes.hh"
#include "raslib/nullvalues.hh"
#include "reladminif/dbobject.hh"
#include "reladminif/dbref.hh"
#include "relblobif/tileid.hh"
#include "relindexif/indexid.hh"
#include "relstorageif/dbstoragelayout.hh"
#include "relstorageif/storageid.hh"
#include <iosfwd>

class BaseType;
class MDDBaseType;
class DBNullvalues;

//@ManMemo: Module: relmddif
/**
 * A DBMDDObj object links all neccessary persistent data for an MDD object.
 * One DBMDDObj can be inserted in multiple MDD Collections. It will only be
 * deleted from the database when there are no more references in MDD
 * collections. This is done through persistent reference counting.
 *
 * The DBMDDObj stores the following data:
 * 
 * - MDDBaseType: type information on the data that is stored in it.
 * - Definition domain: the spatial domain this object may extend to.  This
 *   domain may have open boundaries.
 * - Index: a refernce to the index which holds the actual data.
 * - Storagelayout: has asorted methods for modifying how the data is stored in 
 *   the database.
 * 
 * The definition domain is stored in an extensible but inefficient way.
 */
/**
  * \defgroup Relmddifs Relmddif Classes
  */
class DBMDDObj : public DBObject
{
public:
    DBMDDObj(const MDDBaseType *type, const r_Minterval &domain,
             const DBObjectId &newObjIx, const DBStorageLayoutId &newSL,
             const OId &theMDDObj);
    /*@Doc:
       @param type it contains the basetype which will be used to create perstiles.
       @param domain the definition domain.  the extend to which the mdd object may grow.
       @param newObjIx the index structure which should be used.  there has to be some way to use DBRef<IndexDS>.
       @param newSL the storage layout object.
       @param theMDDObj this oid may not be assigned to an mdd object yet!
    */

    DBMDDObj(const MDDBaseType *newMDDType, const r_Minterval &domain,
             const DBObjectId &newObjIx, const DBStorageLayoutId &newSL);
    /*@Doc:
    The oid is generated by the object itself.

       @param newMDDType it contains the basetype which will be used to create perstiles.
       @param domain the definition domain.  the extend to which the mdd object may grow.
       @param newObjIx the index structure which should be used.  there has to be some way to use DBRef<IndexDS>.
       @param newSL the storage layout object.
    */

    DBMDDObj(const DBMDDObj &old) = delete;

    ~DBMDDObj() noexcept(false) override;
    /*@Doc:
        Validates the object and deletes the definition domain.
    */

    const MDDBaseType *getMDDBaseType() const;
    /*@Doc:
        return the mddbasetype for this object.
    */

    DBStorageLayoutId getDBStorageLayout() const;
    /*@Doc:
        return the storage layout object for this mdd object.
    */

    const char *getCellTypeName() const;
    /*@Doc:
        Returns the name of the base type of this MDD object cells.
    */

    const BaseType *getCellType() const;
    /*@Doc:
        Returns the base type of this MDD object cells.
    */

    r_Dimension dimensionality() const;
    /*@Doc:
        Returns dimensionality of the object.
    */

    r_Minterval getDefinitionDomain() const;
    /*@Doc:
        Returns the definition domain of the object.
    */

    void printStatus(unsigned int level, std::ostream &stream) const override;
    /*@Doc:
        Prints the status of the object:
        the name of the cell type
        the definition domain
        the index contents
    */

    void setIx(const DBObjectId &newObjIx);
    /*@Doc:
        make the mdd object use newObjIx instead of its old index structure.
        the old index structure is not deleted from the database!
    */

    DBObjectId getDBIndexDS() const;
    /*@Doc:
        Returns the reference to the index.
    */

    void setPersistent(bool t = true) override;
    /*@Doc:
        Was overridden to pass changes to definition domain, storage layout  and
        to the index.
    */

    void setCached(bool ic) override;
    /*@Doc:
        overrides DBObject to handle the DBMinterval
    */

    void incrementPersRefCount();
    /*@Doc:
        used by mddset to tell the mddobj that there is an
        additional mddset ref to it
    */

    void decrementPersRefCount();
    /*@Doc:
        used by mddset to tell the mddobj that there is an mddset
        ref less to it
    */

    int getPersRefCount() const;
    /*@Doc:
        returns the number of persistent references to this object.
        when zero, the object may be deleted
    */

    r_Bytes getHeaderSize() const;
    /*@Doc:
        Returns the size of the header for an MDD object.
        The size returned by this funtion is an approximation to
        the size of the actual physical storage space used by the
        base DBMS. In the current implementation:
        HeaderSize = MDDBaseType*Size + r_Minterval*Size +
            DBMDDObjIxSize + DBObjectSize
        This should be reviewed and renamed to
            getPhysicalStorageSize
    */

    r_Bytes getMemorySize() const override;
    /*@Doc:
        Calculates the size of this object in main memory.
    */

    DBNullvalues *getNullValues() const;
    /*@Doc:
    return null values associated with this object
    */

    void setNullValues(const r_Nullvalues &newNullValues);
    /*@Doc:
    associate null values with this object
    */

    void setDbDomain(const r_Minterval &domain);
    /*@Doc:
    updates the domain of this object in the db
    */

protected:
    friend class ObjectBroker;

    DBMDDObj(const OId &id);

    void insertInDb() override;
    void deleteFromDb() override;
    void readFromDb() override;
    void updateInDb() override;

private:
    DBMDDObj();
    /*@Doc:
        creates an empty object and does NOT register it with ObjectBroker.
    */

    int persistentRefCount{};
    /*@Doc:
        number of persistent references (by mddsets) to this object
    */

    const MDDBaseType *mddType{NULL};
    /*@Doc:
        Type of this object.
    */

    DBMinterval *myDomain{NULL};
    /*@Doc:
        Definition domain for the object.
    */

    DBNullvalues *nullValues{NULL};
    /*@Doc:
        null values
    */

    DBStorageLayoutId storageLayoutId;
    /*@Doc:
        StorageLayout OId
    */

    DBObjectId objIxId;
    /*@Doc:
        Index OId
    */
};

#endif
