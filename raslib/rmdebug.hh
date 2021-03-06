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
 * INCLUDE: rmdebug.hh
 *
 * PURPOSE:
 *      Contains debug stuff.
 *
 * COMMENTS:
 *
*/

#ifndef RMDEBUG_HH
#define RMDEBUG_HH

#include "raslib/rminit.hh"
#include "raslib/rm.hh"
#include <logging.hh>
#include <sys/time.h>

extern int RManDebug;
extern int RManBenchmark;

#ifdef RMANDEBUG

#define RMDBGIF( levell, module, cls, text ) \
    if (RMDebug::debugOutput( levell, module, cls )) { text }

#define RMDBGENTER( levell, module, cls, text ) \
    RMCounter rmCounter(levell, module, cls); \
    if (RMDebug::debugOutput( levell, module, cls )) { \
        LTRACE << "ENTER  ";  LTRACE << cls << " "; RMDebug::indentLine(); LTRACE << text; \
    }

#define RMDBGMIDDLE( levell, module, cls, text ) \
    if (RMDebug::debugOutput( levell, module, cls )) { \
        LTRACE << "MIDDLE "; LTRACE << cls << " "; RMDebug::indentLine(); LTRACE << text; \
    }

#define RMDBGONCE( levell, module, cls, text ) \
    RMCounter rmCounter(levell, module, cls); \
    if (RMDebug::debugOutput(levell, module, cls)) \
    { \
        LTRACE << "ONCE   "; LTRACE << cls << " "; \
        RMDebug::indentLine(); \
        LTRACE << text; \
    }

#define RMDBGEXIT( levell, module, cls, text ) \
    if (RMDebug::debugOutput( levell, module, cls )) { \
        LTRACE << "EXIT   "; LTRACE << cls << " "; RMDebug::indentLine(); LTRACE << text; \
    }

#define RMDBCLASS( t1, t2, t3, t4, t5 ) RMDebug localRMDebug = RMDebug( t1, t2, t3, t4, t5 );

#else

// Note: some parts of the code rely on these to be terminated by a ';'!
#define RMDBGENTER( level, module, cls, text ) ;
#define RMDBGMIDDLE( level, module, cls, text ) ;
#define RMDBGONCE( level, module, cls, text ) ;
#define RMDBGEXIT( level, module, cls, text ) ;
#define RMDBGIF( level, module, cls, text) ;

#define RMDBCLASS( t1, t2, t3, t4, t5 ) ;
#endif

// generate benchmark code only when RMANBENCHMARK is set
#ifdef RMANBENCHMARK
#define RMTIMER(class, func)  RMTimer localRMTimer = RMTimer(class, func);
#else
#define RMTIMER(class, func)
#endif

//@ManMemo: Module: <b>raslib</b>.

/*@Doc:
RMDebug is not strictly part of RasLib. It is a class used for
generating debug output if compiling with RMANDEBUG defined. One way
of using it is to put the following at the beginning of a function:

<tt>RMDebug localRMDebug = RMDebug("className", "functionName",
"moduleName", __FILE__, __LINE__");</tt>

This can be patched in automatically by a modified funchead.pl script.

<b>Functionality</b>

Debug output printing class name, function name, module name, file
name and line number given as parameters to the constructor is
created, whenever the constructor is called. The destructor
outputs class name and function name. If the static members <tt>debugModules</tt> 
or <tt>debugClasses</tt> are set, then only modules
which are mentioned in the array of strings <tt>debugModules</tt> or
classes which are mentioned <tt>debugClasses</tt> give debug output.
<tt>debugModules</tt> and <tt>debugClasses</tt> can either be read from
files named "rmdbmodules" and "rmdbclasses" or from the environment
variables RMDBGMODULES and RMDBGCLASSES. The environment variables
override the files. The contents of the files / variables are the
names of the modules / classes separated by whitespace (space,
newlines, ...). In the case of the modules each modulename may
be followed by ",<dbgLevel>" to set the debug level for that
module explizitly, otherwise the default is used.

<b>Interdependencies</b>

If only certain modules or classes are to be debugged, RMDebug
has to be initialized in {\Ref RMInit}. This is done by reading
the files <tt>rmdbmodules</tt> and <tt>rmdbclasses</tt>. The files
should contain names of modules resp. classes to be debugged, each
(including the last one!) followed by end of line. */

/**
  * \defgroup RMs RM Classes
  */

/**
  * \ingroup RMs
  */

class RMDebug : public RM_Class
{
public:
    /// constructor, initializes members and prints message.
    RMDebug(const char *newClass, const char *newFunc, const char *newModule,
            const char *newFile, int newLine);
    /// constructor taking an identifier to the module for more efficiency
    RMDebug(int newLevel, const char *newClass, const char *newFun, int newModuleNum,
            const char *newFile, int newLine);
    /// destructor, prints message.
    ~RMDebug(void);

    /// for initializing modules and classes to debug.
    static int initRMDebug(void);

    /// get the debug level of a module by its number
    static int getModuleDebugLevel(int modNum)
    {
        return allModuleLevels[modNum];
    }
    /// get the name of a module by its number
    static const char *getModuleName(int modNum)
    {
        return allModuleNames[modNum];
    }
    /// indent by the amount specified by level
    static void indentLine(void)
    {
        for (int i = 0; i < level; i++)
        {
            LTRACE << "  ";
        }
    }

    /// return whether debug output should happen for the given module, class
    /// and debugging level
    static int debugOutput(int dbgLevel, int modNum, const char *className);

    /// all modules for debugging
    enum
    {
        module_adminif = 0,
        module_applications,
        module_blobif,
        module_filetile,
        module_cachetamgr,
        module_catalogif,
        module_catalogmgr,
        module_clientcomm,
        module_conversion,
        module_compression,
        module_indexif,
        module_indexmgr,
        module_insertutils,
        module_mddif,
        module_mddmgr,
        module_qlparser,
        module_rasdl,
        module_raslib,
        module_rasodmg,
        module_rasql,
        module_server,
        module_servercomm,
        module_storageif,
        module_storagemgr,
        module_tilemgr,
        module_tools,
        module_utilities,
        module_number
    } RMDebugModules;
    /*@ManMemo level of function calls (incremented by constructor,
               decremented by destrctor. */
    static int level;

private:
    /// checks, if messages should be printed.
    int checkDebug(void);
    /// loads a file containing text and returns a 0-terminated string
    static char *loadTextFile(const char *name);
    /*@Doc:
       If <tt>debugModules</tt> or <tt>debugClasses</tt> is set, checks
       if myModule or myClass is in the corresponding array.
    */

    /// name of class.
    const char *myClass;
    /// name of function (no parameters).
    const char *myFunc;
    /// name of module.
    const char *myModule;
    /// name of source file.
    const char *myFile;
    /// line of code where destructor call is.
    int myLine;
    /// number of module
    int myModuleNum;
    /// debugging level for this instance
    int myDebugLevel;
    /// debugging on for this class?
    int myDebugOn;
    /// number of strings in <tt>debugModules</tt>.
    static int numDebugModules;
    /// array with pointers into names of modules to be debugged.
    static char **debugModules;
    /// names of modules to be debugged.
    static char *debugModulesText;
    /// number of strings in <tt>debugClasses</tt>.
    static int numDebugClasses;
    /// array with pointers into names of classes to be debugged.
    static char **debugClasses;
    /// names of class es to be debugged.
    static char *debugClassesText;
    /// translate index of debug module into index of all modules
    static int *transDebugModules;
    /// names of all modules
    static const char *allModuleNames[];
    /// the debug levels for all modules
    static int allModuleLevels[];
};

///Module: <b>raslib</b>.

/**
RMTimer is not strictly part of RasLib. It is a class used for taking
timing measurements if configuring with --benchmark-enabled. One way
of using it is to put the following at the beginning of a function:

<tt>RMTIMER("className", "functionName");</tt>

If RMANBENCHMARK is defined this is expanded to:

<tt>RMTimer localRMTimer = RMTimer("className", "functionName");</tt>

Time is taken between this line and exiting the block where this line
was. For more elaborate timing measurements an RMTimer object can be
used directly. All timing information is stored in the object, so
multiple RMTimer objects can be used at the same time.

If output is generated on RMInit::bmOut depends on the flag <tt>output</tt> and the benchmark level. Output is generated if <tt>output</tt>
is TRUE and <tt>bmLevel</tt> is lower than the global benchmark level
stored in RManBenchmark. The flag <tt>output</tt> can be changed with
setOutput(). The function start() sets <tt>output</tt> to TRUE, stop()
sets <tt>output</tt> to FALSE.

<b>Important</b>: If a RMTimer is used as a static variable, it must be
ensured that no output is generated in the destructor either by
calling stop() or by manually setting <tt>output</tt> to FALSE using
setOutput() before termination of the program. The reason is that
potentially RMInit::bmOut may be destructed before the RMTimer
destructor is called possibly causing a crash.
*/

/**
  * \ingroup RMs
  */

class RMTimer : public RM_Class
{
public:
    /// constructor, initializes members and starts timer.
    RMTimer(const char *newClass, const char *newFunc,
                   int newBmLevel = 4);
    /**
      The parameters newClass and newFunc have to be string literals. Just
      a pointer to them is stored. No output is generated if RManBenchmark
      < newBmLevel.
    */
    /// destructor, calls stop().
    ~RMTimer();
    /// switch output on RMInit::bmOut on and off.
    void setOutput(int newOutput);
    /**
      If newOutoutput is FALSE no output is created on RMInit::bmOut on
      the following calls to stop() and ~RMTimer() until the next start().
    */
    /// pauses timer.
    void pause();
    /// resumes timer.
    void resume();
    /// resets timer.
    void start();
    /**
      Also switches output to RMInit::bmOut on again.
    */
    /// prints time spent if output is TRUE.
    void stop();
    /**
      Time spent is the time since construction or last start() excluding
      the times between pause() and resume().
    */
    /// delivers current time count.
    int getTime();

private:
    /// name of class.
    const char *myClass;
    /// name of function (no parameters).
    const char *myFunc;
    /// flag, if stop() should print timing information
    int output;
    /// stores benchmark level, checked before output.
    int bmLevel;
    // reference parameter for gettimeofday().
    timeval acttime;
    /// accu for saving time in us
    long accuTime;
    /// flag indicating if the timer is currently running.
    unsigned short running;
    // reference parameter for gettimeofday, not used.
    static struct timezone dummy;
    /// used to calculate time spent in function.
    long oldsec;
    /// used to calculate time spent in function.
    long oldusec;
    /// aux function to determine clock time elapsed so far.
    void fetchTime();
};
///Module: <b>raslib</b>.

/**
Objects of this class increment the indent level of RMDebug at construction time and decrease this level at destruction time.
*/

/**
  * \ingroup RMs
  */

class RMCounter : public RM_Class
{
public:
    /// constructor, increments indent level if the class should be debugged.
    RMCounter(int levell, int module, const char *cls);
    /// destructor, decrements indent level.
    ~RMCounter();
private:
    bool doStuff;
};

#endif
