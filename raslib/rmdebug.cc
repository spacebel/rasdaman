/*
 * This file is part of rasdaman community.
 *
 * Rasdaman community is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Rasdaman community is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with rasdaman community.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2003 - 2010 Peter Baumann / rasdaman GmbH.
 *
 * For more information please see <http://www.rasdaman.org>
 * or contact Peter Baumann via <baumann@rasdaman.com>.
*/

/**
 * SOURCE: rmdebug.cc
 *
 * MODULE: raslib
 * CLASS:
 *
 * COMMENTS:
 *
*/


#include "raslib/rmdebug.hh"
#include "raslib/odmgtypes.hh"
#include <logging.hh>

#include <iostream>
#include <stdio.h>     // fopen, getc
#include <string.h>
#include <ctype.h>
#include <stdlib.h>
#include <fstream>

using namespace std;

int RManDebug     = 0;     // debug level (0-4), 0 means no debug info at all
int RManBenchmark = 0;     // benchmark level (0-4)

// initialization of static variables for RMDebug
int    RMDebug::level = 0;
int    RMDebug::numDebugModules = 0;
char **RMDebug::debugModules = 0;
char  *RMDebug::debugModulesText = 0;
int   *RMDebug::transDebugModules = 0;
int    RMDebug::numDebugClasses = 0;
char **RMDebug::debugClasses = 0;
char  *RMDebug::debugClassesText = 0;

// all module names
const char *RMDebug::allModuleNames[] =
{
    "adminif",
    "applications",
    "blobif",
    "cachetamgr",
    "catalogif",
    "catalogmgr",
    "clientcomm",
    "conversion",
    "compression",
    "indexif",
    "indexmgr",
    "insertutils",
    "mddif",
    "mddmgr",
    "qlparser",
    "rasdl",
    "raslib",
    "rasodmg",
    "rasql",
    "server",
    "servercomm",
    "storageif",
    "storagemgr",
    "tools",
    "tilemgr",
    "utilities"
};

int RMDebug::allModuleLevels[RMDebug::module_number];


// initialization of static variable for RMTimer
#ifndef __VISUALC__
struct timezone RMTimer::dummy;
#endif

RMDebug::RMDebug(const char *newClass, const char *newFunc, const char *newModule,
                 const char *newFile, int newLine)
    : myClass(newClass), myFunc(newFunc), myModule(newModule),
      myFile(newFile), myLine(newLine), myModuleNum(-1), myDebugLevel(2)
{
    myDebugOn = checkDebug();

    int useLevel = -1;
    if (myModuleNum >= 0)
    {
        useLevel = allModuleLevels[myModuleNum];
    }

    if (useLevel < 0)
    {
        useLevel = RManDebug;
    }

    myDebugOn = myDebugOn && (useLevel >= myDebugLevel);

    if (myDebugOn)
    {
        indentLine();
        // output, when entering function
        LTRACE << "D: " << myClass << "::" << myFunc << " entered "
               << "(" << myModule << ", " << myFile << ": " << myLine
               << ").";
        // indentation
        level++;
    }
}

RMDebug::RMDebug(int newLevel, const char *newClass, const char *newFunc, int newModuleNum,
                 const char *newFile, int newLine)
    : myClass(newClass), myFunc(newFunc), myModule(NULL), myFile(newFile),
      myLine(newLine), myModuleNum(newModuleNum), myDebugLevel(newLevel)
{
    myDebugOn = checkDebug() && (allModuleLevels[newModuleNum] >= myDebugLevel);

    if (myDebugOn)
    {
        indentLine();
        // output when entering function
        LTRACE << "D: " << myClass << "::" << myFunc << " entered "
               << "(" << allModuleNames[myModuleNum] << ", " << myFile << ": "
               << myLine << ").";
        // indentation
        level++;
    }
}

RMDebug::~RMDebug(void)
{
    if (myDebugOn)
    {
        // indentation
        level--;
        indentLine();
        // output, when exiting function
        LTRACE << "D: " << myClass << "::" << myFunc
               << " exited.";
    }
}

char *
RMDebug::loadTextFile(const char *name)
{

    std::ifstream f;
    f.open(name);
    if (f.is_open())
    {
        char *result;
        f.seekg(0, std::ios::end);
        std::streampos end = f.tellg();
        size_t resLen = static_cast<size_t>(end) + 1;
        result = new char[resLen];
        memset(result, 0, resLen);
        f.seekg(0, std::ios::beg);
        f.read(result, end);
        f.close();
        result[resLen] = '\0';
        return result;
    }
    return NULL;
}

int
RMDebug::initRMDebug(void)
{
    int errmod = 0;
    int errclass = 0;
    int j;
    const char *enVar;
    char *myPtr;

    // init all debug levels to global debug level
    for (j = 0; j < module_number; j++)
    {
        allModuleLevels[j] = RManDebug;
    }

    // -------------------
    // reading rmdbmodules
    // -------------------

    // environment variable overrides text file
    if ((enVar = getenv("RMDBGMODULES")) != NULL)
    {
        debugModulesText = new char[strlen(enVar) + 1];
        strcpy(debugModulesText, enVar);
    }
    else
    {
        if ((debugModulesText = loadTextFile("rmdbmodules")) == NULL)
        {
            errmod = -1;
        }
    }

    if (debugModulesText != NULL)
    {
        // first switch off debugging info for all modules
        for (j = 0; j < module_number; j++)
        {
            allModuleLevels[j] = 0;
        }

        // count number of lines (whitespace separates)
        myPtr = debugModulesText;
        while (*myPtr != '\0')
        {
            while (isspace(static_cast<unsigned int>(*myPtr)))
            {
                myPtr++;
            }
            if (*myPtr != '\0')
            {
                numDebugModules++;
                while ((*myPtr != '\0') && !isspace(static_cast<unsigned int>(*myPtr)))
                {
                    myPtr++;
                }
            }
        }
        debugModules = new char *[numDebugModules];
        transDebugModules = new int[numDebugModules];
        // read text
        j = 0;
        myPtr = debugModulesText;
        while (*myPtr != '\0')
        {
            int modLevel = RManDebug; // default debug level
            transDebugModules[j] = -1;
            while (isspace(static_cast<unsigned int>(*myPtr)))
            {
                myPtr++;
            }
            if (*myPtr != '\0')
            {
                debugModules[j] = myPtr;
                while ((*myPtr != '\0') && !isspace(static_cast<unsigned int>(*myPtr)))
                {
                    if (*myPtr == ',')
                    {
                        char *rest;
                        *myPtr++ = '\0';
                        modLevel = strtol(myPtr, &rest, 10);
                        if (rest == myPtr)
                        {
                            cerr << "RMDebug::initRMDebug: Parse error in item " << j << endl;
                        }
                        myPtr = rest;
                    }
                    else
                    {
                        myPtr++;
                    }
                }
            }
            if (*myPtr != '\0')
            {
                *myPtr++ = '\0';
            }
            for (int i = 0; i < module_number; i++)
            {
                if (debugModules[j] == NULL)
                {
                    LWARNING << "RMDebug::initRMDebug: debugModules[" << j << "] is NULL, skipping this.";
                }
                else if (allModuleNames[i] == NULL)
                {
                    LWARNING << "RMDebug::initRMDebug: allModuleNames[" << i << "] is NULL, skipping this.";
                }
                else if (strcmp(debugModules[j], allModuleNames[i]) == 0)
                {
                    transDebugModules[j] = i;
                    break;
                }
            }
            if (transDebugModules[j] >= 0)
            {
                allModuleLevels[transDebugModules[j]] = modLevel;
            }
            j++;
        }
        for (j = 0; j < module_number; j++)
        {
            LTRACE << allModuleNames[j] << " : " << allModuleLevels[j];
        }
    }

    // -------------------
    // reading rmdbclasses
    // -------------------

    if ((enVar = getenv("RMDBGCLASSES")) != NULL)
    {
        debugClassesText = new char[strlen(enVar) + 1];
        strcpy(debugClassesText, enVar);
    }
    else
    {
        if ((debugClassesText = loadTextFile("rmdbclasses")) == NULL)
        {
            errclass = -1;
        }
    }

    if (debugClassesText != NULL)
    {
        myPtr = debugClassesText;
        while (*myPtr != '\0')
        {
            while (isspace(static_cast<unsigned int>(*myPtr)))
            {
                myPtr++;
            }
            if (*myPtr != '\0')
            {
                numDebugClasses++;
                while ((*myPtr != '\0') && !isspace(static_cast<unsigned int>(*myPtr)))
                {
                    myPtr++;
                }
            }
        }
        debugClasses = new char *[numDebugClasses];
        // read text
        j = 0;
        myPtr = debugClassesText;
        while (*myPtr != '\0')
        {
            while (isspace(static_cast<unsigned int>(*myPtr)))
            {
                myPtr++;
            }
            if (*myPtr != '\0')
            {
                debugClasses[j++] = myPtr;
                while ((*myPtr != '\0') && !isspace(static_cast<unsigned int>(*myPtr)))
                {
                    myPtr++;
                }
                if (*myPtr != '\0')
                {
                    *myPtr++ = '\0';
                }
            }
        }
    }
    for (j = 0; j < numDebugClasses; j++)
    {
        LTRACE << debugClasses[j];
    }

    if (errmod == -1 && errclass == -1)
    {
        return -1;
    }
    else
    {
        return 0;
    }
}

int
RMDebug::checkDebug(void)
{
    int i;

    if (numDebugModules == 0 && numDebugClasses == 0)
        // all classes should be debugged
    {
        return 1;
    }
    else
    {
        if (numDebugModules > 0)
        {
            if (myModuleNum >= 0)
            {
                if (allModuleLevels[myModuleNum] == 0)
                {
                    return 0;
                }
            }
            else
            {
                // check if module is mentioned
                for (i = 0; i < numDebugModules; i++)
                {
                    if (strcmp(debugModules[i], myModule) == 0)
                    {
                        myModuleNum = transDebugModules[i];
                        break;
                    }
                }
                if (i >= numDebugModules)
                {
                    return 0;
                }
            }
        }
        if ((numDebugClasses > 0) && (myClass != NULL))
        {
            // check if class is mentioned
            for (i = 0; i < numDebugClasses; i++)
                if (strcmp(debugClasses[i], myClass) == 0)
                {
                    break;
                }
            if (i >= numDebugClasses)
            {
                return 0;
            }
        }
    }
    return 1;
}

int
RMDebug::debugOutput(int dbgLevel, int modNum, const char *className)
{
    int retval = 0;
    if ((numDebugModules == 0) && (numDebugClasses == 0))
    {
        retval = (RManDebug >= dbgLevel);
    }
    else
    {
        if (numDebugModules > 0)
        {
            retval = (allModuleLevels[modNum] >= dbgLevel);
        }
        else
        {
            if ((numDebugClasses > 0) && (className != NULL))
            {
                int i;
                for (i = 0; i < numDebugClasses; i++)
                {
                    if (strcmp(debugClasses[i], className) == 0)
                    {
                        break;
                    }
                }
                if (i >= numDebugClasses)
                {
                    retval = 0;
                }
                else
                {
                    retval = 1;
                }
            }
            else
            {
                //nothing to do
            }
        }
    }
    return retval;
}

RMCounter::RMCounter(int levell, int module, const char *cls)
    :   doStuff(false)
{
    if (RMDebug::debugOutput(levell, module, cls))
    {
        //LTRACE << "RMCounter() " << RMDebug::level << " ";
        doStuff = true;
        RMDebug::level++;
        //LTRACE << RMDebug::level;
    }
}

RMCounter::~RMCounter()
{
    if (doStuff == true)
    {
        //LTRACE << "~RMCounter() " << RMDebug::level << " ";
        RMDebug::level--;
        //LTRACE << RMDebug::level;
    }
}

inline
RMTimer::RMTimer(const char *newClass, const char *newFunc, int newBmLevel)
    : myClass(newClass), myFunc(newFunc), bmLevel(newBmLevel), running(0)
{
    start();
}

inline
RMTimer::~RMTimer()
{
    stop();
}

void
RMTimer::setOutput(int newOutput)
{
    output = newOutput;
}

void
RMTimer::start()
{
    // reset accu
    accuTime = 0;
    // set output to TRUE
    output = 1;
    resume();
}

void
RMTimer::pause()
{
    if (running)
    {
        fetchTime();
        // timer is not running
        running = 0;
    }
}

void
RMTimer::resume()
{
    gettimeofday(&acttime, &dummy);
    // timer is running
    running = 1;
}

void
RMTimer::stop()
{
    pause();

    if (output && RManBenchmark >= bmLevel)
    {
        LDEBUG
                << std::endl
                << "PerformanceTimer: " << myClass << " :: " << myFunc << " = "
                << accuTime << " usecs";
        // set output to FALSE
        output = 0;
    }
}

int
RMTimer::getTime()
{
    fetchTime();
    return static_cast<int>(accuTime);
}

void
RMTimer::fetchTime()
{
    // save start time
    oldsec  = acttime.tv_sec;
    oldusec = acttime.tv_usec;

    // get stop time
    gettimeofday(&acttime, &dummy);

    // add new time to accu
    accuTime += (acttime.tv_sec - oldsec) * 1000000 + acttime.tv_usec - oldusec;
}

