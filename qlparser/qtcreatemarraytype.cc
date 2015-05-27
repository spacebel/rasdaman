#include "qtcreatemarraytype.hh"
#include "relcatalogif/alltypes.hh"
#include "qtmintervaldata.hh"
#include "qtunaryoperation.hh"

const QtNode::QtNodeType QtCreateMarrayType::nodeType = QtNode::QT_CREATE_MDD_TYPE;

QtCreateMarrayType::QtCreateMarrayType(const std::string &typeName, const std::string cellTypeName, r_Dimension dimensioanlity)
    :typeName (typeName), dimensioanlity(dimensioanlity), domainNode(NULL)
{
    this->cellTypeName = TypeFactory::getInternalTypeFromSyntaxType(cellTypeName);
}

QtCreateMarrayType::QtCreateMarrayType(const std::string &typeName, const std::string cellTypeName, QtOperation *domainNode)
    : typeName(typeName), domainNode(domainNode)
{
    this->cellTypeName = TypeFactory::getInternalTypeFromSyntaxType(cellTypeName);
}

QtData* QtCreateMarrayType::evaluate()
{
    // at this point we know that all values are valid (they are checked in checkType)
    const BaseType* catBaseType = (BaseType*) TypeFactory::mapType(this->cellTypeName.c_str());

    const MDDType* mddType;
    // if no domain is specified then we have a dimension type
    // otherwise we have a domain type
    if (this->domainNode == NULL)
    {
        mddType = new MDDDimensionType(this->typeName.c_str(), catBaseType, this->dimensioanlity);
    }
    else
    {
        QtMintervalData* domain = (QtMintervalData*) this->domainNode->evaluate(NULL);
        mddType = new MDDDomainType(this->typeName.c_str(), catBaseType, domain->getMintervalData());
        delete domain;
    }

    TypeFactory::addMDDType(mddType);
}


void QtCreateMarrayType::checkType()
{
    // Check if type exists and throw exception if it exists
    if (TypeFactory::mapMDDType(this->typeName.c_str()) != NULL)
    {
        parseInfo.setErrorNo(969);
        parseInfo.setToken(this->typeName.c_str());
        throw parseInfo;
    }

    // Check if the cell type exists and throw exception if not
    if (TypeFactory::mapType(this->cellTypeName.c_str()) == NULL)
    {
        parseInfo.setErrorNo(971);
        parseInfo.setToken(this->cellTypeName.c_str());
        throw parseInfo;
    }

    // Check if the dimensionality is < 1 or if the specified domain is valid
    if (this->domainNode == NULL && this->dimensioanlity < 1)
    {
        parseInfo.setErrorNo(972);
        if (this->domainNode == NULL)
        {
            std::ostringstream ss;
            ss << std::dec << this->dimensioanlity;
            parseInfo.setToken(ss.str().c_str());
        }
        throw parseInfo;
    }
    else if (this->domainNode != NULL)
    {
        this->domainNode->checkType();
    }

}

void QtCreateMarrayType::printTree(int tab, std::ostream &s, QtChildType mode)
{
    s << SPACE_STR(tab).c_str() << "QtCreateMarrayType Object" << std::endl;
    s << SPACE_STR(tab).c_str() << "  CREATE TYPE " << typeName << " UNDER MARRAY { " << cellTypeName << " }, ";
    if (domainNode == NULL)
    {
        s << dimensioanlity;
    }
    else
    {
        domainNode->printTree(tab + 1, s);
    }

}

void QtCreateMarrayType::printAlgebraicExpression(std::ostream &s)
{
    s << "command <";
    s << "CREATE TYPE " << typeName << " UNDER MARRAY { " << cellTypeName << " }, ";
    if (domainNode == NULL)
    {
        s << dimensioanlity;
    }
    else
    {
        domainNode->printAlgebraicExpression(s);
    }
    s << ">";
}

QtNode::QtNodeType QtCreateMarrayType::getNodeType() const
{
    return nodeType;
}
