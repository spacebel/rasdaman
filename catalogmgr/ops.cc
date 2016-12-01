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
static const char rcsid[] = "@(#)catalogif,ops.cc: $Header: /home/rasdev/CVS-repository/rasdaman/catalogmgr/ops.cc,v 1.67 2003/12/20 23:41:27 rasdev Exp $";

#include "config.h"
#include <limits.h>
#include <string.h> // memcpy()
#ifdef __APPLE__
#include <sys/malloc.h> // malloc()
#include <float.h>
#else
#include <malloc.h> // malloc()
#include <values.h>
#include <cmath>
#endif
#include "ops.hh"
#include "relcatalogif/alltypes.hh"
#include "reladminif/objectbroker.hh"
#include "typefactory.hh"
#include "raslib/point.hh"
#include <easylogging++.h>

//-----------------------------------------------
//  getUnaryOp
//-----------------------------------------------
UnaryOp* Ops::getUnaryOp(Ops::OpType op, const BaseType* resType, const BaseType* opType, unsigned int resOff, unsigned int opOff)
{

#ifndef NO_OPT_OPS
/////////////////////////////////////////////
    if (resType->getType() == opType->getType() && resType->getSize() == 1 && resType->getType() != STRUCT)
    {
        switch (op)
        {
        case Ops::OP_IDENTITY:
            return new OpIDENTITYChar(resType, opType, resOff, opOff);
        default:
            break;
        }
    }
    if (resType->getType() == opType->getType() && resType->getSize() == 2 && resType->getType() != STRUCT)
    {
        switch (op)
        {
        case Ops::OP_IDENTITY:
            return new OpIDENTITYShort(resType, opType, resOff, opOff);
        default:
            break;
        }
    }
    if (resType->getType() == opType->getType() && resType->getSize() == 4 && resType->getType() != STRUCT)
    {
        switch (op)
        {
        case Ops::OP_IDENTITY:
            return new OpIDENTITYLong(resType, opType, resOff, opOff);
        default:
            break;
        }
    }
/////////////////////////////////////////////
#endif

    // cast operations
    if (op > Ops::OP_CAST_BEGIN && op < Ops::OP_CAST_END)
    {
        if (opType->getType() <= NUMERICAL_TYPES_END)
        {
            return new OpCAST(resType, opType, resOff, opOff);
        }

        else if (opType->getType() == STRUCT)
        {
            if (resType->getType() == STRUCT &&
                    ((StructType*)const_cast<BaseType*>(resType))->getNumElems() != ((StructType*)const_cast<BaseType*>(opType))->getNumElems())
            {
                return 0;
            }
            else
            {
                return new OpUnaryStruct(resType, opType, op, resOff, opOff);
            }
        }
        else
        {
            return 0;
        }
    }

    // all Char
    if (resType->getType() == BOOLTYPE && opType->getType() == BOOLTYPE)
    {
        switch (op)
        {
        case Ops::OP_NOT:
            return new OpNOTBool(resType, opType, resOff, opOff);
        default:
            break;
        }
    }
    if ((resType->getType() >= ULONG && resType->getType() <= BOOLTYPE) && (opType->getType() >= ULONG &&
            opType->getType() <= OCTET))
    {

        switch (op)
        {
        case Ops::OP_NOT:
            return new OpNOTCULong(resType, opType, resOff, opOff);
        case Ops::OP_IDENTITY:
            return new OpIDENTITYCULong(resType, opType, resOff, opOff);
        default:
            return 0;
        }
    }
    // result is LONG, SHORT or OCTET and the only operand between ULONG and OCTET
    if ((resType->getType() == LONG || resType->getType() == SHORT || resType->getType() == OCTET) &&
            (opType->getType() >= ULONG && opType->getType() <= OCTET))
    {

        switch (op)
        {
        case Ops::OP_NOT:
            return new OpNOTCLong(resType, opType, resOff, opOff);
        case Ops::OP_IDENTITY:
            return new OpIDENTITYCLong(resType, opType, resOff, opOff);
        default:
            return 0;
        }
    }

    // result is COMPLEXTYPE1 or COMPLEXTYPE2
    if ((resType->getType() == COMPLEXTYPE1 && opType->getType() == COMPLEXTYPE1) || // remember && has precedence over ||
            (resType->getType() == COMPLEXTYPE2 && opType->getType() == COMPLEXTYPE2))
    {
        return new OpIDENTITYComplex(resType, opType, resOff, opOff);
    }



    // result is FLOAT or DOUBLE and the only operand between ULONG and FLOAT
    if (resType->getType() == FLOAT || (resType->getType() == DOUBLE && opType->getType() >= ULONG && opType->getType() <= FLOAT))
    {

        switch (op)
        {
        case Ops::OP_IDENTITY:
            return new OpIDENTITYCDouble(resType, opType, resOff, opOff);

        case Ops::OP_SQRT:
            return new OpSQRTCDouble(resType, opType, resOff, opOff);
        case Ops::OP_POW:
            return new OpPOWCDouble(resType, opType, resOff, opOff);
        case Ops::OP_ABS:
            return new OpABSCDouble(resType, opType, resOff, opOff);
        case Ops::OP_EXP:
            return new OpEXPCDouble(resType, opType, resOff, opOff);
        case Ops::OP_LOG:
            return new OpLOGCDouble(resType, opType, resOff, opOff);
        case Ops::OP_LN:
            return new OpLNCDouble(resType, opType, resOff, opOff);
        case Ops::OP_SIN:
            return new OpSINCDouble(resType, opType, resOff, opOff);
        case Ops::OP_COS:
            return new OpCOSCDouble(resType, opType, resOff, opOff);
        case Ops::OP_TAN:
            return new OpTANCDouble(resType, opType, resOff, opOff);
        case Ops::OP_SINH:
            return new OpSINHCDouble(resType, opType, resOff, opOff);
        case Ops::OP_COSH:
            return new OpCOSHCDouble(resType, opType, resOff, opOff);
        case Ops::OP_TANH:
            return new OpTANHCDouble(resType, opType, resOff, opOff);
        case Ops::OP_ARCSIN:
            return new OpARCSINCDouble(resType, opType, resOff, opOff);
        case Ops::OP_ARCCOS:
            return new OpARCCOSCDouble(resType, opType, resOff, opOff);
        case Ops::OP_ARCTAN:
            return new OpARCTANCDouble(resType, opType, resOff, opOff);

        case Ops::OP_REALPART:
            return new OpRealPart(resType, opType, resOff, opOff);
        case Ops::OP_IMAGINARPART:
            return new OpImaginarPart(resType, opType, resOff, opOff);

        default:
            return 0;
        }
    }

    // retriving real or imaginar parts of a complex argument
    if (resType->getType() == DOUBLE && (opType->getType() == COMPLEXTYPE1 || opType->getType() == COMPLEXTYPE2))
    {
        switch (op)
        {
        case Ops::OP_REALPART:
            return new OpRealPart(resType, opType, resOff, opOff);

        case Ops::OP_IMAGINARPART:
            return new OpImaginarPart(resType, opType, resOff, opOff);

        default:
            return 0;
        }
    }

    if ((resType->getType() == COMPLEXTYPE1 && opType->getType() == COMPLEXTYPE1) || // remember && has precedence over ||
            (resType->getType() == COMPLEXTYPE2 && opType->getType() == COMPLEXTYPE2))
    {
        return new OpIDENTITYComplex(resType, opType, resOff, opOff);
    }

    if (resType->getType() == STRUCT && resType->compatibleWith(opType))
    {

#ifndef NO_OPT_IDENTITY_STRUCT
/////////////////////////////
        switch (op)
        {
        case Ops::OP_IDENTITY:
            return new OpIDENTITYStruct(resType, opType, resOff, opOff);
        default:
/////////////////////////////
#endif
            return new OpUnaryStruct(resType, opType, op, resOff, opOff);

#ifndef NO_OPT_IDENTITY_STRUCT
/////////////////////////////
        }
/////////////////////////////
#endif

    }
    return 0;
}

BinaryOp*
Ops::getBinaryOp(Ops::OpType op, const BaseType* resType, const BaseType* op1Type,
                 const BaseType* op2Type, unsigned int resOff,
                 unsigned int op1Off, unsigned int op2Off)
{
// if this flag is set, optimized operation execution for Char
// is turned off.
#ifndef NO_OPT_OPS
    // all Char
    if (resType->getType() == CHAR && op1Type->getType() == CHAR &&
            op2Type->getType() == CHAR)
    {
        switch (op)
        {
        case Ops::OP_PLUS:
            return new OpPLUSChar(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_MINUS:
            return new OpMINUSChar(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_MAX_BINARY:
            return new OpMAX_BINARYChar(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_MIN_BINARY:
            return new OpMIN_BINARYChar(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_DIV:
            return new OpDIVChar(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_MULT:
            return new OpMULTChar(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_INTDIV:
            return new OpDIVChar(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_MOD:
            return new OpMODChar(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        default:
            break;
        }
    }
#endif
    if ((resType->getType() == op1Type->getType()) && (resType->getType() == op2Type->getType()) && (op == Ops::OP_OVERLAY))
    {
        return new OpOVERLAY(resType, op1Type, op2Type, resType->getSize(), OpOVERLAY::nullPattern, resOff, op1Off, op2Off);
    }

    // all Bool
    if (resType->getType() == BOOLTYPE && op1Type->getType() == BOOLTYPE &&
            op2Type->getType() == BOOLTYPE)
    {
        switch (op)
        {
        case Ops::OP_AND:
            return new OpANDBool(resType, op1Type, op2Type, resOff, op1Off,
                                 op2Off);
        case Ops::OP_OR:
            return new OpORBool(resType, op1Type, op2Type, resOff, op1Off,
                                op2Off);
        case Ops::OP_XOR:
            return new OpXORBool(resType, op1Type, op2Type, resOff, op1Off,
                                 op2Off);
        default:
            break;
        }
    }
    // result is unsigned integer
    if ((resType->getType() >= ULONG && resType->getType() <= BOOLTYPE) &&
            (op1Type->getType() >= ULONG && op1Type->getType() <= OCTET) &&
            (op2Type->getType() >= ULONG && op2Type->getType() <= OCTET))
    {
        switch (op)
        {
        case Ops::OP_PLUS:
            return new OpPLUSCULong(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_MINUS:
            return new OpMINUSCULong(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_MAX_BINARY:
            return new OpMAX_BINARYCULong(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_MIN_BINARY:
            return new OpMIN_BINARYCULong(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_DIV:
            return new OpDIVCULong(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_INTDIV:
            return new OpDIVCULong(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_MOD:
            return new OpMODCULong(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_MULT:
            return new OpMULTCULong(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_AND:
            return new OpANDCULong(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_OR:
            return new OpORCULong(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        case Ops::OP_XOR:
            return new OpXORCULong(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        default:
            break;
        }
    }
    // result is signed integer
    if ((resType->getType() == LONG || resType->getType() == SHORT ||
            resType->getType() == OCTET) &&
            (op1Type->getType() >= ULONG && op1Type->getType() <= OCTET) &&
            (op2Type->getType() >= ULONG && op2Type->getType() <= OCTET))
    {
        switch (op)
        {
        case Ops::OP_PLUS:
            return new OpPLUSCLong(resType, op1Type, op2Type, resOff, op1Off,
                                   op2Off);
        case Ops::OP_MINUS:
            return new OpMINUSCLong(resType, op1Type, op2Type, resOff, op1Off,
                                    op2Off);
        case Ops::OP_MAX_BINARY:
            return new OpMAX_BINARYCLong(resType, op1Type, op2Type, resOff, op1Off,
                                         op2Off);
        case Ops::OP_MIN_BINARY:
            return new OpMIN_BINARYCLong(resType, op1Type, op2Type, resOff, op1Off,
                                         op2Off);
        case Ops::OP_DIV:
            return new OpDIVCLong(resType, op1Type, op2Type, resOff, op1Off,
                                  op2Off);
        case Ops::OP_INTDIV:
            return new OpDIVCLong(resType, op1Type, op2Type, resOff, op1Off,
                                  op2Off);
        case Ops::OP_MOD:
            return new OpMODCLong(resType, op1Type, op2Type, resOff, op1Off,
                                  op2Off);
        case Ops::OP_MULT:
            return new OpMULTCLong(resType, op1Type, op2Type, resOff, op1Off,
                                   op2Off);
        case Ops::OP_AND:
            return new OpANDCLong(resType, op1Type, op2Type, resOff, op1Off,
                                  op2Off);
        case Ops::OP_OR:
            return new OpORCLong(resType, op1Type, op2Type, resOff, op1Off,
                                 op2Off);
        case Ops::OP_XOR:
            return new OpXORCLong(resType, op1Type, op2Type, resOff, op1Off,
                                  op2Off);
        default:
            break;
        }
    }
    // result is float or double
    if ((resType->getType() == FLOAT || resType->getType() == DOUBLE) &&
            (op1Type->getType() >= ULONG && op1Type->getType() <= FLOAT) &&
            (op2Type->getType() >= ULONG && op2Type->getType() <= FLOAT))
    {
        switch (op)
        {
        case Ops::OP_PLUS:
            return new OpPLUSCDouble(resType, op1Type, op2Type, resOff, op1Off,
                                     op2Off);
        case Ops::OP_MINUS:
            return new OpMINUSCDouble(resType, op1Type, op2Type, resOff, op1Off,
                                      op2Off);
        case Ops::OP_MAX_BINARY:
            return new OpMAX_BINARYCDouble(resType, op1Type, op2Type, resOff, op1Off,
                                           op2Off);
        case Ops::OP_MIN_BINARY:
            return new OpMIN_BINARYCDouble(resType, op1Type, op2Type, resOff, op1Off,
                                           op2Off);
        case Ops::OP_DIV:
            return new OpDIVCDouble(resType, op1Type, op2Type, resOff, op1Off,
                                    op2Off);
        case Ops::OP_MULT:
            return new OpMULTCDouble(resType, op1Type, op2Type, resOff, op1Off,
                                     op2Off);
        default:
            break;
        }
    }


//*************************************************************************************
//                          *** COMPLEXTYPE ***
//************************************************************************************

    // result is complex
    if (resType->getType() == COMPLEXTYPE1 || resType->getType() == COMPLEXTYPE2)
    {
        switch (op)
        {

        case Ops::OP_PLUS:
            if (op1Type->getType() < COMPLEXTYPE1)
            {
                return new OpPLUSComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off, OpPLUSComplex::FIRST);
            }
            else if (op2Type->getType() < COMPLEXTYPE1)
            {
                return new OpPLUSComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off, OpPLUSComplex::SECOND);
            }
            else
            {
                return new OpPLUSComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off);
            }

        case Ops::OP_MINUS:
            if (op1Type->getType() < COMPLEXTYPE1)
            {
                return new OpMINUSComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off, OpMINUSComplex::FIRST);
            }
            else if (op2Type->getType() < COMPLEXTYPE1)
            {
                return new OpMINUSComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off, OpMINUSComplex::SECOND);
            }
            else
            {
                return new OpMINUSComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off);
            }

        case Ops::OP_MAX_BINARY:
            if (op1Type->getType() < COMPLEXTYPE1)
            {
                return new OpMAX_BINARYComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off, OpMAX_BINARYComplex::FIRST);
            }
            else if (op2Type->getType() < COMPLEXTYPE1)
            {
                return new OpMAX_BINARYComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off, OpMAX_BINARYComplex::SECOND);
            }
            else
            {
                return new OpMAX_BINARYComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off);
            }

        case Ops::OP_MIN_BINARY:
            if (op1Type->getType() < COMPLEXTYPE1)
            {
                return new OpMIN_BINARYComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off, OpMIN_BINARYComplex::FIRST);
            }
            else if (op2Type->getType() < COMPLEXTYPE1)
            {
                return new OpMIN_BINARYComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off, OpMIN_BINARYComplex::SECOND);
            }
            else
            {
                return new OpMIN_BINARYComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off);
            }

        case Ops::OP_DIV:
            if (op1Type->getType() < COMPLEXTYPE1)
            {
                return new OpDIVComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off, OpDIVComplex::FIRST);
            }
            else if (op2Type->getType() < COMPLEXTYPE1)
            {
                return new OpDIVComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off, OpDIVComplex::SECOND);
            }
            else
            {
                return new OpDIVComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off);
            }

        case Ops::OP_MULT:
            if (op1Type->getType() < COMPLEXTYPE1)
            {
                return new OpMULTComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off, OpMULTComplex::FIRST);
            }
            else if (op2Type->getType() < COMPLEXTYPE1)
            {
                return new OpMULTComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off, OpMULTComplex::SECOND);
            }
            else
            {
                return new OpMULTComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off);
            }

        case Ops::OP_CONSTRUCT_COMPLEX:
            return new OpConstructComplex(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        default:
            break;
        }
    }

//*************************************************************************************


#ifndef NO_OPT_OPS
    // result is bool, operands are Chars
    if ((resType->getType() == BOOLTYPE) && (op1Type->getType() == CHAR) &&
            (op2Type->getType() == CHAR))
    {
        switch (op)
        {
        case Ops::OP_EQUAL:
            return new OpEQUALChar(resType, op1Type, op2Type, resOff, op1Off,
                                   op2Off);
        case Ops::OP_LESS:
            return new OpLESSChar(resType, op1Type, op2Type, resOff, op1Off,
                                  op2Off);
        case Ops::OP_LESSEQUAL:
            return new OpLESSEQUALChar(resType, op1Type, op2Type, resOff,
                                       op1Off, op2Off);
        case Ops::OP_NOTEQUAL:
            return new OpNOTEQUALChar(resType, op1Type, op2Type, resOff,
                                      op1Off, op2Off);
        case Ops::OP_GREATER:
            return new OpGREATERChar(resType, op1Type, op2Type, resOff,
                                     op1Off, op2Off);
        case Ops::OP_GREATEREQUAL:
            return new OpGREATEREQUALChar(resType, op1Type, op2Type, resOff,
                                          op1Off, op2Off);
        default:
            break;
        }
    }
#endif
    // result is bool
    if ((resType->getType() == BOOLTYPE) &&
            (op1Type->getType() >= ULONG && op1Type->getType() <= BOOLTYPE) &&
            (op2Type->getType() >= ULONG && op2Type->getType() <= BOOLTYPE))
    {
        switch (op)
        {
        case Ops::OP_EQUAL:
            return new OpEQUALCCharCULong(resType, op1Type, op2Type, resOff, op1Off,
                                          op2Off);
        case Ops::OP_LESS:
            return new OpLESSCCharCULong(resType, op1Type, op2Type, resOff, op1Off,
                                         op2Off);
        case Ops::OP_LESSEQUAL:
            return new OpLESSEQUALCCharCULong(resType, op1Type, op2Type, resOff,
                                              op1Off, op2Off);
        case Ops::OP_NOTEQUAL:
            return new OpNOTEQUALCCharCULong(resType, op1Type, op2Type, resOff,
                                             op1Off, op2Off);
        case Ops::OP_GREATER:
            return new OpGREATERCCharCULong(resType, op1Type, op2Type, resOff,
                                            op1Off, op2Off);
        case Ops::OP_GREATEREQUAL:
            return new OpGREATEREQUALCCharCULong(resType, op1Type, op2Type, resOff,
                                                 op1Off, op2Off);
        default:
            break;
        }
    }
    if ((resType->getType() == BOOLTYPE) &&
            (op1Type->getType() >= ULONG && op1Type->getType() <= OCTET) &&
            (op2Type->getType() >= ULONG && op2Type->getType() <= OCTET))
    {
        switch (op)
        {
        case Ops::OP_EQUAL:
            return new OpEQUALCCharCLong(resType, op1Type, op2Type, resOff, op1Off,
                                         op2Off);
        case Ops::OP_LESS:
            return new OpLESSCCharCLong(resType, op1Type, op2Type, resOff, op1Off,
                                        op2Off);
        case Ops::OP_LESSEQUAL:
            return new OpLESSEQUALCCharCLong(resType, op1Type, op2Type, resOff,
                                             op1Off, op2Off);
        case Ops::OP_NOTEQUAL:
            return new OpNOTEQUALCCharCLong(resType, op1Type, op2Type, resOff,
                                            op1Off, op2Off);
        case Ops::OP_GREATER:
            return new OpGREATERCCharCLong(resType, op1Type, op2Type, resOff,
                                           op1Off, op2Off);
        case Ops::OP_GREATEREQUAL:
            return new OpGREATEREQUALCCharCLong(resType, op1Type, op2Type, resOff,
                                                op1Off, op2Off);
        case Ops::OP_BIT:
            return new OpBIT(resType, op1Type, op2Type, resOff, op1Off, op2Off);
        default:
            break;
        }
    }
    if ((resType->getType() == BOOLTYPE) &&
            (op1Type->getType() >= ULONG && op1Type->getType() <= FLOAT) &&
            (op2Type->getType() >= ULONG && op2Type->getType() <= FLOAT))
    {
        switch (op)
        {
        case Ops::OP_EQUAL:
            return new OpEQUALCCharCDouble(resType, op1Type, op2Type, resOff, op1Off,
                                           op2Off);
        case Ops::OP_LESS:
            return new OpLESSCCharCDouble(resType, op1Type, op2Type, resOff, op1Off,
                                          op2Off);
        case Ops::OP_LESSEQUAL:
            return new OpLESSEQUALCCharCDouble(resType, op1Type, op2Type, resOff,
                                               op1Off, op2Off);
        case Ops::OP_NOTEQUAL:
            return new OpNOTEQUALCCharCDouble(resType, op1Type, op2Type, resOff,
                                              op1Off, op2Off);
        case Ops::OP_GREATER:
            return new OpGREATERCCharCDouble(resType, op1Type, op2Type, resOff,
                                             op1Off, op2Off);
        case Ops::OP_GREATEREQUAL:
            return new OpGREATEREQUALCCharCDouble(resType, op1Type, op2Type, resOff,
                                                  op1Off, op2Off);
        default:
            break;
        }
    }
    // comparison of structs
    if ((resType->getType() == BOOLTYPE) &&
            (op1Type->getType() >= STRUCT && op1Type->getType() <= CLASSTYPE) &&
            (op1Type->compatibleWith(op2Type)))
    {
        switch (op)
        {
        case Ops::OP_EQUAL:
            return new OpEQUALStruct(resType, op1Type, op2Type, resOff, op1Off,
                                     op2Off);
        case Ops::OP_NOTEQUAL:
            return new OpNOTEQUALStruct(resType, op1Type, op2Type, resOff, op1Off,
                                        op2Off);
        default:
            break;
        }
    }
    // result is Struct, two operands are structs
    if (resType->getType() == STRUCT && op1Type->getType() == STRUCT &&
            op2Type->getType() == STRUCT)
    {


        if (op >= OP_MINUS && op <= OP_XOR && isApplicableOnStruct(op, op1Type) &&
                resType->compatibleWith(op1Type) && resType->compatibleWith(op2Type))
        {
            return new OpBinaryStruct(resType, op, resOff, op1Off, op2Off);
        }
        else
        {
            return 0;
        }
    }
    // result is Struct, first operand is struct
    if (resType->getType() == STRUCT && op1Type->getType() == STRUCT)
    {
        if (op >= OP_MINUS && op <= OP_XOR &&
                isApplicableOnStructConst(op, op1Type, op2Type))
        {
            return new OpBinaryStructConst(
                       resType, op1Type, op2Type,
                       op,
                       resOff, op1Off, op2Off
                   );
        }
        else
        {
            return 0;
        }
    }
    // result is Struct, second operand is struct
    if (resType->getType() == STRUCT && op2Type->getType() == STRUCT)
    {
        if (op >= OP_MINUS && op <= OP_XOR &&
                isApplicableOnStructConst(op, op2Type, op1Type))
            return new OpBinaryConstStruct(
                       resType, op1Type, op2Type,
                       op,
                       resOff, op1Off, op2Off
                   );
        else
        {
            return 0;
        }
    }
    return 0;
}


//-----------------------------------------------------------------
//  getCondenseOp
//-----------------------------------------------------------------

CondenseOp*
Ops::getCondenseOp(Ops::OpType op, const BaseType* resType, const BaseType* opType, unsigned int resOff, unsigned int opOff)
{
    if (resType->getType() == BOOLTYPE)
    {
        switch (op)
        {
        case Ops::OP_SOME:
            return new OpSOMECChar(resType, opType, resOff, opOff);
        case Ops::OP_ALL:
            return new OpALLCChar(resType, opType, resOff, opOff);
        default:
            break;
        }
    }

    else if (resType->getType() == ULONG && opType->getType() == BOOLTYPE)
    {
        switch (op)
        {
        case Ops::OP_COUNT:
            return new OpCOUNTCChar(resType, opType, resOff, opOff);
        case Ops::OP_SUM:
            return new OpSUMCULong(resType, opType, resOff, opOff);
        default:
            break;
        }
    }

    else if ((resType->getType() >= ULONG && resType->getType() <= BOOLTYPE) &&
             (opType->getType() >= ULONG && opType->getType() <= BOOLTYPE))
    {
        switch (op)
        {
        case Ops::OP_MAX:
            return new OpMAXCULong(resType, opType, resOff, opOff);
        case Ops::OP_MIN:
            return new OpMINCULong(resType, opType, resOff, opOff);
        case Ops::OP_SUM:
            return new OpSUMCULong(resType, opType, resOff, opOff);
        default:
            break;
        }
    }

    else if ((resType->getType() == LONG || resType->getType() == SHORT ||
              resType->getType() == OCTET) && (opType->getType() >= ULONG && opType->getType() <= OCTET))
    {
        switch (op)
        {
        case Ops::OP_MAX:
            return new OpMAXCLong(resType, opType, resOff, opOff);
        case Ops::OP_MIN:
            return new OpMINCLong(resType, opType, resOff, opOff);
        case Ops::OP_SUM:
            return new OpSUMCLong(resType, opType, resOff, opOff);
        default:
            break;
        }
    }
    else if ((resType->getType() == FLOAT || resType->getType() == DOUBLE) &&
             (opType->getType() >= ULONG && opType->getType() <= FLOAT))
    {
        switch (op)
        {
        case Ops::OP_MAX:
            return new OpMAXCDouble(resType, opType, resOff, opOff);
        case Ops::OP_MIN:
            return new OpMINCDouble(resType, opType, resOff, opOff);
        case Ops::OP_SUM:
            return new OpSUMCDouble(resType, opType, resOff, opOff);
        default:
            break;
        }
    }
    else if (resType->getType() == STRUCT)
    {
        // res and op are structs with same structure.
        return new OpCondenseStruct(resType, opType, op, resOff, opOff);
    }
    else if (resType->getType() == COMPLEXTYPE1 || resType->getType() == COMPLEXTYPE2)
    {
        switch (op)
        {
        case Ops::OP_MAX:
            return new OpMAXComplex(resType, opType, resOff, opOff);
        case Ops::OP_MIN:
            return new OpMINComplex(resType, opType, resOff, opOff);
        case Ops::OP_SUM:
            return new OpSUMComplex(resType, opType, resOff, opOff);
        default:
            break;
        }
    }

    return 0;
}


CondenseOp*
Ops::getCondenseOp(Ops::OpType op, const BaseType* resType, char* newAccu,
                   const BaseType* opType, unsigned int resOff, unsigned int opOff)
{
    if (resType->getType() == BOOLTYPE)
    {
        switch (op)
        {
        case Ops::OP_SOME:
            return new OpSOMECChar(resType, newAccu, opType, resOff, opOff);
        case Ops::OP_ALL:
            return new OpALLCChar(resType, newAccu, opType, resOff, opOff);
        default:
            break;
        }
    }
    else if (resType->getType() == ULONG && opType->getType() == BOOLTYPE)
    {
        switch (op)
        {
        case Ops::OP_COUNT:
            return new OpCOUNTCChar(resType, newAccu, opType, resOff, opOff);
        default:
            break;
        }
    }
    else if ((resType->getType() >= ULONG && resType->getType() <= BOOLTYPE) &&
             (opType->getType() >= ULONG && opType->getType() <= BOOLTYPE))
    {
        switch (op)
        {
        case Ops::OP_MAX:
            return new OpMAXCULong(resType, newAccu, opType, resOff, opOff);
        case Ops::OP_MIN:
            return new OpMINCULong(resType, newAccu, opType, resOff, opOff);
        case Ops::OP_SUM:
            return new OpSUMCULong(resType, newAccu, opType, resOff, opOff);
        default:
            break;
        }
    }
    else if ((resType->getType() == LONG || resType->getType() == SHORT ||
              resType->getType() == OCTET) &&
             (opType->getType() >= ULONG && opType->getType() <= OCTET))
    {
        switch (op)
        {
        case Ops::OP_MAX:
            return new OpMAXCLong(resType, newAccu, opType, resOff, opOff);
        case Ops::OP_MIN:
            return new OpMINCLong(resType, newAccu, opType, resOff, opOff);
        case Ops::OP_SUM:
            return new OpSUMCLong(resType, newAccu, opType, resOff, opOff);
        default:
            break;
        }
    }
    else if ((resType->getType() == FLOAT || resType->getType() == DOUBLE) &&
             (opType->getType() >= ULONG && opType->getType() <= FLOAT))
    {
        switch (op)
        {
        case Ops::OP_MAX:
            return new OpMAXCDouble(resType, newAccu, opType, resOff, opOff);
        case Ops::OP_MIN:
            return new OpMINCDouble(resType, newAccu, opType, resOff, opOff);
        case Ops::OP_SUM:
            return new OpSUMCDouble(resType, newAccu, opType, resOff, opOff);
        default:
            break;
        }
    }
    else if (resType->getType() == STRUCT)
    {
        // res and op are structs with same structure.
        return new OpCondenseStruct(resType, newAccu, opType, op, resOff, opOff);
    }
    return 0;
}

//-----------------------------------------------
//  isApplicable
//-----------------------------------------------
int Ops::isApplicable(Ops::OpType op, const BaseType* op1Type, const BaseType* op2Type)
{
    UnaryOp* myUnaryOp;
    BinaryOp* myBinaryOp;
    CondenseOp* myCondenseOp;

    const BaseType* resType = NULL;

    // could be getResType( op, op1Type, op2Type ), but this
    // introduces circular dependency between the two functions.
    // So it is broken here.

    if (op == OP_SOME || op == OP_ALL || (op >= OP_EQUAL && op <= OP_GREATEREQUAL))
    {
        // result must be Bool
        resType = TypeFactory::mapType("Bool");
    }
    else if (op == OP_COUNT)
    {
        resType = TypeFactory::mapType("ULong");
    }

    else if (op > OP_UFUNC_BEGIN && op < OP_UFUNC_END)
    {
        resType = TypeFactory::mapType("Double");
    }

    else if (op > Ops::OP_CAST_BEGIN && op < Ops::OP_CAST_END && op1Type->getType() <= FLOAT
             && op != Ops::OP_CAST_GENERAL)
    {
        const char* typeName[] =
        {
            "Bool", "Char", "Octet", "Short", "UShort",
            "Long", "ULong", "Float", "Double"
        };
        resType = TypeFactory::mapType(typeName[op - OP_CAST_BEGIN - 1]);
    }

    else if (op == OP_BIT)
    {
        resType = TypeFactory::mapType("Bool");
    }
    else if (op == OP_SUM && op1Type->getType() <= CHAR)
    {
        resType = TypeFactory::mapType("ULong");
    }
    else if (op == OP_SUM && op1Type->getType() <= OCTET)
    {
        resType = TypeFactory::mapType("Long");
    }
    else if (op == OP_SUM && op1Type->getType() <= FLOAT)
    {
        resType = TypeFactory::mapType("Double");
    }
    else if (op == OP_SUM && op1Type->getType() == COMPLEXTYPE1)
    {
        resType = TypeFactory::mapType("Complex1");
    }
    else if (op == OP_SUM && op1Type->getType() == COMPLEXTYPE2)
    {
        resType = TypeFactory::mapType("Complex2");
    }

    // unary operations on complex: re, im
    else if (op == OP_REALPART || op == OP_IMAGINARPART)
    {
        if (op1Type->getType() == COMPLEXTYPE1)
        {
            resType = TypeFactory::mapType("Float");
        }
        if (op1Type->getType() == COMPLEXTYPE2)
        {
            resType = TypeFactory::mapType("Double");
        }
    }

    else if (op2Type == 0)
    {
        resType = const_cast<BaseType*>(op1Type);
    }

    else if (op1Type->getType() >= STRUCT && op1Type->getType() <= CLASSTYPE)
        // composite types must be compatible, so just take one of them as
        // result
    {
        resType = const_cast<BaseType*>(op1Type);
    }
    else if (op2Type->getType() >= STRUCT && op2Type->getType() <= CLASSTYPE)
        // composite types must be compatible, so just take one of them as
        // result
    {
        resType = const_cast<BaseType*>(op2Type);
    }


    else if (op1Type->getType() == COMPLEXTYPE2 || op2Type->getType() == COMPLEXTYPE2)
        // if one of the opernds is complex type and the other any atomic type
        // the result should be complex
    {
        resType = TypeFactory::mapType("Complex2");
    }

    else if (op1Type->getType() == COMPLEXTYPE1 || op2Type->getType() == COMPLEXTYPE1)
        // idem
    {
        resType = TypeFactory::mapType("Complex1");
    }

    else if (op >= OP_IS && op <= OP_XOR)
        // result must be long in this case
    {
        resType = TypeFactory::mapType("Long");
    }
    else if (op == OP_MOD || op == OP_INTDIV)
    {
        if (op1Type->getType() == LONG || op2Type->getType() == LONG)
        {
            resType = TypeFactory::mapType("Long");
        }
        else if (op1Type->getType() == ULONG || op2Type->getType() == ULONG)
        {
            resType = TypeFactory::mapType("ULong");
        }
        else if (op1Type->getType() == CHAR || op2Type->getType() == CHAR)
        {
            resType = TypeFactory::mapType("Char");
        }
        else
            // Double is the strongest type anyway
        {
            resType = TypeFactory::mapType("Double");
        }
    }
    else if (op == OP_CONSTRUCT_COMPLEX)
    {
        if (op1Type->getType() <= NUMERICAL_TYPES_END && op2Type->getType() <= NUMERICAL_TYPES_END)
        {
            if (op1Type->getType() == DOUBLE || op2Type->getType() == DOUBLE)
            {
                resType = TypeFactory::mapType("Complex2");
            }
            else if (op1Type->getType() == FLOAT || op2Type->getType() == FLOAT)
            {
                resType = TypeFactory::mapType("Complex1");
            }
            else
            {
                resType = TypeFactory::mapType("Complex2");
            }
        }
    }
    else
        // Double is the strongest type anyway
    {
        resType = TypeFactory::mapType("Double");
    }

    if (op == OP_OVERLAY)
    {
        resType = const_cast<BaseType*>(op1Type);
    }


    // unary or condense operations
    if (op2Type == 0)
    {
        myUnaryOp = getUnaryOp(op, resType, const_cast<BaseType*>(op1Type));
        if (myUnaryOp != 0)
        {
            delete myUnaryOp;
            return 1; // found an unary op
        }
        myCondenseOp = getCondenseOp(op, const_cast<BaseType*>(resType), const_cast<BaseType*>(op1Type));
        if (myCondenseOp != 0)
        {
            delete myCondenseOp;
            return 1;   // found a condense op
        }
        else
        {
            return 0;    // found neither
        }
    }
    else
    {
        myBinaryOp = getBinaryOp(op, resType, const_cast<BaseType*>(op1Type), const_cast<BaseType*>(op2Type));
        if (myBinaryOp != 0)
        {
            delete myBinaryOp;
            return 1;

        }
        else
        {
            return 0;
        }
    }
}


//-----------------------------------------------
//  getResultType
//-----------------------------------------------
const BaseType* Ops::getResultType(Ops::OpType op, const BaseType* op1, const BaseType* op2)
{

    // operations between composite types defined only on compatible types
    if (op == OP_OVERLAY)
    {
        if ((op1->getType() == STRUCT) || (op2->getType() == STRUCT))
        {
            if (op1->compatibleWith(op2))
            {
                return op1;
            }
            else
            {
                return NULL;
            }
        }
        if (op1->getType() == op2->getType())
        {
            return op1;
        }
        return NULL;
    }

    // operation BIT returns bool or struct {bool, ...}
    if (op == OP_BIT)
    {
        if (op1->getType() == STRUCT)
        {
            StructType* resStructType = new StructType;
            TypeFactory::addTempType(resStructType);

            StructType* opStructType = (StructType*)const_cast<BaseType*>(op1);

            for (unsigned int i = 0; i < opStructType->getNumElems(); ++i)
            {
                const BaseType* resType = getResultType(op, opStructType->getElemType(i), op2);

                if (!resType)
                {
                    return 0;
                }

                resStructType->addElement(opStructType->getElemName(i), resType);
            }

            return (BaseType*) resStructType;
        }

        // integral types
        else if (op1->getType() <= OCTET)
        {
            return TypeFactory::mapType("Bool");
        }

        else
        {
            return 0;
        }
    }

    // operation not even applicable, so no result type
    if (!isApplicable(op, op1, op2))
    {
        return 0;
    }

    // the condense operation COUNT always returns an unsigned long
    if (op == Ops::OP_COUNT)
    {
        return TypeFactory::mapType("ULong");
    }
    // SQRT returns DOUBLE


    if (op > Ops::OP_UFUNC_BEGIN && op < Ops::OP_UFUNC_END)
    {
        return TypeFactory::mapType("Double");
    }

    if (op > Ops::OP_CAST_BEGIN && op < Ops::OP_CAST_END && op != OP_CAST_GENERAL)
    {
        if (op1->getType() < STRUCT)
        {
            const char* typeName[] =
            {
                "Bool", "Char", "Octet", "Short", "UShort",
                "Long", "ULong", "Float", "Double"
            };
            return TypeFactory::mapType(typeName[op - OP_CAST_BEGIN - 1]);
        }

        else if (op1->getType() == STRUCT)
        {
            StructType* resStructType = new StructType;
            TypeFactory::addTempType(resStructType);
            StructType* opStructType = (StructType*)const_cast<BaseType*>(op1);

            for (unsigned int i = 0; i < opStructType->getNumElems(); ++i)
            {
                const BaseType* resType = getResultType(op, opStructType->getElemType(i));
                if (!resType)
                {
                    return 0;
                }

                resStructType->addElement(opStructType->getElemName(i), resType);
            }

            return (BaseType*)resStructType;
        }

        else
        {
            return 0;
        }

    }

    // if we have division of integers, the result should be a real -- DM
    if (op == OP_DIV)
    {
        if ((op1->getType() <= OCTET && op2->getType() <= OCTET))
        {
            return TypeFactory::mapType("Double");
        }
    }

    // the condense operation ADD_CELLS returns maximal type
    // (i.e. long/ulong or double)
    if (!op2 && op == Ops::OP_SUM)
    {
        if (op1->getType() <= BOOLTYPE)
        {
            return TypeFactory::mapType("ULong");
        }

        if (op1->getType() <= OCTET)
        {
            return TypeFactory::mapType("Long");
        }

        else if (op1->getType() <= FLOAT)
        {
            return TypeFactory::mapType("Double");
        }

        else if (op1->getType() == COMPLEXTYPE1)
        {
            return TypeFactory::mapType("Complex1");
        }

        else if (op1->getType() == COMPLEXTYPE2)
        {
            return TypeFactory::mapType("Complex2");
        }

        else if (op1->getType() == STRUCT)
        {
            StructType* resStructType = new StructType;
            TypeFactory::addTempType(resStructType);
            StructType* opStructType = (StructType*)const_cast<BaseType*>(op1);

            for (unsigned int i = 0; i < opStructType->getNumElems(); ++i)
            {
                const BaseType* resType = getResultType(op, opStructType->getElemType(i));
                if (!resType)
                {
                    return 0;
                }

                resStructType->addElement(opStructType->getElemName(i), resType);
            }

            return (BaseType*)resStructType;
        }
        else
        {
            return 0;
        }
    }

    // some :-) unary and condense operations return the same type
    if (op == OP_REALPART || op == OP_IMAGINARPART)
    {
        if (op1->getType() == COMPLEXTYPE1)
        {
            return TypeFactory::mapType("Float");
        }
        else if (op1->getType() == COMPLEXTYPE2)
        {
            return TypeFactory::mapType("Double");
        }
    }
    if (op == OP_CONSTRUCT_COMPLEX)
    {
        if (op1->getType() == DOUBLE || op2->getType() == DOUBLE)
        {
            return TypeFactory::mapType("Complex2");
        }
        else if (op1->getType() == FLOAT || op2->getType() == FLOAT)
        {
            return TypeFactory::mapType("Complex1");
        }
        else
        {
            return TypeFactory::mapType("Complex2");
        }
    }
    if (op2 == 0)
    {
        return const_cast<BaseType*>(op1);
    }
    // operations between composite types defined only on compatible types
    if (op1->getType() >= STRUCT && op1->getType() <= CLASSTYPE)
    {
        if (op == OP_EQUAL || op == OP_NOTEQUAL)
        {
            return TypeFactory::mapType("Bool");
        }
        else
        {
            if (op1->getType() == STRUCT && op2->getType() <= FLOAT)
            {

                StructType* resStructType = new StructType;
                TypeFactory::addTempType(resStructType);
                StructType* opStructType = (StructType*)const_cast<BaseType*>(op1);

                for (unsigned int i = 0; i < opStructType->getNumElems(); ++i)
                {
                    const BaseType* resType = getResultType(op, opStructType->getElemType(i), op2);
                    if (!resType)
                    {
                        return 0;
                    }

                    resStructType->addElement(opStructType->getElemName(i), resType);
                }

                return (BaseType*)resStructType;
            }
            else
            {
                return const_cast<BaseType*>(op1);
            }
        }
    }
    if (op2->getType() >= STRUCT && op2->getType() <= CLASSTYPE)
    {

        if (op1->getType() <= FLOAT && op2->getType() == STRUCT)
        {

            StructType* resStructType = new StructType;
            TypeFactory::addTempType(resStructType);
            StructType* opStructType = (StructType*)const_cast<BaseType*>(op2);

            for (unsigned int i = 0; i < opStructType->getNumElems(); ++i)
            {
                const BaseType* resType = getResultType(op, op1, opStructType->getElemType(i));
                if (!resType)
                {
                    return 0;
                }
                resStructType->addElement(opStructType->getElemName(i), resType);
            }


            return (BaseType*)resStructType;
        }
        else
        {
            return const_cast<BaseType*>(op2);
        }
    }

    // comparison operators always return bool
    if (op >= OP_EQUAL && op <= OP_GREATEREQUAL)
    {
        return TypeFactory::mapType("Bool");
    }
    // all the other binary functions return "strongest" type
    // if only one of operand is signed, result also has to be signed.
    if (isSignedType(op1) && !isSignedType(op2))
    {
        // swap it, action is in next if clause
        const BaseType* dummy;
        dummy = op2;
        op2 = op1;
        op1 = dummy;
    }
    if (!isSignedType(op1) && isSignedType(op2))
    {
        // got to get the thing with the highest precision and make sure
        // it is signed.
        if (op2->getType() == COMPLEXTYPE1 || op2->getType() == COMPLEXTYPE2 ||
                op2->getType() == FLOAT || op2->getType() == DOUBLE || op2->getType() == LONG)
        {
            return const_cast<BaseType*>(op2);
        }
        if (op1->getType() == USHORT)
        {
            return TypeFactory::mapType("Short");
        }
        if (op2->getType() == SHORT)
        {
            return const_cast<BaseType*>(op2);
        }
        return TypeFactory::mapType("Octet");
    }
    // return the stronger type
    if (op1->getType() == COMPLEXTYPE2 || op2->getType() == COMPLEXTYPE2)
    {
        return TypeFactory::mapType("Complex2");
    }
    if (op1->getType() == COMPLEXTYPE1 || op2->getType() == COMPLEXTYPE1)
    {
        return TypeFactory::mapType("Complex1");
    }
    if (op1->getType() == DOUBLE || op2->getType() == DOUBLE)
    {
        return TypeFactory::mapType("Double");
    }
    if (op1->getType() == FLOAT || op2->getType() == FLOAT)
    {
        return TypeFactory::mapType("Float");
    }
    if (op1->getType() <= op2->getType())
    {
        return const_cast<BaseType*>(op1);
    }
    else
    {
        return const_cast<BaseType*>(op2);
    }
}

int
Ops::isApplicableOnStruct(Ops::OpType op, const BaseType* opType)
{
    unsigned int i = 0;
    StructType* myStructType = (StructType*)const_cast<BaseType*>(opType);
    unsigned int numElems = myStructType->getNumElems();

    for (i = 0; i < numElems; i++)
    {
        if (!isApplicable(op, myStructType->getElemType(i),
                          myStructType->getElemType(i)))
        {
            return 0;
        }
    }
    return 1;
}

int
Ops::isApplicableOnStructConst(Ops::OpType op, const BaseType* op1Type,
                               const BaseType* op2Type)
{
    unsigned int i = 0;
    StructType* myStructType = (StructType*)const_cast<BaseType*>(op1Type);
    unsigned int numElems = myStructType->getNumElems();

    for (i = 0; i < numElems; i++)
    {
        if (!isApplicable(op, myStructType->getElemType(i), op2Type))
        {
            return 0;
        }
    }
    return 1;
}

int
Ops::isSignedType(const BaseType* type)
{
    return (type->getType() >= LONG && type->getType() <= COMPLEXTYPE2);
}

int
Ops::isCondenseOp(Ops::OpType op)
{
    return (op >= OP_SOME && op <= OP_ALL);
}

int
Ops::isUnaryOp(Ops::OpType op)
{
    return (op >= OP_NOT && op <= OP_IDENTITY);
}

int
Ops::isBinaryOp(Ops::OpType op)
{
    return (op >= OP_MINUS && op <= OP_GREATEREQUAL);
}

void
Ops::execUnaryConstOp(Ops::OpType op, const BaseType* resType,
                      const BaseType* opType, char* res,
                      const char* op1, unsigned int resOff,
                      unsigned int opOff, double param)
{
    UnaryOp* myOp = Ops::getUnaryOp(op, resType, opType, resOff, opOff);

    if (!myOp)
    {
        LFATAL << "Ops::execUnaryConstOp: no operation for result type "
               << resType->getName() << ", argument type "
               << opType->getName() << ", operation " << (int)op;
        throw r_Error(367);
    }

    // set exponent for pow operations
    if (op == Ops::OP_POW)
    {
        ((OpPOWCDouble*)myOp)->setExponent(param);
    }
    try
    {
        (*myOp)(res, op1);
    }
    catch (...)
    {
        delete myOp;  // cleanup
        throw;
    }

    delete myOp;
}

void
Ops::execBinaryConstOp(Ops::OpType op, const BaseType* resType,
                       const BaseType* op1Type,
                       const BaseType* op2Type, char* res,
                       const char* op1, const char* op2,
                       unsigned int resOff, unsigned int op1Off,
                       unsigned int op2Off)
{
    BinaryOp* myOp = Ops::getBinaryOp(op, resType, op1Type, op2Type,
                                      resOff, op1Off, op2Off);
    (*myOp)(res, op1, op2);
    delete myOp;
}

UnaryOp::UnaryOp(const BaseType* newResType, const BaseType* newOpType,
                 unsigned int newResOff, unsigned int newOpOff)
    : NullValuesHandler(), opType(newOpType), resType(newResType), resOff(newResOff), opOff(newOpOff)

{
}

OpIDENTITYStruct::OpIDENTITYStruct(const BaseType* newResType, const BaseType* newOpType,
                                   unsigned int newResOff,
                                   unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
}

void
OpIDENTITYStruct::operator()(char* res, const char* op)
{
    memcpy((void*)(res + resOff), (void*)(const_cast<char*>(op) + opOff), resType->getSize());
}

OpNOTCULong::OpNOTCULong(const BaseType* newResType, const BaseType* newOpType,
                         unsigned int newResOff, unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
}

void
OpNOTCULong::operator()(char* res, const char* op)
{
    r_ULong longOp;
    r_ULong longRes;

    longOp = *(opType->convertToCULong(op + opOff, &longOp));

    if (isNull(longOp))
    {
        longRes = longOp;
    }
    else
    {
        longRes = longOp ^ ULONG_MAX;
    }

    resType->makeFromCULong(res + resOff, &longRes);
}

OpIDENTITYCULong::OpIDENTITYCULong(const BaseType* newResType, const BaseType* newOpType,
                                   unsigned int newResOff,
                                   unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
}

void
OpIDENTITYCULong::operator()(char* res, const char* op)
{
    r_ULong longOp;

    // !!!! HP specific, assumes 4 Byte long and MSB..LSB
    // byte order
    resType->makeFromCULong(res + resOff,
                            opType->convertToCULong(op + opOff, &longOp));
}

OpNOTCLong::OpNOTCLong(const BaseType* newResType, const BaseType* newOpType,
                       unsigned int newResOff, unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
}

void
OpNOTCLong::operator()(char* res, const char* op)
{
    r_Long longOp;
    r_Long longRes;

    longOp = *(opType->convertToCLong(op + opOff, &longOp));

    if (isNull(longOp))
    {
        longRes = longOp;
    }
    else
    {
        longRes = longOp ^ LONG_MAX;
    }

    resType->makeFromCLong(res + resOff, &longRes);
}

OpIDENTITYCLong::OpIDENTITYCLong(const BaseType* newResType, const BaseType* newOpType,
                                 unsigned int newResOff,
                                 unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
}

void
OpIDENTITYCLong::operator()(char* res, const char* op)
{
    r_Long longOp;

    resType->makeFromCLong(res + resOff,
                           opType->convertToCLong(op + opOff, &longOp));
}

OpIDENTITYCDouble::OpIDENTITYCDouble(const BaseType* newResType, const BaseType* newOpType,
                                     unsigned int newResOff,
                                     unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
}

void
OpIDENTITYCDouble::operator()(char* res, const char* op)
{
    double doubleOp;

    // !!!! HP specific, assumes 4 Byte double and MSB..LSB
    // byte order
    resType->makeFromCDouble(res + resOff,
                             opType->convertToCDouble(op + opOff, &doubleOp));
}

OpNOTBool::OpNOTBool(const BaseType* newResType, const BaseType* newOpType,
                     unsigned int newResOff, unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
}

void
OpNOTBool::operator()(char* res, const char* op)
{
    // special case for bools, because bitwise not is not
    // equivalent to logical not
    if (isNull(*(op + opOff)))
    {
        *(res + resOff) = *(op + opOff);
    }
    else
    {
        *(res + resOff) = !(*(op + opOff));
    }
}

BinaryOp::BinaryOp(const BaseType* newResType, const BaseType* newOp1Type,
                   const BaseType* newOp2Type, unsigned int newResOff,
                   unsigned int newOp1Off, unsigned int newOp2Off)
    :  NullValuesHandler(), op1Type(newOp1Type), op2Type(newOp2Type), resType(newResType),
       resOff(newResOff), op1Off(newOp1Off), op2Off(newOp2Off)
{
}

void
BinaryOp::getCondenseInit(__attribute__((unused)) char* init)
{
    init = 0;
    // perhaps should also raise exception as operation cannot be used
    // as condenser.
}

OpPLUSCULong::OpPLUSCULong(const BaseType* newResType, const BaseType* newOp1Type,
                           const BaseType* newOp2Type, unsigned int newResOff,
                           unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpPLUSCULong::operator()(char* res, const char* op1, const char* op2)
{
    r_ULong longOp1 = 0;
    r_ULong longOp2 = 0;
    r_ULong longRes = 0;

    longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        longRes = longOp1 + longOp2;
    }

    resType->makeFromCULong(res + resOff, &longRes);
}

void
OpPLUSCULong::getCondenseInit(char* init)
{
    r_ULong dummy = 0;

    resType->makeFromCULong(init, &dummy);
}

OpPLUSULong::OpPLUSULong(const BaseType* newResType, const BaseType* newOp1Type,
                         const BaseType* newOp2Type, unsigned int newResOff,
                         unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpPLUSULong::operator()(char* res, const char* op1, const char* op2)
{
    if (isNull(*(r_ULong*)(const_cast<char*>(op1) + op1Off)))
    {
        *(r_ULong*)(res + resOff) = *(r_ULong*)(const_cast<char*>(op1) + op1Off);
    }
    else if (isNull(*(r_ULong*)(const_cast<char*>(op2) + op2Off)))
    {
        *(r_ULong*)(res + resOff) = *(r_ULong*)(const_cast<char*>(op2) + op2Off);
    }
    else
    {
        *(r_ULong*)(res + resOff) = *(r_ULong*)(const_cast<char*>(op1) + op1Off)
                                    + *(r_ULong*)(const_cast<char*>(op2) + op2Off);
    }
}

void
OpPLUSULong::getCondenseInit(char* init)
{
    r_ULong dummy = 0;

    resType->makeFromCULong(init, &dummy);
}



OpMAX_BINARYCULong::OpMAX_BINARYCULong(const BaseType* newResType, const BaseType* newOp1Type,
                                       const BaseType* newOp2Type, unsigned int newResOff,
                                       unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMAX_BINARYCULong::operator()(char* res, const char* op1, const char* op2)
{
    r_ULong longOp1 = 0;
    r_ULong longOp2 = 0;
    r_ULong longRes = 0;

    if (*(op1Type->convertToCULong(op1 + op1Off, &longOp1)) > *(op2Type->convertToCULong(op2 + op2Off, &longOp2)))
    {
        longRes = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    }
    else
    {
        longRes = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));
    }
    resType->makeFromCULong(res + resOff, &longRes);
}

void
OpMAX_BINARYCULong::getCondenseInit(char* init)
{
    r_ULong dummy = 0;

    resType->makeFromCULong(init, &dummy);
}

OpMAX_BINARYULong::OpMAX_BINARYULong(const BaseType* newResType, const BaseType* newOp1Type,
                                     const BaseType* newOp2Type, unsigned int newResOff,
                                     unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMAX_BINARYULong::operator()(char* res, const char* op1, const char* op2)
{
    if (*(r_ULong*)(const_cast<char*>(op1) + op1Off) > *(r_ULong*)(const_cast<char*>(op2) + op2Off))
    {
        *(r_ULong*)(res + resOff) = *(r_ULong*)(const_cast<char*>(op1) + op1Off);
    }
    else
    {
        *(r_ULong*)(res + resOff) = *(r_ULong*)(const_cast<char*>(op2) + op2Off);
    }
}

void
OpMAX_BINARYULong::getCondenseInit(char* init)
{
    r_ULong dummy = 0;

    resType->makeFromCULong(init, &dummy);
}




OpMIN_BINARYCULong::OpMIN_BINARYCULong(const BaseType* newResType, const BaseType* newOp1Type,
                                       const BaseType* newOp2Type, unsigned int newResOff,
                                       unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMIN_BINARYCULong::operator()(char* res, const char* op1, const char* op2)
{
    r_ULong longOp1 = 0;
    r_ULong longOp2 = 0;
    r_ULong longRes = 0;

    if (*(op1Type->convertToCULong(op1 + op1Off, &longOp1)) < * (op2Type->convertToCULong(op2 + op2Off, &longOp2)))
    {
        longRes = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    }
    else
    {
        longRes = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));
    }
    resType->makeFromCULong(res + resOff, &longRes);
}

void
OpMIN_BINARYCULong::getCondenseInit(char* init)
{
    r_ULong dummy = UINT_MAX;

    resType->makeFromCULong(init, &dummy);
}

OpMIN_BINARYULong::OpMIN_BINARYULong(const BaseType* newResType, const BaseType* newOp1Type,
                                     const BaseType* newOp2Type, unsigned int newResOff,
                                     unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMIN_BINARYULong::operator()(char* res, const char* op1, const char* op2)
{
    cout << "Hier krachts?" << endl;
    if (*(r_ULong*)(const_cast<char*>(op1) + op1Off) < * (r_ULong*)(const_cast<char*>(op2) + op2Off))
    {
        *(r_ULong*)(res + resOff) = *(r_ULong*)(const_cast<char*>(op1) + op1Off);
    }
    else
    {
        *(r_ULong*)(res + resOff) = *(r_ULong*)(const_cast<char*>(op2) + op2Off);
    }
}

void
OpMIN_BINARYULong::getCondenseInit(char* init)
{
    r_ULong dummy = UINT_MAX;

    resType->makeFromCULong(init, &dummy);
}


OpMINUSCULong::OpMINUSCULong(const BaseType* newResType, const BaseType* newOp1Type,
                             const BaseType* newOp2Type, unsigned int newResOff,
                             unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMINUSCULong::operator()(char* res, const char* op1, const char* op2)
{
    r_ULong longOp1 = 0;
    r_ULong longOp2 = 0;
    r_ULong longRes = 0;

    longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        longRes = longOp1 - longOp2;
    }

    resType->makeFromCULong(res + resOff, &longRes);
}

OpDIVCULong::OpDIVCULong(const BaseType* newResType, const BaseType* newOp1Type,
                         const BaseType* newOp2Type, unsigned int newResOff,
                         unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpDIVCULong::operator()(char* res, const char* op1, const char* op2)
{
    r_ULong longOp1 = 0;
    r_ULong longOp2 = 0;
    r_ULong longRes = 0;

    longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        if (longOp2 == 0)
        {
            throw DIVISION_BY_ZERO;
        }
        else
        {
            longRes = longOp1 / longOp2;
        }
    }

    resType->makeFromCULong(res + resOff, &longRes);
}

OpMODCULong::OpMODCULong(const BaseType* newResType, const BaseType* newOp1Type,
                         const BaseType* newOp2Type, unsigned int newResOff,
                         unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMODCULong::operator()(char* res, const char* op1, const char* op2)
{
    r_ULong longOp1 = 0;
    r_ULong longOp2 = 0;
    r_ULong longRes = 0;

    op1Type->convertToCULong(op1 + op1Off, &longOp1);
    op2Type->convertToCULong(op2 + op2Off, &longOp2);

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        if (longOp2 == 0)
        {
            throw DIVISION_BY_ZERO;
        }
        else
        {
            longRes = longOp1 % longOp2;
        }
    }

    resType->makeFromCULong(res + resOff, &longRes);
}

OpMULTCULong::OpMULTCULong(const BaseType* newResType, const BaseType* newOp1Type,
                           const BaseType* newOp2Type, unsigned int newResOff,
                           unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMULTCULong::operator()(char* res, const char* op1, const char* op2)
{
    r_ULong longOp1 = 0;
    r_ULong longOp2 = 0;
    r_ULong longRes = 0;

    longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        longRes = longOp1 * longOp2;
    }

    resType->makeFromCULong(res + resOff, &longRes);
}

void
OpMULTCULong::getCondenseInit(char* init)
{
    r_ULong dummy = 1;

    resType->makeFromCULong(init, &dummy);
}

OpANDCULong::OpANDCULong(const BaseType* newResType, const BaseType* newOp1Type,
                         const BaseType* newOp2Type, unsigned int newResOff,
                         unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpANDCULong::operator()(char* res, const char* op1, const char* op2)
{
    r_ULong longOp1 = 0;
    r_ULong longOp2 = 0;
    r_ULong longRes = 0;

    longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        longRes = longOp1 & longOp2;
    }

    resType->makeFromCULong(res + resOff, &longRes);
}

void
OpANDCULong::getCondenseInit(char* init)
{
    unsigned char dummy[8] = { 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF };

    memcpy(init, dummy, resType->getSize());
}

OpANDBool::OpANDBool(const BaseType* newResType, const BaseType* newOp1Type,
                     const BaseType* newOp2Type, unsigned int newResOff,
                     unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpANDBool::operator()(char* res, const char* op1, const char* op2)
{

    if (isNull(*(op1 + op1Off)))
    {
        *(res + resOff) = *(op1 + op1Off);
    }
    else if (isNull(*(op2 + op2Off)))
    {
        *(res + resOff) = *(op2 + op2Off);
    }
    else
    {
        *(res + resOff) = *(op1 + op1Off) && *(op2 + op2Off);
    }

}

void
OpANDBool::getCondenseInit(char* init)
{
    *init = 1;
}

OpORCULong::OpORCULong(const BaseType* newResType, const BaseType* newOp1Type,
                       const BaseType* newOp2Type, unsigned int newResOff,
                       unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpORCULong::operator()(char* res, const char* op1, const char* op2)
{
    r_ULong longOp1 = 0;
    r_ULong longOp2 = 0;
    r_ULong longRes = 0;

    longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        longRes = longOp1 | longOp2;
    }

    resType->makeFromCULong(res + resOff, &longRes);
}

void
OpORCULong::getCondenseInit(char* init)
{
    char dummy[8] = { 0, 0, 0, 0, 0, 0, 0, 0 };

    memcpy(init, dummy, resType->getSize());
}

OpORBool::OpORBool(const BaseType* newResType, const BaseType* newOp1Type,
                   const BaseType* newOp2Type, unsigned int newResOff,
                   unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpORBool::operator()(char* res, const char* op1, const char* op2)
{

    if (isNull(*(op1 + op1Off)))
    {
        *(res + resOff) = *(op1 + op1Off);
    }
    else if (isNull(*(op2 + op2Off)))
    {
        *(res + resOff) = *(op2 + op2Off);
    }
    else
    {
        *(res + resOff) = *(op1 + op1Off) || *(op2 + op2Off);
    }

}

void
OpORBool::getCondenseInit(char* init)
{
    *init = 0;
}

OpXORCULong::OpXORCULong(const BaseType* newResType, const BaseType* newOp1Type,
                         const BaseType* newOp2Type, unsigned int newResOff,
                         unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpXORCULong::operator()(char* res, const char* op1, const char* op2)
{
    r_ULong longOp1 = 0;
    r_ULong longOp2 = 0;
    r_ULong longRes = 0;

    longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        longRes = longOp1 ^ longOp2;
    }

    resType->makeFromCULong(res + resOff, &longRes);
}

OpXORBool::OpXORBool(const BaseType* newResType, const BaseType* newOp1Type,
                     const BaseType* newOp2Type, unsigned int newResOff,
                     unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpXORBool::operator()(char* res, const char* op1, const char* op2)
{

    if (isNull(*(op1 + op1Off)))
    {
        *(res + resOff) = *(op1 + op1Off);
    }
    else if (isNull(*(op2 + op2Off)))
    {
        *(res + resOff) = *(op2 + op2Off);
    }
    else
    {
        *(res + resOff) = !(*(op1 + op1Off) == *(op2 + op2Off));
    }

}

OpPLUSCLong::OpPLUSCLong(const BaseType* newResType, const BaseType* newOp1Type,
                         const BaseType* newOp2Type, unsigned int newResOff,
                         unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpPLUSCLong::operator()(char* res, const char* op1, const char* op2)
{
    r_Long longOp1 = 0;
    r_Long longOp2 = 0;
    r_Long longRes = 0;

    longOp1 = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        longRes = longOp1 + longOp2;
    }

    resType->makeFromCLong(res + resOff, &longRes);
}

void
OpPLUSCLong::getCondenseInit(char* init)
{
    r_Long dummy = 0;

    resType->makeFromCLong(init, &dummy);
}

OpMAX_BINARYCLong::OpMAX_BINARYCLong(const BaseType* newResType, const BaseType* newOp1Type,
                                     const BaseType* newOp2Type, unsigned int newResOff,
                                     unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMAX_BINARYCLong::operator()(char* res, const char* op1, const char* op2)
{
    r_Long longOp1 = 0;
    r_Long longOp2 = 0;
    r_Long longRes = 0;

    if (*(op1Type->convertToCLong(op1 + op1Off, &longOp1)) > *(op2Type->convertToCLong(op2 + op2Off, &longOp2)))
    {
        longRes = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    }
    else
    {
        longRes = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));
    }
    resType->makeFromCLong(res + resOff, &longRes);
}

void
OpMAX_BINARYCLong::getCondenseInit(char* init)
{
    r_Long dummy = INT_MIN;

    resType->makeFromCLong(init, &dummy);
}




OpMIN_BINARYCLong::OpMIN_BINARYCLong(const BaseType* newResType, const BaseType* newOp1Type,
                                     const BaseType* newOp2Type, unsigned int newResOff,
                                     unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMIN_BINARYCLong::operator()(char* res, const char* op1, const char* op2)
{
    r_Long longOp1 = 0;
    r_Long longOp2 = 0;
    r_Long longRes = 0;

    if (*(op1Type->convertToCLong(op1 + op1Off, &longOp1)) < * (op2Type->convertToCLong(op2 + op2Off, &longOp2)))
    {
        longRes = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    }
    else
    {
        longRes = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));
    }
    resType->makeFromCLong(res + resOff, &longRes);
}

void
OpMIN_BINARYCLong::getCondenseInit(char* init)
{
    r_Long dummy = INT_MAX;

    resType->makeFromCLong(init, &dummy);
}

OpMINUSCLong::OpMINUSCLong(const BaseType* newResType, const BaseType* newOp1Type,
                           const BaseType* newOp2Type, unsigned int newResOff,
                           unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMINUSCLong::operator()(char* res, const char* op1, const char* op2)
{
    r_Long longOp1 = 0;
    r_Long longOp2 = 0;
    r_Long longRes = 0;

    longOp1 = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        longRes = longOp1 - longOp2;
    }

    resType->makeFromCLong(res + resOff, &longRes);
}

OpDIVCLong::OpDIVCLong(const BaseType* newResType, const BaseType* newOp1Type,
                       const BaseType* newOp2Type, unsigned int newResOff,
                       unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpDIVCLong::operator()(char* res, const char* op1, const char* op2)
{
    r_Long longOp1 = 0;
    r_Long longOp2 = 0;
    r_Long longRes = 0;

    longOp1 = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        if (longOp2 == 0)
        {
            throw DIVISION_BY_ZERO;
        }
        else
        {
            longRes = longOp1 / longOp2;
        }
    }

    resType->makeFromCLong(res + resOff, &longRes);
}

OpMODCLong::OpMODCLong(const BaseType* newResType, const BaseType* newOp1Type,
                       const BaseType* newOp2Type, unsigned int newResOff,
                       unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMODCLong::operator()(char* res, const char* op1, const char* op2)
{
    r_Long longOp1 = 0;
    r_Long longOp2 = 0;
    r_Long longRes = 0;

    op1Type->convertToCLong(op1 + op1Off, &longOp1);
    op2Type->convertToCLong(op2 + op2Off, &longOp2);

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        if (longOp2 == 0)
        {
            throw DIVISION_BY_ZERO;
        }
        else
        {
            longRes = longOp1 % longOp2;
        }
    }

    resType->makeFromCLong(res + resOff, &longRes);
}

OpMULTCLong::OpMULTCLong(const BaseType* newResType, const BaseType* newOp1Type,
                         const BaseType* newOp2Type, unsigned int newResOff,
                         unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMULTCLong::operator()(char* res, const char* op1, const char* op2)
{
    r_Long longOp1 = 0;
    r_Long longOp2 = 0;
    r_Long longRes = 0;

    longOp1 = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        longRes = longOp1 * longOp2;
    }

    resType->makeFromCLong(res + resOff, &longRes);
}

void
OpMULTCLong::getCondenseInit(char* init)
{
    r_Long dummy = 1;

    resType->makeFromCLong(init, &dummy);
}

OpANDCLong::OpANDCLong(const BaseType* newResType, const BaseType* newOp1Type,
                       const BaseType* newOp2Type, unsigned int newResOff,
                       unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpANDCLong::operator()(char* res, const char* op1, const char* op2)
{
    r_Long longOp1 = 0;
    r_Long longOp2 = 0;
    r_Long longRes = 0;

    longOp1 = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        longRes = longOp1 & longOp2;
    }

    resType->makeFromCLong(res + resOff, &longRes);
}

void
OpANDCLong::getCondenseInit(char* init)
{
    unsigned char dummy[8] = { 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF };

    memcpy(init, dummy, resType->getSize());
}

OpORCLong::OpORCLong(const BaseType* newResType, const BaseType* newOp1Type,
                     const BaseType* newOp2Type, unsigned int newResOff,
                     unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpORCLong::operator()(char* res, const char* op1, const char* op2)
{
    r_Long longOp1 = 0;
    r_Long longOp2 = 0;
    r_Long longRes = 0;

    longOp1 = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        longRes = longOp1 | longOp2;
    }

    resType->makeFromCLong(res + resOff, &longRes);
}

void
OpORCLong::getCondenseInit(char* init)
{
    char dummy[8] = { 0, 0, 0, 0, 0, 0, 0, 0 };

    memcpy(init, dummy, resType->getSize());
}

OpXORCLong::OpXORCLong(const BaseType* newResType, const BaseType* newOp1Type,
                       const BaseType* newOp2Type, unsigned int newResOff,
                       unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpXORCLong::operator()(char* res, const char* op1, const char* op2)
{
    r_Long longOp1 = 0;
    r_Long longOp2 = 0;
    r_Long longRes = 0;

    longOp1 = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    longOp2 = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));

    if (isNull(longOp1))
    {
        longRes = longOp1;
    }
    else if (isNull(longOp2))
    {
        longRes = longOp2;
    }
    else
    {
        longRes = longOp1 ^ longOp2;
    }

    resType->makeFromCLong(res + resOff, &longRes);
}

OpPLUSCDouble::OpPLUSCDouble(const BaseType* newResType, const BaseType* newOp1Type,
                             const BaseType* newOp2Type, unsigned int newResOff,
                             unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpPLUSCDouble::operator()(char* res, const char* op1, const char* op2)
{
    double doubleOp1 = 0;
    double doubleOp2 = 0;
    double doubleRes = 0;

    doubleOp1 = *(op1Type->convertToCDouble(op1 + op1Off, &doubleOp1));
    doubleOp2 = *(op2Type->convertToCDouble(op2 + op2Off, &doubleOp2));

    if (isNull(doubleOp1))
    {
        doubleRes = doubleOp1;
    }
    else if (isNull(doubleOp2))
    {
        doubleRes = doubleOp2;
    }
    else
    {
        doubleRes = doubleOp1 + doubleOp2;
    }

    resType->makeFromCDouble(res + resOff, &doubleRes);
}

void
OpPLUSCDouble::getCondenseInit(char* init)
{
    double dummy = 0.0;

    resType->makeFromCDouble(init, &dummy);
}

OpMAX_BINARYCDouble::OpMAX_BINARYCDouble(const BaseType* newResType, const BaseType* newOp1Type,
        const BaseType* newOp2Type, unsigned int newResOff,
        unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMAX_BINARYCDouble::operator()(char* res, const char* op1, const char* op2)
{
    double doubleOp1 = 0;
    double doubleOp2 = 0;
    double doubleRes = 0;

    if (*(op1Type->convertToCDouble(op1 + op1Off, &doubleOp1)) > *(op2Type->convertToCDouble(op2 + op2Off, &doubleOp2)))
    {
        doubleRes = *(op1Type->convertToCDouble(op1 + op1Off, &doubleOp1));
    }
    else
    {
        doubleRes = *(op2Type->convertToCDouble(op2 + op2Off, &doubleOp2));
    }
    resType->makeFromCDouble(res + resOff, &doubleRes);
}

void
OpMAX_BINARYCDouble::getCondenseInit(char* init)
{
    double dummy = -INFINITY;

    resType->makeFromCDouble(init, &dummy);
}




OpMIN_BINARYCDouble::OpMIN_BINARYCDouble(const BaseType* newResType, const BaseType* newOp1Type,
        const BaseType* newOp2Type, unsigned int newResOff,
        unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMIN_BINARYCDouble::operator()(char* res, const char* op1, const char* op2)
{
    double doubleOp1 = 0;
    double doubleOp2 = 0;
    double doubleRes = 0;

    if (*(op1Type->convertToCDouble(op1 + op1Off, &doubleOp1)) < * (op2Type->convertToCDouble(op2 + op2Off, &doubleOp2)))
    {
        doubleRes = *(op1Type->convertToCDouble(op1 + op1Off, &doubleOp1));
    }
    else
    {
        doubleRes = *(op2Type->convertToCDouble(op2 + op2Off, &doubleOp2));
    }
    resType->makeFromCDouble(res + resOff, &doubleRes);
}

void
OpMIN_BINARYCDouble::getCondenseInit(char* init)
{
    double dummy = INFINITY;

    resType->makeFromCDouble(init, &dummy);
}

OpMINUSCDouble::OpMINUSCDouble(const BaseType* newResType, const BaseType* newOp1Type,
                               const BaseType* newOp2Type, unsigned int newResOff,
                               unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMINUSCDouble::operator()(char* res, const char* op1, const char* op2)
{
    double doubleOp1 = 0;
    double doubleOp2 = 0;
    double doubleRes = 0;

    doubleOp1 = *(op1Type->convertToCDouble(op1 + op1Off, &doubleOp1));
    doubleOp2 = *(op2Type->convertToCDouble(op2 + op2Off, &doubleOp2));

    if (isNull(doubleOp1))
    {
        doubleRes = doubleOp1;
    }
    else if (isNull(doubleOp2))
    {
        doubleRes = doubleOp2;
    }
    else
    {
        doubleRes = doubleOp1 - doubleOp2;
    }

    resType->makeFromCDouble(res + resOff, &doubleRes);
}

OpDIVCDouble::OpDIVCDouble(const BaseType* newResType, const BaseType* newOp1Type,
                           const BaseType* newOp2Type, unsigned int newResOff,
                           unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpDIVCDouble::operator()(char* res, const char* op1, const char* op2)
{
    double doubleOp1 = 0;
    double doubleOp2 = 0;
    double doubleRes = 0;

    doubleOp1 = *(op1Type->convertToCDouble(op1 + op1Off, &doubleOp1));
    doubleOp2 = *(op2Type->convertToCDouble(op2 + op2Off, &doubleOp2));

    if (isNull(doubleOp1))
    {
        doubleRes = doubleOp1;
    }
    else if (isNull(doubleOp2))
    {
        doubleRes = doubleOp2;
    }
    else
    {
        // Do not handle division by zero, return +-inf or nan as specified in IEEE 754
        doubleRes = doubleOp1 / doubleOp2;
    }

    resType->makeFromCDouble(res + resOff, &doubleRes);
}

OpMULTCDouble::OpMULTCDouble(const BaseType* newResType, const BaseType* newOp1Type,
                             const BaseType* newOp2Type, unsigned int newResOff,
                             unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMULTCDouble::operator()(char* res, const char* op1, const char* op2)
{
    double doubleOp1 = 0;
    double doubleOp2 = 0;
    double doubleRes = 0;

    doubleOp1 = *(op1Type->convertToCDouble(op1 + op1Off, &doubleOp1));
    doubleOp2 = *(op2Type->convertToCDouble(op2 + op2Off, &doubleOp2));

    if (isNull(doubleOp1))
    {
        doubleRes = doubleOp1;
    }
    else if (isNull(doubleOp2))
    {
        doubleRes = doubleOp2;
    }
    else
    {
        doubleRes = doubleOp1 * doubleOp2;
    }

    resType->makeFromCDouble(res + resOff, &doubleRes);
}

void
OpMULTCDouble::getCondenseInit(char* init)
{
    double dummy = 1.0;

    resType->makeFromCDouble(init, &dummy);
}

OpEQUALCCharCULong::OpEQUALCCharCULong(const BaseType* newResType,
                                       const BaseType* newOp1Type,
                                       const BaseType* newOp2Type,
                                       unsigned int newResOff,
                                       unsigned int newOp1Off,
                                       unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpEQUALCCharCULong::operator()(char* res, const char* op1,
                               const char* op2)
{
    r_ULong longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    r_ULong longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1) || isNull(longOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = longOp1 == longOp2;
    }
}

OpLESSCCharCULong::OpLESSCCharCULong(const BaseType* newResType,
                                     const BaseType* newOp1Type,
                                     const BaseType* newOp2Type,
                                     unsigned int newResOff,
                                     unsigned int newOp1Off,
                                     unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpLESSCCharCULong::operator()(char* res, const char* op1,
                              const char* op2)
{
    r_ULong longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    r_ULong longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1) || isNull(longOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = longOp1 < longOp2;
    }
}

OpLESSEQUALCCharCULong::OpLESSEQUALCCharCULong(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpLESSEQUALCCharCULong::operator()(char* res, const char* op1,
                                   const char* op2)
{
    r_ULong longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    r_ULong longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1) || isNull(longOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = longOp1 <= longOp2;
    }
}

OpNOTEQUALCCharCULong::OpNOTEQUALCCharCULong(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpNOTEQUALCCharCULong::operator()(char* res, const char* op1,
                                  const char* op2)
{
    r_ULong longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    r_ULong longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1) || isNull(longOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = longOp1 != longOp2;
    }
}

OpGREATERCCharCULong::OpGREATERCCharCULong(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpGREATERCCharCULong::operator()(char* res, const char* op1,
                                 const char* op2)
{
    r_ULong longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    r_ULong longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1) || isNull(longOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = longOp1 > longOp2;
    }
}

OpGREATEREQUALCCharCULong::OpGREATEREQUALCCharCULong(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpGREATEREQUALCCharCULong::operator()(char* res, const char* op1,
                                      const char* op2)
{
    r_ULong longOp1 = *(op1Type->convertToCULong(op1 + op1Off, &longOp1));
    r_ULong longOp2 = *(op2Type->convertToCULong(op2 + op2Off, &longOp2));

    if (isNull(longOp1) || isNull(longOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = longOp1 >= longOp2;
    }
}

OpEQUALCCharCLong::OpEQUALCCharCLong(const BaseType* newResType,
                                     const BaseType* newOp1Type,
                                     const BaseType* newOp2Type,
                                     unsigned int newResOff,
                                     unsigned int newOp1Off,
                                     unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpEQUALCCharCLong::operator()(char* res, const char* op1,
                              const char* op2)
{
    r_Long longOp1 = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    r_Long longOp2 = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));

    if (isNull(longOp1) || isNull(longOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = longOp1 == longOp2;
    }
}

OpLESSCCharCLong::OpLESSCCharCLong(const BaseType* newResType,
                                   const BaseType* newOp1Type,
                                   const BaseType* newOp2Type,
                                   unsigned int newResOff,
                                   unsigned int newOp1Off,
                                   unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpLESSCCharCLong::operator()(char* res, const char* op1,
                             const char* op2)
{
    r_Long longOp1 = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    r_Long longOp2 = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));

    if (isNull(longOp1) || isNull(longOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = longOp1 < longOp2;
    }
}

OpLESSEQUALCCharCLong::OpLESSEQUALCCharCLong(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpLESSEQUALCCharCLong::operator()(char* res, const char* op1,
                                  const char* op2)
{
    r_Long longOp1 = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    r_Long longOp2 = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));

    if (isNull(longOp1) || isNull(longOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = longOp1 <= longOp2;
    }
}

OpNOTEQUALCCharCLong::OpNOTEQUALCCharCLong(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpNOTEQUALCCharCLong::operator()(char* res, const char* op1,
                                 const char* op2)
{
    r_Long longOp1 = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    r_Long longOp2 = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));

    if (isNull(longOp1) || isNull(longOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = longOp1 != longOp2;
    }
}

OpGREATERCCharCLong::OpGREATERCCharCLong(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpGREATERCCharCLong::operator()(char* res, const char* op1,
                                const char* op2)
{
    r_Long longOp1;
    r_Long longOp2;

    *(res + resOff) = *(op1Type->convertToCLong(op1 + op1Off, &longOp1)) >
                      *(op2Type->convertToCLong(op2 + op2Off, &longOp2));
}

OpGREATEREQUALCCharCLong::OpGREATEREQUALCCharCLong(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpGREATEREQUALCCharCLong::operator()(char* res, const char* op1,
                                     const char* op2)
{
    r_Long longOp1 = *(op1Type->convertToCLong(op1 + op1Off, &longOp1));
    r_Long longOp2 = *(op2Type->convertToCLong(op2 + op2Off, &longOp2));

    if (isNull(longOp1) || isNull(longOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = longOp1 >= longOp2;
    }
}

OpEQUALCCharCDouble::OpEQUALCCharCDouble(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpEQUALCCharCDouble::operator()(char* res, const char* op1,
                                const char* op2)
{
    double doubleOp1;
    double doubleOp2;

    op1Type->convertToCDouble(op1 + op1Off, &doubleOp1);
    op2Type->convertToCDouble(op2 + op2Off, &doubleOp2);
    *(res + resOff) = (std::isnan(doubleOp1) && std::isnan(doubleOp2)) || doubleOp1 == doubleOp2;
}

OpLESSCCharCDouble::OpLESSCCharCDouble(const BaseType* newResType,
                                       const BaseType* newOp1Type,
                                       const BaseType* newOp2Type,
                                       unsigned int newResOff,
                                       unsigned int newOp1Off,
                                       unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpLESSCCharCDouble::operator()(char* res, const char* op1,
                               const char* op2)
{
    double doubleOp1 = *(op1Type->convertToCDouble(op1 + op1Off, &doubleOp1));
    double doubleOp2 = *(op2Type->convertToCDouble(op2 + op2Off, &doubleOp2));

    if (isNull(doubleOp1) || isNull(doubleOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = doubleOp1 < doubleOp2;
    }
}

OpLESSEQUALCCharCDouble::OpLESSEQUALCCharCDouble(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpLESSEQUALCCharCDouble::operator()(char* res, const char* op1,
                                    const char* op2)
{
    double doubleOp1 = *(op1Type->convertToCDouble(op1 + op1Off, &doubleOp1));
    double doubleOp2 = *(op2Type->convertToCDouble(op2 + op2Off, &doubleOp2));

    if (isNull(doubleOp1) || isNull(doubleOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = doubleOp1 <= doubleOp2;
    }
}

OpNOTEQUALCCharCDouble::OpNOTEQUALCCharCDouble(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpNOTEQUALCCharCDouble::operator()(char* res, const char* op1,
                                   const char* op2)
{
    double doubleOp1;
    double doubleOp2;

    op1Type->convertToCDouble(op1 + op1Off, &doubleOp1);
    op2Type->convertToCDouble(op2 + op2Off, &doubleOp2);

    if (isNull(doubleOp1) || isNull(doubleOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        bool isNan1 = std::isnan(doubleOp1);
        bool isNan2 = std::isnan(doubleOp2);
        *(res + resOff) = (isNan1 != isNan2) || (!(isNan1 || isNan2) && doubleOp1 != doubleOp2);
    }
}

OpGREATERCCharCDouble::OpGREATERCCharCDouble(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpGREATERCCharCDouble::operator()(char* res, const char* op1,
                                  const char* op2)
{
    double doubleOp1 = *(op1Type->convertToCDouble(op1 + op1Off, &doubleOp1));
    double doubleOp2 = *(op2Type->convertToCDouble(op2 + op2Off, &doubleOp2));

    if (isNull(doubleOp1) || isNull(doubleOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = doubleOp1 > doubleOp2;
    }
}

OpGREATEREQUALCCharCDouble::OpGREATEREQUALCCharCDouble(const BaseType* newResType,
        const BaseType* newOp1Type,
        const BaseType* newOp2Type,
        unsigned int newResOff,
        unsigned int newOp1Off,
        unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpGREATEREQUALCCharCDouble::operator()(char* res, const char* op1,
                                       const char* op2)
{
    double doubleOp1 = *(op1Type->convertToCDouble(op1 + op1Off, &doubleOp1));
    double doubleOp2 = *(op2Type->convertToCDouble(op2 + op2Off, &doubleOp2));

    if (isNull(doubleOp1) || isNull(doubleOp2))
    {
        *(res + resOff) = false;
    }
    else
    {
        *(res + resOff) = doubleOp1 >= doubleOp2;
    }
}

CondenseOp::CondenseOp(const BaseType* newResType, const BaseType* newOpType,
                       unsigned int newResOff, unsigned int newOpOff)
    : NullValuesHandler(), accu(0), opType(newOpType), resType(newResType), resOff(newResOff), opOff(newOpOff),
      initialized(false), nullAccu(false)
{
    nullValues = NULL;
}

CondenseOp::CondenseOp(const BaseType* newResType, char* newAccu,
                       const BaseType* newOpType, unsigned int newResOff,
                       unsigned int newOpOff)
    : NullValuesHandler(), opType(newOpType), resType(newResType), resOff(newResOff), opOff(newOpOff),
      initialized(false), nullAccu(false)
{
    nullValues = NULL;
    accu = new char[resType->getSize()];
    memcpy(accu, newAccu, resType->getSize());
}

char*
CondenseOp::getAccuVal()
{
    return accu;
}

CondenseOp::~CondenseOp()
{
    delete [] accu;
}


OpSOMECChar::OpSOMECChar(const BaseType* newResType, const BaseType* newOpType,
                         unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    // initialising with neutral value
    accu = new char[1];
    // result is always char
    *accu = 0;
}

OpSOMECChar::OpSOMECChar(const BaseType* newResType, char* newAccu,
                         const BaseType* newOpType, unsigned int newResOff,
                         unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
{
}

char*
OpSOMECChar::operator()(const char* op, char* init)
{
    *(unsigned char*)(init + resOff) = *(unsigned char*)(init + resOff) || *(unsigned char*)(const_cast<char*>(op) + opOff);
    return init;
}

char*
OpSOMECChar::operator()(const char* op)
{
    *(unsigned char*)(accu + resOff) = *(unsigned char*)(accu + resOff) || *(unsigned char*)(const_cast<char*>(op) + opOff);
    return accu;
}

OpALLCChar::OpALLCChar(const BaseType* newResType, const BaseType* newOpType,
                       unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    // initialising with neutral value
    accu = new char[1];
    // result is always char
    *accu = 1;
}

OpALLCChar::OpALLCChar(const BaseType* newResType, char* newAccu,
                       const BaseType* newOpType, unsigned int newResOff,
                       unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
{
}

char*
OpALLCChar::operator()(const char* op, char* init)
{
    *(unsigned char*)(init + resOff) = *(unsigned char*)(init + resOff) &&
                                       *(unsigned char*)(const_cast<char*>(op) + opOff);
    return init;
}

char*
OpALLCChar::operator()(const char* op)
{
    *(unsigned char*)(accu + resOff) = *(unsigned char*)(accu + resOff) &&
                                       *(unsigned char*)(const_cast<char*>(op) + opOff);
    return accu;
}

OpCOUNTCChar::OpCOUNTCChar(const BaseType* newResType, const BaseType* newOpType,
                           unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    // initialising with neutral value
    accu = new char[4];
    // result is always r_ULong
    *(r_ULong*)accu = 0;

}

OpCOUNTCChar::OpCOUNTCChar(const BaseType* newResType, char* newAccu,
                           const BaseType* newOpType, unsigned int newResOff,
                           unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
{
}

char*
OpCOUNTCChar::operator()(const char* op, char* init)
{
    *(r_ULong*)(init + resOff) = *(r_ULong*)(init + resOff) +
                                 *(unsigned char*)(const_cast<char*>(op) + opOff);
    return init;
}

char*
OpCOUNTCChar::operator()(const char* op)
{
    *(r_ULong*)(accu + resOff) = *(r_ULong*)(accu + resOff) +
                                 *(unsigned char*)(const_cast<char*>(op) + opOff);
    return accu;
}

OpMAXCULong::OpMAXCULong(const BaseType* newResType, const BaseType* newOpType,
                         unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    r_ULong myVal = 0;
    // initialising with neutral value
    accu = new char[resType->getSize()];
    resType->makeFromCULong(accu, &myVal);
}

OpMAXCULong::OpMAXCULong(const BaseType* newResType, char* newAccu,
                         const BaseType* newOpType, unsigned int newResOff,
                         unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
{
}

char*
OpMAXCULong::operator()(const char* op, char* init)
{
    r_ULong longOp = 0;
    r_ULong longRes = 0;

    longOp = *(opType->convertToCULong(op + opOff, &longOp));
    longRes = *(resType->convertToCULong(init + resOff, &longRes));

    if (!initialized)
    {
        if (isNullOnly(longOp))
        {
            resType->makeFromCULong(accu, &longOp);
            nullAccu = true;
        }
        initialized = true;
    }

    if (!isNull(longOp) && (nullAccu || longOp > longRes))
    {
        resType->makeFromCULong(init + resOff, &longOp);
        nullAccu = false;
    }

    return init;
}

char*
OpMAXCULong::operator()(const char* op)
{
    return OpMAXCULong::operator()(op, accu);
}

OpMAXCLong::OpMAXCLong(const BaseType* newResType, const BaseType* newOpType,
                       unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    r_Long myVal = INT_MIN;
    // initialising with neutral value
    accu = new char[resType->getSize()];
    resType->makeFromCLong(accu, &myVal);
}

OpMAXCLong::OpMAXCLong(const BaseType* newResType, char* newAccu,
                       const BaseType* newOpType, unsigned int newResOff,
                       unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
{
}

char*
OpMAXCLong::operator()(const char* op, char* init)
{
    r_Long longOp = 0;
    r_Long longRes = 0;

    longOp = *(opType->convertToCLong(op + opOff, &longOp));
    longRes = *(resType->convertToCLong(init + resOff, &longRes));

    if (!initialized)
    {
        if (isNullOnly(longOp))
        {
            resType->makeFromCLong(accu, &longOp);
            nullAccu = true;
        }
        initialized = true;
    }

    if (!isNull(longOp) && (nullAccu || longOp > longRes))
    {
        resType->makeFromCLong(init + resOff, &longOp);
        nullAccu = false;
    }

    return init;
}

char*
OpMAXCLong::operator()(const char* op)
{
    return OpMAXCLong::operator()(op, accu);
}

OpMAXCDouble::OpMAXCDouble(const BaseType* newResType, const BaseType* newOpType,
                           unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    double myVal = (-1.0) * DBL_MAX;
    // initialising with neutral value
    accu = new char[resType->getSize()];
    // make sure accu contains a legal float
    memset(accu, 0, resType->getSize());
    resType->makeFromCDouble(accu, &myVal);
}

OpMAXCDouble::OpMAXCDouble(const BaseType* newResType, char* newAccu,
                           const BaseType* newOpType, unsigned int newResOff,
                           unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
{
}

char*
OpMAXCDouble::operator()(const char* op, char* init)
{
    double longOp = 0;
    double longRes = 0;

    longOp = *(opType->convertToCDouble(op + opOff, &longOp));
    longRes = *(resType->convertToCDouble(init + resOff, &longRes));

    if (!initialized)
    {
        if (isNullOnly(longOp))
        {
            resType->makeFromCDouble(accu, &longOp);
            nullAccu = true;
        }
        initialized = true;
    }

    if (!isNull(longOp) && (nullAccu || longOp > longRes))
    {
        resType->makeFromCDouble(init + resOff, &longOp);
        nullAccu = false;
    }

    return init;
}

char*
OpMAXCDouble::operator()(const char* op)
{
    return OpMAXCDouble::operator()(op, accu);
}

OpMINCULong::OpMINCULong(const BaseType* newResType, const BaseType* newOpType,
                         unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    r_ULong myVal = UINT_MAX;
    // initialising with neutral value
    accu = new char[resType->getSize()];
    resType->makeFromCULong(accu, &myVal);
}

OpMINCULong::OpMINCULong(const BaseType* newResType, char* newAccu,
                         const BaseType* newOpType, unsigned int newResOff,
                         unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
{
}

char*
OpMINCULong::operator()(const char* op, char* init)
{
    r_ULong longOp = 0;
    r_ULong longRes = 0;

    longOp = *(opType->convertToCULong(op + opOff, &longOp));
    longRes = *(resType->convertToCULong(init + resOff, &longRes));

    if (!initialized)
    {
        if (isNullOnly(longOp))
        {
            resType->makeFromCULong(accu, &longOp);
            nullAccu = true;
        }
        initialized = true;
    }

    if (!isNull(longOp) && (nullAccu || longOp < longRes))
    {
        resType->makeFromCULong(init + resOff, &longOp);
        nullAccu = false;
    }

    return init;
}

char*
OpMINCULong::operator()(const char* op)
{
    return OpMINCULong::operator()(op, accu);
}

OpMINCLong::OpMINCLong(const BaseType* newResType, const BaseType* newOpType,
                       unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    r_Long myVal = INT_MAX;
    // initialising with neutral value
    accu = new char[resType->getSize()];
    resType->makeFromCLong(accu, &myVal);
}

OpMINCLong::OpMINCLong(const BaseType* newResType, char* newAccu,
                       const BaseType* newOpType, unsigned int newResOff,
                       unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
{
}

char*
OpMINCLong::operator()(const char* op, char* init)
{
    r_Long longOp = 0;
    r_Long longRes = 0;

    longOp = *(opType->convertToCLong(op + opOff, &longOp));
    longRes = *(resType->convertToCLong(init + resOff, &longRes));

    if (!initialized)
    {
        if (isNullOnly(longOp))
        {
            resType->makeFromCLong(accu, &longOp);
            nullAccu = true;
        }
        initialized = true;
    }

    if (!isNull(longOp) && (nullAccu || longOp < longRes))
    {
        resType->makeFromCLong(init + resOff, &longOp);
        nullAccu = false;
    }

    return init;
}

char*
OpMINCLong::operator()(const char* op)
{
    return OpMINCLong::operator()(op, accu);
}

OpMINCDouble::OpMINCDouble(const BaseType* newResType, const BaseType* newOpType,
                           unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    double myVal = DBL_MAX;
    // initialising with neutral value
    accu = new char[resType->getSize()];
    // make sure accu contains a legal float
    memset(accu, 0, resType->getSize());
    resType->makeFromCDouble(accu, &myVal);
}


OpMINCDouble::OpMINCDouble(const BaseType* newResType, char* newAccu,
                           const BaseType* newOpType, unsigned int newResOff,
                           unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
{
}

char*
OpMINCDouble::operator()(const char* op, char* init)
{
    double longOp = 0;
    double longRes = 0;

    longOp = *(opType->convertToCDouble(op + opOff, &longOp));
    longRes = *(resType->convertToCDouble(init + resOff, &longRes));

    if (!initialized)
    {
        if (isNullOnly(longOp))
        {
            resType->makeFromCDouble(accu, &longOp);
            nullAccu = true;
        }
        initialized = true;
    }

    if (!isNull(longOp) && (nullAccu || longOp < longRes))
    {
        resType->makeFromCDouble(init + resOff, &longOp);
        nullAccu = false;
    }

    return init;
}

char*
OpMINCDouble::operator()(const char* op)
{
    return OpMINCDouble::operator()(op, accu);
}

OpSUMCULong::OpSUMCULong(const BaseType* newResType, const BaseType* newOpType,
                         unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    r_ULong myVal = 0;
    // initialising with neutral value
    accu = new char[resType->getSize()];
    resType->makeFromCULong(accu, &myVal);
}

OpSUMCULong::OpSUMCULong(const BaseType* newResType, char* newAccu,
                         const BaseType* newOpType, unsigned int newResOff,
                         unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
{
}

char*
OpSUMCULong::operator()(const char* op, char* init)
{
    r_ULong longOp = 0;
    r_ULong longRes = 0;

    opType->convertToCULong(op + opOff, &longOp);
    resType->convertToCULong(init + resOff, &longRes);

    if (!initialized)
    {
        if (isNullOnly(longOp))
        {
            LWARNING << "longOp is null: " << longOp;
            resType->makeFromCULong(accu, &longOp);
            nullAccu = true;
        }
        initialized = true;
    }

    if (!isNull(longOp))
    {
        if (nullAccu)
        {
            longRes = longOp;
            nullAccu = false;
        }
        else
        {
            longRes += longOp;
        }

        resType->makeFromCULong(init + resOff, &longRes);
    }

    return init;
}

char*
OpSUMCULong::operator()(const char* op)
{
    return OpSUMCULong::operator()(op, accu);
}

OpSUMCLong::OpSUMCLong(const BaseType* newResType, const BaseType* newOpType,
                       unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    r_Long myVal = 0;
    // initialising with neutral value
    accu = new char[resType->getSize()];
    resType->makeFromCLong(accu, &myVal);
}

OpSUMCLong::OpSUMCLong(const BaseType* newResType, char* newAccu,
                       const BaseType* newOpType, unsigned int newResOff,
                       unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
{
}

char*
OpSUMCLong::operator()(const char* op, char* init)
{
    r_Long longOp = 0;
    r_Long longRes = 0;

    longOp = *(opType->convertToCLong(op + opOff, &longOp));
    longRes = *(resType->convertToCLong(init + resOff, &longRes));

    if (!initialized)
    {
        if (isNullOnly(longOp))
        {
            resType->makeFromCLong(accu, &longOp);
            nullAccu = true;
        }
        initialized = true;
    }

    if (!isNull(longOp))
    {
        if (nullAccu)
        {
            longRes = longOp;
            nullAccu = false;
        }
        else
        {
            longRes += longOp;
        }

        resType->makeFromCLong(init + resOff, &longRes);
    }

    return init;
}

char*
OpSUMCLong::operator()(const char* op)
{
    return OpSUMCLong::operator()(op, accu);
}

OpSUMCDouble::OpSUMCDouble(const BaseType* newResType, const BaseType* newOpType,
                           unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    double myVal = 0.0;
    // initialising with neutral value
    accu = new char[resType->getSize()];
    resType->makeFromCDouble(accu, &myVal);
}

OpSUMCDouble::OpSUMCDouble(const BaseType* newResType, char* newAccu,
                           const BaseType* newOpType, unsigned int newResOff,
                           unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
{
}

char*
OpSUMCDouble::operator()(const char* op, char* init)
{
    double longOp = 0;
    double longRes = 0;

    longOp = *(opType->convertToCDouble(op + opOff, &longOp));
    longRes = *(resType->convertToCDouble(init + resOff, &longRes));

    if (!initialized)
    {
        if (isNullOnly(longOp))
        {
            resType->makeFromCDouble(accu, &longOp);
            nullAccu = true;
        }
        initialized = true;
    }

    if (!isNull(longOp))
    {
        if (nullAccu)
        {
            longRes = longOp;
            nullAccu = false;
        }
        else
        {
            longRes += longOp;
        }

        resType->makeFromCDouble(init + resOff, &longRes);
    }

    return init;
}

char*
OpSUMCDouble::operator()(const char* op)
{
    return OpSUMCDouble::operator()(op, accu);
}

OpCondenseStruct::OpCondenseStruct(
    const BaseType* newResType,
    const BaseType* newOpType,
    Ops::OpType op,
    unsigned int newResOff,
    unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    unsigned int i = 0;

    myResType = (StructType*)const_cast<BaseType*>(newResType);
    myOpType = (StructType*)const_cast<BaseType*>(newOpType);
    numElems = myOpType->getNumElems();
    elemOps = new CondenseOp*[numElems];
    for (i = 0; i < numElems; i++)
    {
        elemOps[i] = Ops::getCondenseOp(
                         op,
                         myResType->getElemType(i),
                         myOpType->getElemType(i),
                         newResOff + myResType->getOffset(i),
                         newOpOff + myOpType->getOffset(i)
                     );
    }

    accu = new char[resType->getSize()];
    for (i = 0; i < numElems; i++)
    {
        memcpy(accu + myResType->getOffset(i), elemOps[i]->getAccuVal(),
               myResType->getElemType(i)->getSize());
    }

}

//--------------------------------------------
//  OpCondenseStruct
//--------------------------------------------

OpCondenseStruct::OpCondenseStruct(
    const BaseType* newResType,
    char* newAccu,
    const BaseType* newOpType,
    Ops::OpType op,
    unsigned int newResOff,
    unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
{
    unsigned int i = 0;

    myResType = (StructType*)const_cast<BaseType*>(newResType);
    myOpType = (StructType*)const_cast<BaseType*>(newOpType);
    numElems = myOpType->getNumElems();
    elemOps = new CondenseOp*[numElems];
    for (i = 0; i < numElems; i++)
    {
        elemOps[i] = Ops::getCondenseOp(
                         op,
                         myResType->getElemType(i),
                         myOpType->getElemType(i),
                         newResOff + myResType->getOffset(i),
                         newOpOff + myOpType->getOffset(i)
                     );
    }

    accu = new char[resType->getSize()];
    memcpy(accu, newAccu, resType->getSize());
}

OpCondenseStruct::~OpCondenseStruct()
{
    unsigned int i;

    for (i = 0; i < numElems; i++)
    {
        delete elemOps[i];
    }
    delete[] elemOps;
}

char*
OpCondenseStruct::operator()(const char* op, char* init)
{
    unsigned int i;

    for (i = 0; i < numElems; i++)
    {
        (*elemOps[i])(op, init);
    }
    return init;
}

char*
OpCondenseStruct::operator()(const char* op)
{
    unsigned int i;

    for (i = 0; i < numElems; i++)
    {
        (*elemOps[i])(op, accu);
    }
    return accu;
}



//--------------------------------------------
//  OpBinaryStruct
//--------------------------------------------

static Ops::OpType _operation;

OpBinaryStruct::OpBinaryStruct(const BaseType* newStructType, Ops::OpType op,
                               unsigned int newResOff, unsigned int newOp1Off,
                               unsigned int newOp2Off)
    : BinaryOp(newStructType, newStructType, newStructType, newResOff,
               newOp1Off, newOp2Off)
{
    unsigned int i = 0;

    _operation = op;
    BaseType* boolType = ((BaseType*)ObjectBroker::getObjectByName(OId::ATOMICTYPEOID, "Bool"));


    myStructType = (StructType*)const_cast<BaseType*>(newStructType);
    numElems = myStructType->getNumElems();
    elemOps = new BinaryOp*[numElems];
    equalOps = new BinaryOp*[numElems];
    lessOps = new BinaryOp*[numElems];
    assignmentOps = new UnaryOp*[numElems];
    for (i = 0; i < numElems; i++)
    {
        equalOps[i] = NULL;
        lessOps[i] = NULL;
        assignmentOps[i] = NULL;
        elemOps[i] = NULL;
        if (op == Ops::OP_MIN_BINARY || op == Ops::OP_MAX_BINARY)
        {
            lessOps[i] = Ops::getBinaryOp(Ops::OP_LESS, boolType,
                                          myStructType->getElemType(i),
                                          myStructType->getElemType(i),
                                          0,
                                          newOp1Off + myStructType->getOffset(i),
                                          newOp2Off + myStructType->getOffset(i));
            equalOps[i] = Ops::getBinaryOp(Ops::OP_EQUAL, boolType,
                                           myStructType->getElemType(i),
                                           myStructType->getElemType(i),
                                           0,
                                           newOp1Off + myStructType->getOffset(i),
                                           newOp2Off + myStructType->getOffset(i));
            assignmentOps[i] = Ops::getUnaryOp(Ops::OP_IDENTITY, myStructType->getElemType(i),
                                               myStructType->getElemType(i),
                                               newResOff + myStructType->getOffset(i),
                                               newOp1Off + myStructType->getOffset(i));
        }
        else
        {
            elemOps[i] = Ops::getBinaryOp(op, myStructType->getElemType(i),
                                          myStructType->getElemType(i),
                                          myStructType->getElemType(i),
                                          newResOff + myStructType->getOffset(i),
                                          newOp1Off + myStructType->getOffset(i),
                                          newOp2Off + myStructType->getOffset(i));
        }
    }
}

OpBinaryStruct::~OpBinaryStruct()
{
    unsigned int i;

    for (i = 0; i < numElems; i++)
    {
        if (elemOps[i])
        {
            delete elemOps[i];
        }
        if (lessOps[i])
        {
            delete lessOps[i];
        }
        if (equalOps[i])
        {
            delete equalOps[i];
        }
        if (assignmentOps[i])
        {
            delete assignmentOps[i];
        }
    }
    delete[] elemOps;
    delete[] lessOps;
    delete[] equalOps;
    delete[] assignmentOps;
}

void
OpBinaryStruct::operator()(char* res, const char* op1,
                           const char* op2)
{
    unsigned int i;

    if (_operation == Ops::OP_OVERLAY)
    {
        for (i = 0; i < numElems; ++i)
            if (*(op2 + op2Off) && !isNull(*(op2 + op2Off)))
            {
                for (unsigned int j = 0; j < numElems; ++j)
                {
                    *(res + resOff) = *(op2 + op2Off);
                }
                return;
            }
    }
    if (_operation == Ops::OP_MIN_BINARY || _operation == Ops::OP_MAX_BINARY)
    {
        bool op1Min = true;
        for (i = 0; i < numElems; ++i)
        {
            (*lessOps[i])(boolRes, op1, op2);
            bool op1LessThanOp2 = *((bool*)(boolRes));
            if (!op1LessThanOp2)
            {
                (*equalOps[i])(boolRes, op1, op2);
                bool op1EqualToOp2 = *((bool*)(boolRes));
                if (!op1EqualToOp2)
                {
                    op1Min = false;
                    break;
                }
            }
        }
        const char* op = op1;
        if ((_operation == Ops::OP_MIN_BINARY && !op1Min) ||
                (_operation == Ops::OP_MAX_BINARY && op1Min))
        {
            op = op2;
        }
        for (i = 0; i < numElems; i++)
        {
            (*assignmentOps[i])(res, op);
        }
    }
    else
    {
        for (i = 0; i < numElems; i++)
        {
            (*elemOps[i])(res, op1, op2);
        }
    }

}

//--------------------------------------------
//  OpBinaryStructConst
//--------------------------------------------

OpBinaryStructConst::OpBinaryStructConst(
    const BaseType* res,
    const BaseType* op1,
    const BaseType* op2,
    Ops::OpType op,
    unsigned int newResOff,
    unsigned int newOp1Off,
    unsigned int newOp2Off)
    : BinaryOp(res, op1, op2, newResOff,
               newOp1Off, newOp2Off)
{
    unsigned int i = 0;

    resStructType = (StructType*)const_cast<BaseType*>(resType);
    opStructType = (StructType*)const_cast<BaseType*>(op1Type);
    numElems = opStructType->getNumElems();
    elemOps = new BinaryOp*[numElems];
    for (i = 0; i < numElems; i++)
    {
        elemOps[i] = Ops::getBinaryOp(op,
                                      resStructType->getElemType(i),
                                      opStructType->getElemType(i),
                                      op2Type,
                                      newResOff + resStructType->getOffset(i),
                                      newOp1Off + opStructType->getOffset(i),
                                      newOp2Off);
    }
}

OpBinaryStructConst::~OpBinaryStructConst()
{
    unsigned int i;

    for (i = 0; i < numElems; i++)
    {
        delete elemOps[i];
    }
    delete[] elemOps;
}

void
OpBinaryStructConst::operator()(char* res, const char* op1,
                                const char* op2)
{
    unsigned int i;

    for (i = 0; i < numElems; i++)
    {
        (*elemOps[i])(res, op1, op2);
    }
}

//--------------------------------------------
//  OpBinaryConstStruct
//--------------------------------------------

OpBinaryConstStruct::OpBinaryConstStruct(
    const BaseType* res,
    const BaseType* op1,
    const BaseType* op2,
    Ops::OpType op,
    unsigned int newResOff,
    unsigned int newOp1Off,
    unsigned int newOp2Off)
    : BinaryOp(res, op1, op2, newResOff,
               newOp1Off, newOp2Off)
{
    unsigned int i = 0;

    resStructType = (StructType*)const_cast<BaseType*>(resType);
    opStructType = (StructType*)const_cast<BaseType*>(op2Type);
    numElems = opStructType->getNumElems();
    elemOps = new BinaryOp*[numElems];
    for (i = 0; i < numElems; i++)
    {
        elemOps[i] = Ops::getBinaryOp(op,
                                      resStructType->getElemType(i),
                                      op1Type,
                                      opStructType->getElemType(i),
                                      newResOff + resStructType->getOffset(i),
                                      newOp1Off,
                                      newOp2Off + opStructType->getOffset(i));
    }
}

OpBinaryConstStruct::~OpBinaryConstStruct()
{
    unsigned int i;

    for (i = 0; i < numElems; i++)
    {
        delete elemOps[i];
    }
    delete[] elemOps;
}

void
OpBinaryConstStruct::operator()(char* res, const char* op1,
                                const char* op2)
{
    unsigned int i;

    for (i = 0; i < numElems; i++)
    {
        (*elemOps[i])(res, op1, op2);
    }
}

//--------------------------------------------
//  OpEQUALStruct
//--------------------------------------------

OpEQUALStruct::OpEQUALStruct(const BaseType* newResType,
                             const BaseType* newOp1Type,
                             const BaseType* newOp2Type,
                             unsigned int newResOff,
                             unsigned int newOp1Off,
                             unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
    unsigned int i = 0;

    numElems = ((StructType*)const_cast<BaseType*>(op1Type))->getNumElems();
    elemOps = new BinaryOp*[numElems];
    for (i = 0; i < numElems; i++)
    {
        elemOps[i] =
            Ops::getBinaryOp(Ops::OP_EQUAL, resType,
                             ((StructType*)const_cast<BaseType*>(op1Type))->getElemType(i),
                             ((StructType*)const_cast<BaseType*>(op2Type))->getElemType(i),
                             newResOff,
                             newOp1Off + ((StructType*)const_cast<BaseType*>(op1Type))->getOffset(i),
                             newOp2Off + ((StructType*)const_cast<BaseType*>(op2Type))->getOffset(i));
    }
}

OpEQUALStruct::~OpEQUALStruct()
{
    unsigned int i;

    for (i = 0; i < numElems; i++)
    {
        delete elemOps[i];
    }
    delete[] elemOps;
}

void
OpEQUALStruct::operator()(char* res, const char* op1,
                          const char* op2)
{
    unsigned int i;
    char dummy = 1;

    for (i = 0; i < numElems; i++)
    {
        (*elemOps[i])(res, op1, op2);
        dummy = *res && dummy;
    }
    *res = dummy;
}

//--------------------------------------------
//  OpNOTEQUALStruct
//--------------------------------------------

OpNOTEQUALStruct::OpNOTEQUALStruct(const BaseType* newResType,
                                   const BaseType* newOp1Type,
                                   const BaseType* newOp2Type,
                                   unsigned int newResOff,
                                   unsigned int newOp1Off,
                                   unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
    unsigned int i = 0;

    numElems = ((StructType*)const_cast<BaseType*>(op1Type))->getNumElems();
    elemOps = new BinaryOp*[numElems];
    for (i = 0; i < numElems; i++)
    {
        elemOps[i] =
            Ops::getBinaryOp(Ops::OP_NOTEQUAL, resType,
                             ((StructType*)const_cast<BaseType*>(op1Type))->getElemType(i),
                             ((StructType*)const_cast<BaseType*>(op2Type))->getElemType(i),
                             newResOff,
                             newOp1Off + ((StructType*)const_cast<BaseType*>(op1Type))->getOffset(i),
                             newOp2Off + ((StructType*)const_cast<BaseType*>(op2Type))->getOffset(i));
    }
}

OpNOTEQUALStruct::~OpNOTEQUALStruct()
{
    unsigned int i;

    for (i = 0; i < numElems; i++)
    {
        delete elemOps[i];
    }
    delete[] elemOps;
}

void
OpNOTEQUALStruct::operator()(char* res, const char* op1,
                             const char* op2)
{
    unsigned int i;
    char dummy = 0;

    for (i = 0; i < numElems; i++)
    {
        (*elemOps[i])(res, op1, op2);
        dummy = *res || dummy;
    }
    *res = dummy;
}

//--------------------------------------------
//  OpUnaryStruct
//--------------------------------------------

OpUnaryStruct::OpUnaryStruct(
    const BaseType* newResType,
    const BaseType* newOpType,
    Ops::OpType op,
    unsigned int newResOff,
    unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
    unsigned int i = 0;

    myResType = (StructType*)const_cast<BaseType*>(newResType);
    myOpType = (StructType*)const_cast<BaseType*>(newOpType);
    numElems = myOpType->getNumElems();
    elemOps = new UnaryOp*[numElems];
    for (i = 0; i < numElems; i++)
    {
        elemOps[i] = Ops::getUnaryOp(
                         op,
                         myResType->getElemType(i),
                         myOpType->getElemType(i),
                         newResOff + myResType->getOffset(i),
                         newOpOff + myOpType->getOffset(i)
                     );
    }
}

OpUnaryStruct::~OpUnaryStruct()
{
    unsigned int i;

    for (i = 0; i < numElems; i++)
    {
        delete elemOps[i];
    }
    delete[] elemOps;
}

void
OpUnaryStruct::operator()(char* result, const char* op)
{
    unsigned int i;

    for (i = 0; i < numElems; i++)
    {
        try
        {
            (*elemOps[i])(result, op);
        }
        catch (...)
        {
            // cleanup
            for (i = 0; i < numElems; i++)
            {
                delete elemOps[i];
            }
            delete[] elemOps;
            throw;
        }
    }
}

//--------------------------------------------
//  OpPLUSChar
//--------------------------------------------

OpPLUSChar::OpPLUSChar(const BaseType* newResType, const BaseType* newOp1Type,
                       const BaseType* newOp2Type, unsigned int newResOff,
                       unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpPLUSChar::operator()(char* res, const char* op1, const char* op2)
{
    if (isNull(*(unsigned char*)(const_cast<char*>(op1) + op1Off)))
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1)  + op1Off);
    }
    else if (isNull(*(unsigned char*)(const_cast<char*>(op2)  + op2Off)))
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op2)  + op2Off);
    }
    else
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1) + op1Off)
                                          + *(unsigned char*)(const_cast<char*>(op2)  + op2Off);
    }
}

void
OpPLUSChar::getCondenseInit(char* init)
{
    *init = 0;
}

//--------------------------------------------
//  OpMAX_BINARYChar
//--------------------------------------------

OpMAX_BINARYChar::OpMAX_BINARYChar(const BaseType* newResType, const BaseType* newOp1Type,
                                   const BaseType* newOp2Type, unsigned int newResOff,
                                   unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMAX_BINARYChar::operator()(char* res, const char* op1, const char* op2)
{
    if (*(unsigned char*)(const_cast<char*>(op1)  + op1Off) > *(unsigned char*)(const_cast<char*>(op2)  + op2Off))
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1)  + op1Off);
    }
    else
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op2)  + op2Off);
    }
}

void
OpMAX_BINARYChar::getCondenseInit(char* init)
{
    *init = 0;
}

//--------------------------------------------
//  OpMIN_BINARYChar
//--------------------------------------------

OpMIN_BINARYChar::OpMIN_BINARYChar(const BaseType* newResType, const BaseType* newOp1Type,
                                   const BaseType* newOp2Type, unsigned int newResOff,
                                   unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMIN_BINARYChar::operator()(char* res, const char* op1, const char* op2)
{
    if (*(unsigned char*)(const_cast<char*>(op1)  + op1Off) < * (unsigned char*)(const_cast<char*>(op2)  + op2Off))
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1)  + op1Off);
    }
    else
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op2)  + op2Off);
    }
}

void
OpMIN_BINARYChar::getCondenseInit(char* init)
{
    *init = 0;
}

//--------------------------------------------
//  OpMINUSChar
//--------------------------------------------

OpMINUSChar::OpMINUSChar(const BaseType* newResType, const BaseType* newOp1Type,
                         const BaseType* newOp2Type, unsigned int newResOff,
                         unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMINUSChar::operator()(char* res, const char* op1, const char* op2)
{
    if (isNull(*(unsigned char*)(const_cast<char*>(op1)  + op1Off)))
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1) + op1Off);
    }
    else if (isNull(*(unsigned char*)(const_cast<char*>(op2)  + op2Off)))
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op2)  + op2Off);
    }
    else
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1) + op1Off)
                                          - *(unsigned char*)(const_cast<char*>(op2)  + op2Off);
    }
}

//--------------------------------------------
//  OpDIVChar
//--------------------------------------------

OpDIVChar::OpDIVChar(const BaseType* newResType, const BaseType* newOp1Type,
                     const BaseType* newOp2Type, unsigned int newResOff,
                     unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpDIVChar::operator()(char* res, const char* op1, const char* op2)
{
    if (isNull(*(unsigned char*)(const_cast<char*>(op1) + op1Off)))
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1) + op1Off);
    }
    else if (isNull(*(unsigned char*)(const_cast<char*>(op2)  + op2Off)))
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op2)  + op2Off);
    }
    else
    {
        if (*(unsigned char*)(const_cast<char*>(op2)  + op2Off) == 0)
        {
            throw DIVISION_BY_ZERO;
        }
        else
        {
            *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op2)  + op1Off)
                                              / *(unsigned char*)(const_cast<char*>(op2)  + op2Off);
        }
    }
}

//--------------------------------------------
//  OpMODChar
//--------------------------------------------

OpMODChar::OpMODChar(const BaseType* newResType, const BaseType* newOp1Type,
                     const BaseType* newOp2Type, unsigned int newResOff,
                     unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMODChar::operator()(char* res, const char* op1, const char* op2)
{
    if (isNull(*(unsigned char*)(const_cast<char*>(op1) + op1Off)))
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1) + op1Off);
    }
    else if (isNull(*(unsigned char*)(const_cast<char*>(op2) + op2Off)))
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op2) + op2Off);
    }
    else
    {
        if (*(unsigned char*)(const_cast<char*>(op2) + op2Off) == 0)
        {
            throw DIVISION_BY_ZERO;
        }
        else
        {
            *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1) + op1Off) %
                                              *(unsigned char*)(const_cast<char*>(op2) + op2Off);
        }
    }
}

//--------------------------------------------
//  OpMULTChar
//--------------------------------------------

OpMULTChar::OpMULTChar(const BaseType* newResType, const BaseType* newOp1Type,
                       const BaseType* newOp2Type, unsigned int newResOff,
                       unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpMULTChar::operator()(char* res, const char* op1, const char* op2)
{
    if (isNull(*(unsigned char*)(const_cast<char*>(op1) + op1Off)))
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1) + op1Off);
    }
    else if (isNull(*(unsigned char*)(const_cast<char*>(op2) + op2Off)))
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op2) + op2Off);
    }
    else
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1) + op1Off)
                                          * *(unsigned char*)(const_cast<char*>(op2) + op2Off);
    }
}

void
OpMULTChar::getCondenseInit(char* init)
{
    *init = 1;
}

//--------------------------------------------
//  OpEQUALChar
//--------------------------------------------

OpEQUALChar::OpEQUALChar(const BaseType* newResType,
                         const BaseType* newOp1Type,
                         const BaseType* newOp2Type,
                         unsigned int newResOff,
                         unsigned int newOp1Off,
                         unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpEQUALChar::operator()(char* res, const char* op1,
                        const char* op2)
{
    if (isNull(*(unsigned char*)(const_cast<char*>(op1) + op1Off)) || isNull(*(unsigned char*)(const_cast<char*>(op2) + op2Off)))
    {
        *(unsigned char*)(res + resOff) = false;
    }
    else
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1) + op1Off) ==
                                          *(unsigned char*)(const_cast<char*>(op2) + op2Off);
    }
}

//--------------------------------------------
//  OpLESSChar
//--------------------------------------------

OpLESSChar::OpLESSChar(const BaseType* newResType,
                       const BaseType* newOp1Type,
                       const BaseType* newOp2Type,
                       unsigned int newResOff,
                       unsigned int newOp1Off,
                       unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpLESSChar::operator()(char* res, const char* op1,
                       const char* op2)
{
    if (isNull(*(unsigned char*)(const_cast<char*>(op1) + op1Off)) || isNull(*(unsigned char*)(const_cast<char*>(op2) + op2Off)))
    {
        *(unsigned char*)(res + resOff) = false;
    }
    else
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1) + op1Off) <
                                          *(unsigned char*)(const_cast<char*>(op2) + op2Off);
    }
}

//--------------------------------------------
//  OpLESSEQUALChar
//--------------------------------------------

OpLESSEQUALChar::OpLESSEQUALChar(const BaseType* newResType,
                                 const BaseType* newOp1Type,
                                 const BaseType* newOp2Type,
                                 unsigned int newResOff,
                                 unsigned int newOp1Off,
                                 unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpLESSEQUALChar::operator()(char* res, const char* op1,
                            const char* op2)
{
    if (isNull(*(unsigned char*)(const_cast<char*>(op1)  + op1Off)) || isNull(*(unsigned char*)(const_cast<char*>(op2) + op2Off)))
    {
        *(unsigned char*)(res + resOff) = false;
    }
    else
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1)  + op1Off) <=
                                          *(unsigned char*)(const_cast<char*>(op2)  + op2Off);
    }
}

//--------------------------------------------
//  OpNOTEQUALChar
//--------------------------------------------

OpNOTEQUALChar::OpNOTEQUALChar(const BaseType* newResType,
                               const BaseType* newOp1Type,
                               const BaseType* newOp2Type,
                               unsigned int newResOff,
                               unsigned int newOp1Off,
                               unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpNOTEQUALChar::operator()(char* res, const char* op1,
                           const char* op2)
{
    if (isNull(*(unsigned char*)(const_cast<char*>(op1) + op1Off)) || isNull(*(unsigned char*)(const_cast<char*>(op2) + op2Off)))
    {
        *(unsigned char*)(res + resOff) = false;
    }
    else
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1)  + op1Off) !=
                                          *(unsigned char*)(const_cast<char*>(op2)  + op2Off);
    }
}


//--------------------------------------------
//  OpGREATERChar
//--------------------------------------------

OpGREATERChar::OpGREATERChar(const BaseType* newResType,
                             const BaseType* newOp1Type,
                             const BaseType* newOp2Type,
                             unsigned int newResOff,
                             unsigned int newOp1Off,
                             unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpGREATERChar::operator()(char* res, const char* op1,
                          const char* op2)
{
    if (isNull(*(unsigned char*)(const_cast<char*>(op1)  + op1Off)) || isNull(*(unsigned char*)(const_cast<char*>(op2)  + op2Off)))
    {
        *(unsigned char*)(res + resOff) = false;
    }
    else
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1)  + op1Off) >
                                          *(unsigned char*)(const_cast<char*>(op2)  + op2Off);
    }
}



//--------------------------------------------
//  OpGREATEREQUALChar
//--------------------------------------------

OpGREATEREQUALChar::OpGREATEREQUALChar(const BaseType* newResType,
                                       const BaseType* newOp1Type,
                                       const BaseType* newOp2Type,
                                       unsigned int newResOff,
                                       unsigned int newOp1Off,
                                       unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff,
               newOp1Off, newOp2Off)
{
}

void
OpGREATEREQUALChar::operator()(char* res, const char* op1,
                               const char* op2)
{
    if (isNull(*(unsigned char*)(const_cast<char*>(op1)  + op1Off)) || isNull(*(unsigned char*)(const_cast<char*>(op2)  + op2Off)))
    {
        *(unsigned char*)(res + resOff) = false;
    }
    else
    {
        *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op1)  + op1Off) >=
                                          *(unsigned char*)(const_cast<char*>(op2)  + op2Off);
    }
}

//--------------------------------------------
//  OpIDENTITYChar
//--------------------------------------------

OpIDENTITYChar::OpIDENTITYChar(const BaseType* newResType, const BaseType* newOpType,
                               unsigned int newResOff,
                               unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
}

void
OpIDENTITYChar::operator()(char* res, const char* op)
{
    *(unsigned char*)(res + resOff) = *(unsigned char*)(const_cast<char*>(op) + opOff);
}

//--------------------------------------------
//
//--------------------------------------------

OpIDENTITYShort::OpIDENTITYShort(const BaseType* newResType, const BaseType* newOpType,
                                 unsigned int newResOff,
                                 unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
}

void
OpIDENTITYShort::operator()(char* res, const char* op)
{
    *(unsigned short*)(res + resOff) = *(unsigned short*)(const_cast<char*>(op) + opOff);
}

//--------------------------------------------
//  OpIDENTITYLong
//--------------------------------------------

OpIDENTITYLong::OpIDENTITYLong(const BaseType* newResType, const BaseType* newOpType,
                               unsigned int newResOff,
                               unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
}

void
OpIDENTITYLong::operator()(char* res, const char* op)
{
    *(r_ULong*)(res + resOff) = *(r_ULong*)(const_cast<char*>(op) + opOff);
}

//--------------------------------------------
//  MarrayOp
//--------------------------------------------

MarrayOp::MarrayOp(const BaseType* newResType, unsigned int newResOff)
    : resType(newResType), resOff(newResOff)
{
}

void
MarrayOp::operator()(char* result, const r_Point& p)
{
    r_ULong sum = 0;

    for (unsigned int i = 0; i < p.dimension(); i++)
    {
        sum += p[i];
    }

    resType->makeFromCULong(result, &sum);
}

//--------------------------------------------
//  GenCondenseOp
//--------------------------------------------

GenCondenseOp::GenCondenseOp(const BaseType* newResType, unsigned int newResOff,
                             BinaryOp* newAccuOp, char* newInitVal)
    : resType(newResType), resOff(newResOff), accuOp(newAccuOp), myInitVal(0)
{
    if (newInitVal == 0)
    {
        initVal = new char[resType->getSize()];
        myInitVal = 1;
        accuOp->getCondenseInit(initVal);
    }
    else
    {
        initVal = newInitVal;
    }
}

GenCondenseOp::~GenCondenseOp()
{
    if (myInitVal)
    {
        delete [] initVal;
    }
}


void
GenCondenseOp::operator()(const r_Point& p)
{
    r_ULong sum = 0;
    char buf[8];

    for (unsigned int i = 0; i < p.dimension(); i++)
    {
        sum += p[i];
    }

    resType->makeFromCULong(buf, &sum);

    (*accuOp)(initVal, initVal, buf);
}

BinaryOp*
GenCondenseOp::getAccuOp()
{
    return accuOp;
}

const BaseType*
GenCondenseOp::getResultType()
{
    return resType;
}

unsigned int
GenCondenseOp::getResultOff()
{
    return resOff;
}

char*
GenCondenseOp::getAccuVal()
{
    return initVal;
}


//--------------------------------------------
//  Complex
//--------------------------------------------

// *** PLUS ***

OpPLUSComplex::OpPLUSComplex(
    const BaseType* newResType,
    const BaseType* newOp1Type,
    const BaseType* newOp2Type,
    unsigned int newResOff,
    unsigned int newOp1Off,
    unsigned int newOp2Off,
    ScalarFlag flag)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff, newOp1Off, newOp2Off), scalarFlag(flag)
{
    op1ReOff = scalarFlag == OpPLUSComplex::FIRST  ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp1Type)))->getReOffset();
    op1ImOff = scalarFlag == OpPLUSComplex::FIRST  ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp1Type)))->getImOffset();
    op2ReOff = scalarFlag == OpPLUSComplex::SECOND ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp2Type)))->getReOffset();
    op2ImOff = scalarFlag == OpPLUSComplex::SECOND ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp2Type)))->getImOffset();

    resReOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getReOffset();
    resImOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getImOffset();
}

void OpPLUSComplex::operator()(char* res, const char* op1, const char* op2)
{
    double op1Re = 0;
    double op2Re = 0;
    double op1Im = 0;
    double op2Im = 0;
    double resRe, resIm;

    op1Re = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
    op2Re = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));

    if (isNull(op1Re))
    {
        resRe = op1Re;
    }
    else if (isNull(op2Re))
    {
        resRe = op2Re;
    }
    else
    {
        resRe = op1Re + op2Re;
    }

    if (scalarFlag == FIRST)
    {
        resIm = *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im));
    }
    else if (scalarFlag == SECOND)
    {
        resIm = *(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im));
    }
    else
    {
        op1Im = *(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im));
        op2Im = *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im));
        if (isNull(op1Im))
        {
            resIm = op1Im;
        }
        else if (isNull(op2Im))
        {
            resIm = op2Im;
        }
        else
        {
            resIm = op1Im + op2Im;
        }
    }

    resType->makeFromCDouble(res + resOff + resReOff, &resRe);
    resType->makeFromCDouble(res + resOff + resImOff, &resIm);
}

void OpPLUSComplex::getCondenseInit(char* init)
{
    double dummyRe = 0.0;
    double dummyIm = 0.0;
    resType->makeFromCDouble(init + resReOff, &dummyRe);
    resType->makeFromCDouble(init + resImOff, &dummyIm);
}


// *** MAX_BINARY ***

OpMAX_BINARYComplex::OpMAX_BINARYComplex(
    const BaseType* newResType,
    const BaseType* newOp1Type,
    const BaseType* newOp2Type,
    unsigned int newResOff,
    unsigned int newOp1Off,
    unsigned int newOp2Off,
    ScalarFlag flag)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff, newOp1Off, newOp2Off), scalarFlag(flag)
{
    op1ReOff = scalarFlag == OpMAX_BINARYComplex::FIRST  ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp1Type)))->getReOffset();
    op1ImOff = scalarFlag == OpMAX_BINARYComplex::FIRST  ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp1Type)))->getImOffset();
    op2ReOff = scalarFlag == OpMAX_BINARYComplex::SECOND ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp2Type)))->getReOffset();
    op2ImOff = scalarFlag == OpMAX_BINARYComplex::SECOND ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp2Type)))->getImOffset();

    resReOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getReOffset();
    resImOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getImOffset();
}

void OpMAX_BINARYComplex::operator()(char* res, const char* op1, const char* op2)
{
    double op1Re = 0;
    double op2Re = 0;
    double op1Im = 0;
    double op2Im = 0;
    double resRe, resIm;

    if (scalarFlag == FIRST)
    {
        if (*(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re)) > *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re)))
        {
            resRe = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
        }
        else
        {
            resRe = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));
        }

        resIm = *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im));
    }
    else if (scalarFlag == SECOND)
    {
        if (*(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re)) > *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re)))
        {
            resRe = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
        }
        else
        {
            resRe = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));
        }

        resIm = *(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im));
    }
    else
    {
        if (*(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re)) > *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re)))
        {
            resRe = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
        }
        else
        {
            resRe = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));
        }

        if (*(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im)) > *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im)))
        {
            resIm = *(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im));
        }
        else
        {
            resIm = *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im));
        }
    }

    resType->makeFromCDouble(res + resOff + resReOff, &resRe);
    resType->makeFromCDouble(res + resOff + resImOff, &resIm);
}

void OpMAX_BINARYComplex::getCondenseInit(char* init)
{
    double dummyRe = -DBL_MAX;
    double dummyIm = -DBL_MAX;
    resType->makeFromCDouble(init + resReOff, &dummyRe);
    resType->makeFromCDouble(init + resImOff, &dummyIm);
}



// *** MIN_BINARY ***

OpMIN_BINARYComplex::OpMIN_BINARYComplex(
    const BaseType* newResType,
    const BaseType* newOp1Type,
    const BaseType* newOp2Type,
    unsigned int newResOff,
    unsigned int newOp1Off,
    unsigned int newOp2Off,
    ScalarFlag flag)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff, newOp1Off, newOp2Off), scalarFlag(flag)
{
    op1ReOff = scalarFlag == OpMIN_BINARYComplex::FIRST  ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp1Type)))->getReOffset();
    op1ImOff = scalarFlag == OpMIN_BINARYComplex::FIRST  ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp1Type)))->getImOffset();
    op2ReOff = scalarFlag == OpMIN_BINARYComplex::SECOND ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp2Type)))->getReOffset();
    op2ImOff = scalarFlag == OpMIN_BINARYComplex::SECOND ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp2Type)))->getImOffset();

    resReOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getReOffset();
    resImOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getImOffset();
}

void OpMIN_BINARYComplex::operator()(char* res, const char* op1, const char* op2)
{
    double op1Re = 0;
    double op2Re = 0;
    double op1Im = 0;
    double op2Im = 0;
    double resRe, resIm;

    if (scalarFlag == FIRST)
    {
        if (*(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re)) < * (op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re)))
        {
            resRe = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
        }
        else
        {
            resRe = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));
        }

        resIm = *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im));
    }
    else if (scalarFlag == SECOND)
    {
        if (*(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re)) < * (op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re)))
        {
            resRe = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
        }
        else
        {
            resRe = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));
        }

        resIm = *(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im));
    }
    else
    {
        if (*(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re)) < * (op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re)))
        {
            resRe = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
        }
        else
        {
            resRe = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));
        }

        if (*(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im)) < * (op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im)))
        {
            resIm = *(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im));
        }
        else
        {
            resIm = *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im));
        }
    }

    resType->makeFromCDouble(res + resOff + resReOff, &resRe);
    resType->makeFromCDouble(res + resOff + resImOff, &resIm);
}

void OpMIN_BINARYComplex::getCondenseInit(char* init)
{
    double dummyRe = DBL_MAX;
    double dummyIm = DBL_MAX;
    resType->makeFromCDouble(init + resReOff, &dummyRe);
    resType->makeFromCDouble(init + resImOff, &dummyIm);
}

// *** MINUS ***


OpMINUSComplex::OpMINUSComplex(
    const BaseType* newResType,
    const BaseType* newOp1Type,
    const BaseType* newOp2Type,
    unsigned int newResOff,
    unsigned int newOp1Off,
    unsigned int newOp2Off,
    ScalarFlag flag)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff, newOp1Off, newOp2Off), scalarFlag(flag)
{
    op1ReOff = scalarFlag == OpMINUSComplex::FIRST  ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp1Type)))->getReOffset();
    op1ImOff = scalarFlag == OpMINUSComplex::FIRST  ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp1Type)))->getImOffset();
    op2ReOff = scalarFlag == OpMINUSComplex::SECOND ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp2Type)))->getReOffset();
    op2ImOff = scalarFlag == OpMINUSComplex::SECOND ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp2Type)))->getImOffset();

    resReOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getReOffset();
    resImOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getImOffset();
}

void OpMINUSComplex::operator()(char* res, const char* op1, const char* op2)
{
    double op1Re = 0;
    double op2Re = 0;
    double op1Im = 0;
    double op2Im = 0;
    double resRe, resIm;

    op1Re = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
    op2Re = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));

    if (isNull(op1Re))
    {
        resRe = op1Re;
    }
    else if (isNull(op2Re))
    {
        resRe = op2Re;
    }
    else
    {
        resRe = op1Re - op2Re;
    }

    if (scalarFlag == FIRST)
    {
        resIm = *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im));
    }
    else if (scalarFlag == SECOND)
    {
        resIm = *(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im));
    }
    else
    {
        op1Im = *(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im));
        op2Im = *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im));
        if (isNull(op1Im))
        {
            resIm = op1Im;
        }
        else if (isNull(op2Im))
        {
            resIm = op2Im;
        }
        else
        {
            resIm = op1Im - op2Im;
        }
    }

    resType->makeFromCDouble(res + resOff + resReOff, &resRe);
    resType->makeFromCDouble(res + resOff + resImOff, &resIm);
}

// *** DIV ***

OpDIVComplex::OpDIVComplex(
    const BaseType* newResType,
    const BaseType* newOp1Type,
    const BaseType* newOp2Type,
    unsigned int newResOff,
    unsigned int newOp1Off,
    unsigned int newOp2Off,
    ScalarFlag flag)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff, newOp1Off, newOp2Off), scalarFlag(flag)
{
    op1ReOff = scalarFlag == OpDIVComplex::FIRST  ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp1Type)))->getReOffset();
    op1ImOff = scalarFlag == OpDIVComplex::FIRST  ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp1Type)))->getImOffset();
    op2ReOff = scalarFlag == OpDIVComplex::SECOND ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp2Type)))->getReOffset();
    op2ImOff = scalarFlag == OpDIVComplex::SECOND ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp2Type)))->getImOffset();

    resReOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getReOffset();
    resImOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getImOffset();
}

void OpDIVComplex::operator()(char* res, const char* op1, const char* op2)
{
    double op1Re = 0;
    double op2Re = 0;
    double op1Im = 0;
    double op2Im = 0;
    double resRe, resIm;

    if (scalarFlag == FIRST)
    {
        double x1 = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
        double x2 = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));
        double y2 = *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im));

        if (isNull(x1))
        {
            resRe = x1;
            resIm = 0;
        }
        else if (isNull(x2) || isNull(y2))
        {
            resRe = x2;
            resIm = y2;
        }
        else
        {
            // Do not handle division by zero, return +-nan or inf as specified in IEEE 754
            resRe = x1 * x2 / (x2 * x2 + y2 * y2);
            resIm = - x1 * y2 / (x2 * x2 + y2 * y2);
        }

    }
    else if (scalarFlag == SECOND)
    {
        double x1 = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
        double y1 = *(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im));
        double x2 = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));

        if (isNull(x1) || isNull(y1))
        {
            resRe = x1;
            resIm = y1;
        }
        else if (isNull(x2))
        {
            resRe = x2;
            resIm = 0;
        }
        else
        {
            // Do not handle division by zero, return +-nan or inf as specified in IEEE 754
            resRe = x1 / x2;
            resIm = y1 / x2;
        }

    }
    else   // NONE
    {
        double x1 = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
        double y1 = *(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im));
        double x2 = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));
        double y2 = *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im));

        if (isNull(x1) || isNull(y1))
        {
            resRe = x1;
            resIm = y1;
        }
        else if (isNull(x2) || isNull(y2))
        {
            resRe = x2;
            resIm = y2;
        }
        else
        {
            // Do not handle division by zero, return +-nan or inf as specified in IEEE 754
            resRe = (x1 * x2 + y1 * y2) / (x2 * x2 + y2 * y2);
            resIm = (y1 * x2 - x1 * y2) / (x2 * x2 + y2 * y2);
        }

    }

    resType->makeFromCDouble(res + resOff + resReOff, &resRe);
    resType->makeFromCDouble(res + resOff + resImOff, &resIm);
}

// *** MULT ***

OpMULTComplex::OpMULTComplex(
    const BaseType* newResType,
    const BaseType* newOp1Type,
    const BaseType* newOp2Type,
    unsigned int newResOff,
    unsigned int newOp1Off,
    unsigned int newOp2Off,
    ScalarFlag flag)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff, newOp1Off, newOp2Off), scalarFlag(flag)
{
    op1ReOff = scalarFlag == OpMULTComplex::FIRST  ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp1Type)))->getReOffset();
    op1ImOff = scalarFlag == OpMULTComplex::FIRST  ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp1Type)))->getImOffset();
    op2ReOff = scalarFlag == OpMULTComplex::SECOND ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp2Type)))->getReOffset();
    op2ImOff = scalarFlag == OpMULTComplex::SECOND ? 0 : (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOp2Type)))->getImOffset();

    resReOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getReOffset();
    resImOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getImOffset();
}

void OpMULTComplex::operator()(char* res, const char* op1, const char* op2)
{
    double op1Re = 0;
    double op2Re = 0;
    double op1Im = 0;
    double op2Im = 0;
    double resRe, resIm;


    if (scalarFlag == FIRST)
    {
        double x1 = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
        double x2 = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));
        double y2 = *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im));

        if (isNull(x1))
        {
            resRe = x1;
            resIm = 0;
        }
        else if (isNull(x2) || isNull(y2))
        {
            resRe = x2;
            resIm = y2;
        }
        else
        {
            resRe = x1 * x2;
            resIm = x1 * y2;
        }

    }
    else if (scalarFlag == SECOND)
    {
        double x1 = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
        double y1 = *(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im));
        double x2 = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));

        if (isNull(x1) || isNull(y1))
        {
            resRe = x1;
            resIm = y1;
        }
        else if (isNull(x2))
        {
            resRe = x2;
            resIm = 0;
        }
        else
        {
            resRe = x1 * x2;
            resIm = y1 * x2;
        }

    }
    else   // NONE
    {
        double x1 = *(op1Type->convertToCDouble(op1 + op1Off + op1ReOff, &op1Re));
        double y1 = *(op1Type->convertToCDouble(op1 + op1Off + op1ImOff, &op1Im));
        double x2 = *(op2Type->convertToCDouble(op2 + op2Off + op2ReOff, &op2Re));
        double y2 = *(op2Type->convertToCDouble(op2 + op2Off + op2ImOff, &op2Im));

        if (isNull(x1) || isNull(y1))
        {
            resRe = x1;
            resIm = y1;
        }
        else if (isNull(x2) || isNull(y2))
        {
            resRe = x2;
            resIm = y2;
        }
        else
        {
            resRe = x1 * x2 - y1 * y2;
            resIm = x1 * y2 + x2 * y1;
        }

    }

    resType->makeFromCDouble(res + resOff + resReOff, &resRe);
    resType->makeFromCDouble(res + resOff + resImOff, &resIm);
}

void OpMULTComplex::getCondenseInit(char* init)
{
    double dummyRe = 1.0;
    double dummyIm = 0.0;
    resType->makeFromCDouble(init + resReOff, &dummyRe);
    resType->makeFromCDouble(init + resImOff, &dummyIm);
}

// *** IDENTITY ***

OpIDENTITYComplex::OpIDENTITYComplex(
    const BaseType* newResType,
    const BaseType* newOpType,
    unsigned int newResOff,
    unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{}

void OpIDENTITYComplex::operator()(char* res, const char* op)
{
    memcpy((void*)(res + resOff), (void*)(const_cast<char*>(op) + opOff), resType->getSize());
}

// *** MAX ***

OpMAXComplex::OpMAXComplex(const BaseType* newResType, const BaseType* newOpType,
                           unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
    , maxBinary(newResType, newOpType, newResType, newResOff, newOpOff, newResOff, OpMAX_BINARYComplex::NONE)
{
    const GenericComplexType* type = (const GenericComplexType*) resType;
    unsigned int reOff = type->getReOffset();
    unsigned int imOff = type->getImOffset();

    double myVal = -DBL_MAX;
    accu = new char[resType->getSize()];
    memset(accu, 0, resType->getSize());
    resType->makeFromCDouble(accu + reOff, &myVal);
    resType->makeFromCDouble(accu + imOff, &myVal);
}

OpMAXComplex::OpMAXComplex(const BaseType* newResType, char* newAccu,
                           const BaseType* newOpType, unsigned int newResOff,
                           unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
    , maxBinary(newResType, newOpType, newResType, newResOff, newOpOff, newResOff, OpMAX_BINARYComplex::NONE)
{
}

char*
OpMAXComplex::operator()(const char* op, char* init)
{
    maxBinary(init, op, init);
    return init;
}

char*
OpMAXComplex::operator()(const char* op)
{
    return OpMAXComplex::operator()(op, accu);
}

// *** MIN ***

OpMINComplex::OpMINComplex(const BaseType* newResType, const BaseType* newOpType,
                           unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
    , minBinary(newResType, newOpType, newResType, newResOff, newOpOff, newResOff, OpMIN_BINARYComplex::NONE)
{
    const GenericComplexType* type = (const GenericComplexType*) resType;
    unsigned int reOff = type->getReOffset();
    unsigned int imOff = type->getImOffset();

    double myVal = DBL_MAX;
    accu = new char[resType->getSize()];
    memset(accu, 0, resType->getSize());
    resType->makeFromCDouble(accu + reOff, &myVal);
    resType->makeFromCDouble(accu + imOff, &myVal);
}

OpMINComplex::OpMINComplex(const BaseType* newResType, char* newAccu,
                           const BaseType* newOpType, unsigned int newResOff,
                           unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
    , minBinary(newResType, newOpType, newResType, newResOff, newOpOff, newResOff, OpMIN_BINARYComplex::NONE)
{
}

char*
OpMINComplex::operator()(const char* op, char* init)
{
    minBinary(init, op, init);
    return init;
}

char*
OpMINComplex::operator()(const char* op)
{
    return OpMINComplex::operator()(op, accu);
}

// *** SUM ***

OpSUMComplex::OpSUMComplex(const BaseType* newResType, const BaseType* newOpType,
                           unsigned int newResOff, unsigned int newOpOff)
    : CondenseOp(newResType, newOpType, newResOff, newOpOff)
    , plusBinary(newResType, newOpType, newResType, newResOff, newOpOff, newResOff, OpPLUSComplex::NONE)
{
    const GenericComplexType* type = (const GenericComplexType*) resType;
    unsigned int resReOff = type->getReOffset();
    unsigned int resImOff = type->getImOffset();

    double myVal = 0.0;
    // initialising with neutral value
    accu = new char[resType->getSize()];
    resType->makeFromCDouble(accu + resReOff, &myVal);
    resType->makeFromCDouble(accu + resImOff, &myVal);
}

OpSUMComplex::OpSUMComplex(const BaseType* newResType, char* newAccu,
                           const BaseType* newOpType, unsigned int newResOff,
                           unsigned int newOpOff)
    : CondenseOp(newResType, newAccu, newOpType, newResOff, newOpOff)
    , plusBinary(newResType, newOpType, newResType, newResOff, newOpOff, newResOff, OpPLUSComplex::NONE)
{
}

char*
OpSUMComplex::operator()(const char* op, char* init)
{
    plusBinary(init, op, init);
    return init;
}

char*
OpSUMComplex::operator()(const char* op)
{
    return OpSUMComplex::operator()(op, accu);
}

// *** CONSTRUCTING COMPLEX ***

OpConstructComplex::OpConstructComplex(const BaseType* newResType, const BaseType* newOp1Type,
                                       const BaseType* newOp2Type, unsigned int newResOff, unsigned int newOp1Off,
                                       unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff, newOp1Off, newOp2Off)
{
    resReOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getReOffset();
    resImOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newResType)))->getImOffset();
}

void
OpConstructComplex::operator()(char* res, const char* op1, const char* op2)
{
    double resRe = *(op1Type->convertToCDouble(op1 + op1Off, &resRe));
    double resIm = *(op2Type->convertToCDouble(op2 + op2Off, &resIm));

    resType->makeFromCDouble(res + resOff + resReOff, &resRe);
    resType->makeFromCDouble(res + resOff + resImOff, &resIm);
}
// *** REAL PART ***

OpRealPart::OpRealPart(
    const BaseType* newResType,
    const BaseType* newOpType,
    unsigned int newResOff,
    unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
    opReOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOpType)))->getReOffset();
}


void OpRealPart::operator()(char* res, const char* op)
{
    double result;

    opType->convertToCDouble(op + opOff + opReOff, &result);
    resType->makeFromCDouble(res + resOff, &result);
}

// *** IMAGINAR PART ***

OpImaginarPart::OpImaginarPart(
    const BaseType* newResType,
    const BaseType* newOpType,
    unsigned int newResOff,
    unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff)
{
    opImOff = (static_cast<GenericComplexType*>(const_cast<BaseType*>(newOpType)))->getImOffset();
}


void OpImaginarPart::operator()(char* res, const char* op)
{
    double result;

    opType->convertToCDouble(op + opOff + opImOff, &result);
    resType->makeFromCDouble(res + resOff, &result);
}


//--------------------------------------------
//  OpCAST
//--------------------------------------------

OpCAST::OpCAST(
    const BaseType* newResType,
    const BaseType* newOpType,
    unsigned int newResOff,
    unsigned int newOpOff)
    : UnaryOp(newResType, newOpType, newResOff, newOpOff) {}

void OpCAST::operator()(char* res, const char* op)
{

    if (resType->getType() == FLOAT || resType->getType() == DOUBLE)
    {
        // floating point types
        double dblOp = *(opType->convertToCDouble(op + opOff, &dblOp));
        if (isNull(dblOp))
        {
            dblOp = NAN;
        }
        resType->makeFromCDouble(res + resOff, &dblOp);
    }
    else
    {
        // all integral types
        r_Long lngOp = *(opType->convertToCLong(op + opOff, &lngOp));
        if (isNull(lngOp))
        {
            lngOp = 0;
        }
        resType->makeFromCLong(res + resOff, &lngOp);
    }
}


//--------------------------------------------
//  OpOVERLAY
//--------------------------------------------

OpOVERLAY::OpOVERLAY(const BaseType* newResType, const BaseType* newOp1Type, const BaseType* newOp2Type, size_t typeSize, const char* transparentPattern, unsigned int newResOff, unsigned int newOp1Off, unsigned int newOp2Off)
    : BinaryOp(newResType, newOp1Type, newOp2Type, newResOff, newOp1Off, newOp2Off), length(typeSize), pattern(transparentPattern)
{
    if ((pattern == nullPattern) && (length > 16))
    {
        LFATAL << "OpOVERLAY overlay with types larger than 16 bytes not supported yet";
        throw r_Error(OVERLAYPATTERNTOOSMALL);
    }
}

void OpOVERLAY::operator()(char* res, const char* op1, const char* op2)
{
    if ((memcmp(pattern, op1 + op1Off, length) == 0) || isNull(*(op1 + op1Off)))
    {
        //match
        memcpy(res + resOff, op2 + op2Off, length);
    }
    else     //no match
    {
        memcpy(res + resOff, op1 + op1Off, length);
    }
}

const char*
OpOVERLAY::nullPattern = "\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0";

//--------------------------------------------
//  OpBIT
//--------------------------------------------

OpBIT::OpBIT(
    const BaseType* newResType,
    const BaseType* newOp1Type,
    const BaseType* newOp2Type,
    unsigned int newResOff,
    unsigned int newOp1Off,
    unsigned int newOp2Off)

    : BinaryOp(newResType,
               newOp1Type, newOp2Type,
               newResOff, newOp1Off,
               newOp2Off)
{}


void OpBIT::operator()(char* res, const char* op1, const char* op2)
{
    r_ULong lngOp1, lngOp2, lngRes;

    op1Type->convertToCULong(op1 + op1Off, &lngOp1);
    op2Type->convertToCULong(op2 + op2Off, &lngOp2);
    if (isNull(lngOp1))
    {
        lngRes = lngOp1;
    }
    else
    {
        lngRes = lngOp1 >> lngOp2 & 0x1L;
    }
    resType->makeFromCULong(res + resOff, &lngRes);
}




#include "autogen_ops.cc"
