StrangeBrew Java - 2.1.0
=============

(c)2000-2008 Drew Avis - drew.avis@gmail.com
Doug Edey - doug.edey@gmail.com

Thank you for downloading and trying StrangeBrew Java.

This file contains:
* What's New in this release?
* What is this?
* Running StrangeBrew Java
* Extra help for running on Linux
* Setting the look and feel
* Files in this release
* Required JRE
* Known Issues (bugs)
* Reporting Bugs
* Older Releases
* Roadmap
* Building the project
* Contributors
* Copyrights and Licenses

What's New
==========

2.1.0
---------
- New FEATURE! Web Server to allow you to read any recipes you have in your recipes directory on any device connected to the network
-- I'll be making this nicer soon
-- You can currently enable/disable this and set the Port in the Brewer Preferences panel, you must restart StrangeBrew when changing the values
- Lots of changes, I'll add any I can remember
- A lot of bugfixes
- Mash Calculator was broken so it would advise you to collect less than you needed
- Added a pantry mode so you can record how much of an ingredient you have
- Added more themes
- Moved to a DB for storing ingredients
- Fixed the Refractometer tool
- Add ingredients from the UI (Under the "Edit -> Add *" menus)
- Fix styles having the high and low the wrong way round


 What is this?
===============

This is a "release quality" release of StrangeBrew Java, which means 
it's feature-complete, and is pretty stable.  If you find bugs, please
report them via the Github Project. Or email a developer above

StrangeBrew Java is a Java port of the popular Windows homebrewing
software, StrangeBrew (www.strangebrew.ca).

Ingredients can now be added/edited from the application, removing the
need to edit the data files directly.

NOTE: We've changed the numbering of Java releases to 2.0, based on 
the idea that this is a continuation of the Windows version 1.8.


 


 Running StrangeBrew Java
==========================

Running StrangeBrew:
1. Unzip the sb_XXX.zip file (where XXX is the latest version, eg: "sb_2.0.1").
Be sure to preserve the directory structure.
2. Type "java -jar strangebrew.jar" at the command line.  Under Windows,
you can right-click this file, select "Open With > " and select a Java
installation. You can also just double-click the file, if ".jar" files
are associated with javaw.exe.  Double-clicking reportedly also works on
Mac OSX.  There's probably a Linux way to do this, but I don't know what it is.

NOTE: StrangeBrew loads data (ingredients, styles, etc) from:
src/ca/strangebrew/data/
When you unzip the file, be sure to preserve directory names, so
that StrangeBrew can find this data.


Extra help for running on Linux
===============================


**I do not recommend this, just use ``` java -jar strangebrew.jar ```**

These are notes from Scott Alfter via rec.crafts.brewing:

1. Make sure CONFIG_BINFMT_MISC is enabled in the kernel (built-in or
   module)...look in Executable file formats/Emulations -> Kernel support
   for MISC binaries. 
2. Add the following to /etc/fstab:
   binfmt_misc /proc/sys/fs/binfmt_misc binfmt_misc defaults 0 0
3. Create /usr/bin/jexec with the following contents and make it executable
   by everybody:
   #!/bin/sh
   java -jar $*
4. Add the following to whatever script your distro provides for local
   customization (in Gentoo, it's /etc/conf.d/local.start):
   echo ':jarexec:M::PK\x03\x04::/usr/bin/jexec:' >/proc/sys/fs/binfmt_misc/register

When you reboot (or if you execute the preceding from a root prompt), you
can chmod 755 strangeBrew_fat.jar and then run it with the following:

./strangeBrew_fat.jar

NOTE: At least one person has experienced problems running StrangeBrew on Fedora
using their 1.4.2 JRE, which is the GNU gcj.  The problem was solved by using the
1.5 JRE from Sun.  

For Ubuntu:
Install Sun's JRE:
	$ sudo apt-get install sun-java6-jre
Update default system JVM:
	$ sudo update-alternatives --config java
  Select java-6 from the list
	$ sudo update-alternatives --config jar
  Select java-6 from the list

See https://help.ubuntu.com/community/Java for more help with Ubuntu.

**This bug below is fixed**

Greg LaPolla points out:
When you create a launcher on the desktop and start the app with the java -jar 
command it displays the "can't find the database" error.  You can create a shell
script to fix it by simply changing to the StrangeBrew directory first:

```
#!/bin/sh
cd ~/StrangeBrew
java -jar StrangeBrew.jar
```


Setting the Look and Feel
=========================

The Java Swing library (which StrangeBrew uses for its user interface) supports
a "pluggable look and feel" (LAF) -- meaning you can easily change the appearance 
of Swing applications to suit your own tastes.  

The default is the System Look and Feel, this means that the application should 
fairly closely match your Operating Systems Look & Feel (there are some exceptions,
such as KDE based environments)

(Some betas of StrangeBrew used the JGoodies Looks LAF, but I removed
it as the default to give users more control over how the application looks).

Very nice look and feels are available on-line from several sources.  Here are 
a few of my favourites for StrangeBrew:
* JGoodies Looks: http://javootoo.l2fprod.com/plaf/jgoodies/index.php
* Liquid L&F: https://liquidlnf.dev.java.net/
* Synthetica L&F: http://www.javasoft.de/jsf/public/products/synthetica
* Tonic L&F: http://www.digitprop.com/p.php?page=toniclf

Download the .jar file you'd like to try, and put it in your Java home directory under
/lib/ext.

You can set the Look and Feel in a couple of ways:

1) From the Command-line:
Use the -Dswing.defaultlaf= option when starting the application.
Here's an example of starting StrangeBrew using the Synthetica LAF:

```java -Dswing.defaultlaf=de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel -jar strangebrew.jar```

The "de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel" bit is the full class 
name of the Look And Feel -- you'll have to read the documentation for each LAF to find 
out the proper text to put here

2) Using swing.properties:
You can set the default LAF for all Java Swing applications by editing the swing.properties
file in your $JAVA_HOME/lib directory.  You need to add two lines for your new LAF, and
change the default line.  Here's an example of the new & changed lines using the Tonic
LAF:
```
swing.installedlaf.tonic.name = Tonic
swing.installedlaf.tonic.class = com.digitprop.tonic.TonicLookAndFeel
swing.defaultlaf=com.digitprop.tonic.TonicLookAndFeel
```

3) Using the preferences options. Under the "Brewer" pane you can select from any of the L&Fs installed 
on your system. This gets saved.

Now start StrangeBrew as you would normally, and it should use the new LAF.


Files 
==========

The file you downloaded should contain these files (at least):
  * strangebrew.jar: a Fat Jar file which you can run (see above).  This
    file also contains the complete Java source for the application.  To
    view the source, decompress this file with an archive utility.
  * gpl.txt: the GPL license this software is distributed under
  * readme.txt: this file
  * src/ca/strangebrew/data: data files and the xslt files required 
    for exporting HTML and printing.  You can modify the xslt files if 
    you want to customize the look of the HTML.
  * help/: help files.  These files are under development.
  * recipes/: example recipe files in various formats.    
  * src/*: all the Java files you need to build and run StrangeBrew yourself.  
    You will need to either download or extract a couple of other .jar files 
    that StrangeBrew requires.


Required JRE
============

You require a Java Runtime Environment (JRE) on your system to run
StrangeBrew.  It requires versions 1.5 and up (See 
http://java.sun.com/j2se/1.5.0/index.jsp). As of version 2.0.1, 
StrangeBrew no longer runs under version 1.4.   StrangeBrew has
been tested and runs on Linux, MacOS-X, and Windows.  


Known Issues
============

* When importing recipes from StrangeBrew for Windows (1.8 or earlier),
fermentables that are sugars are incorrectly considered "grains".  Their
gravity contribution is calculated using the recipe efficiency, rather than
100%.  You should uncheck the "M" (for mashed) column, which indicates that
the ingredient is a sugar.  This applies to all sugar-type fermentables, such
as honey, DME, LME, maple syrup, and sugars.


Running from Eclipse
============

StrangeBrew.launch in the repository contains the Run configurations listed here.


Add a new Run or debug configuration with 
``` ca.strangebrew.ui.swing.dialogs.Splash ```

As the Main class, then you need to add the build directory to the Configuration, you may need to run a build first and refresh the eclipse directory

Class Path -> Advanced -> Add Folder -> find the "Build" directory


Reporting Bugs
==============

Look to the top right, there's a button for "Issues" click that, and report anything.

Or use http://reddit.com/r/StrangeBrew


Older Release 
==============

2.0.2
--------
New Features:
- You can now specify the BJCP style year you want to use (2004 or 2008).
- Random Name Generator for recipes!
- Table column sizes are now remembered when you close and restart the application
  (Request 1493295).
- Diluted recipe feature works a lot better.  Diluted specs show up on the main recipe
  details tab.  
- If StrangeBrew can't find the ingredient databases, it will ask you where they are instead
  of silently starting anyway.  
- StrangeBrew now looks more like a native MacOS/X application on Macs.  
- Windows Installer
- Ingredients can be added/edited from the GUI, under the Edit menu.

Bugs Fixed:
- Pre/Post boil volumes don't match the Unit
- Mac is now detected correctly
- BeerXML now opens files correctly
- Hops sorted correctly for timings, not name
- Switching temperature units no longer corrupts the value
- Adding fermentables now orders them correctly and they do not switch order when selecting the name
- Strangebrew now looks in the correct location for data files
- Misc water loss is now set correctly on the Water tab.
- Rager formula bug fixed.
- New Recipe Defaults: Temp Units now displays properly.

2.0.1
--------
New Features:
- New Gravity Teperature Tool Dialog (Request 1222300)
- New selectable user locale, which affects date format (Bug 1480514)
- New Fermentation Schedule tab
- New Carbonation tab
- New Water Treatment tab

Bugs Fixed:
- Default hop type (Leaf, Pellet, Plug) is now configurable (Request 1489276) 
- Text field auto selection (Bug 1489252)
- You can now select-by-typing in malt and hop lists (Bug 1493279)
- Mash Steps now insert at end of list (Request 1497970)
- Changed default bottle unit and size to imperal (Bug 1493267) 
- UI improvments to the saved "default" mash schedules


2.0.0
--------
Bugs Fixed:
- Mash ratio and ratio units are now properly displayed.
- After storing ingredients from an imported recipe, the database is no longer corrupted.
- Malt and hop drop-downs behave better (Bugs 1580524 and 1511954).
- Selecting a date now permanently changes it (Bug 1581203).
- The comments scrollbar now behaves correctly.
- File extensions don't keep multiplying every time you open the Save/SaveAs/Export dialogs.
- The Min column in the hops table is now handled correctly.
- The style dropdown now displays from the top of the list, rather than the bottom, for an empty style (Bug 1493269).


2.0.rc1
--------
New Features:
- StrangeBrew no longer uses the JGoodies Look And Feel by default, as this was
  causing some refresh issues on older versions of Mac OSX.  Instead, you can set
  the LAF yourself. (See the "Setting the Look And Feel" section above).
- You can now set the bottom of temp ranges used to determine mashout and sparge
  steps.  The defaults are 161F for mashout, and 170F for sparge.  This means that
  when you add a mashout step, it uses the middle of the range (161 + 170 / 2, or
  165.5F) when you add a mashout step, and if you change the start temp to <161, it
  becomes a different step type.  You can adjust these numbers to suit your mashing
  preferences.
- More and better StrangeBrew Java-specific help.  
- New Print toolbar button.

Bugs Fixed:
- FWH, mash hop, and dry hop IBU values are now correctly calculated.
- The strangebrew.ini file is now saved and read from the correct location on 
  non-Windows machines.
- HTML export now works again on non-Windows machines.  

2.0.b7
--------
New Features:
- You can now apply default mash schedules on the Mash tab to quickly load
  a popular schedule.  You can also save the current schedule to the list of
  defaults.  You can edit the /data/mashdefaults.csv file by hand to add or 
  remove a default schedule.
- The Resize Recipe dialog now allows you to also convert hops and fermentables
  (Bug 1489903).
- New potential extract calculator.  
- You can now add sparge steps to a mash schedule.  Add a step, and change the 
  type to "sparge".  If you add more than one sparge step, it's automatically
  considered a batch sparge, and correct additions are calculated.  
- You can now set the parameters for a thick and thin decoction on the 
  settings tab.
- You can now add cereal mash steps to a mash schedule.  Add a step, and change the
  method to "cereal mash".  Enter the weight of the grain used in the cereal mash.
  Other values will update accordingly.  Note: the temperature of the step is adjusted
  if the cereal mash addition brings the step above the targe temp.  Try
  decreasing the weight and adjusting the temperature until you get the values you
  want.  
- New Refractometer Utility lets you peform various calculations with readings
  from a refractometer.  

Bugs Fixed:
- You can now specify a default boil time on the Preferences Dialog (Bug 1493270)
- Style tab now displays correct SRM value when you're using EBC colour (Bug 1497989)
- You can now set various mash defaults on the Preferences dialog (Bug 1489256)
- You can now set boil units (C or F) as well as boil temp on the Preferences
  dialog (Bug 1489250)
- Cost tab now re-calculates correctly when values change (Bug 1493994)
- Final beer volume shown on cost tab now matches volume shown on water tab (Bug 1493294)
- BU:GU ratio is now displayed correctly on the Style panel (Bug 1493283).
- Dilution panel is now updated when you first open a recipe (Bug 1492475).
- Setting pre-boil amount now correctly updates post-boil amount.
- Changing mash temp units to C now correctly converts tun loss (Bug 1492220).
- Yeast now imports in BeerXML recipes. (Note: if there's more than one yeast
  listed, only the last is imported w/ the recipe).
- Find toolbar button now works (Bug 1489274).  
- Water panel numbers now aligned (Bug 1493293).
- On the preferences dialog, when you select a constant evaporation rate, the
  units are correctly displayed as the current default recipe volume units 
  (Bug 1493263).
- Removed the extra note area on the notes tab (Bug 1493286).
- Malts with a weight of 0 are correctly displayed as being 0% (Bug 1493276).  
- Malt and hop amounts are rounded to 2 decimal places instead of 1 (Bug 1493281).
- Preferences are saved in the right place on non-Windows machines.
- Misc ingredient table column widths are now nicer (Bug 1493284).
- %alc, ibu, colour method combos are wider so text isn't cut off (Bug 1489271).
- Switching between % and constant evaporation doesn't redraw the Preferences
  tab. (Bug 1493266)
- Mash tab now shows step volume and temp. (Bug 1489258)  

  

 Roadmap
=========

Features on the "TODO List" for StrangeBrew:
- mash tun thermal mass
- hop scaling
- real application help (not the SB Win version)
- save / load mash profiles
- specify mash temp ranges
- cereal mash
- allow user-specified precision of values

Planned StrangeBrew  Pro Features:
- advanced water profiling
- inventory tracking
- brewday timeline generation
- brew sessions (vs recipes)
- saved mash schedules
- alternate malt/hop selection dialog
- ingredient database editing
- equipment databases
- iPod Note export

(StrangeBrew Java will be released under a "dual-license": a free 
Open Source version and a commercial "Pro" version that will 
include some additional functionality.)

Comments or questions should be directed to drew.avis@gmail.com.


Building the project
====================

Complete StrangeBrew Java source is included in the strangebrew.jar file.
StrangeBrew Java source is also available via github

(http://github.com/DougEdey/StrangeBrew)[Github Repo] for more information.

I'm building the project in Eclipse, which is freely available at eclipse.org.  
Once you've un-archived the source from the jar file (or obtained it from cvs), you
can import it as a new project into Eclipse.  You'll need to:
- add the 3rd party .jar files in /lib (in the strangebrew.jar archive) to the 
  project libraries
- add an appropriate Sun JRE (1.5+) to the project libraries, if one is not already
  selected

That should be all you need to build and run the program.

If you wish to build the application from Ant, Greg LaPolla has kindly contributed
a build file (build.xml in the top level of the source tree).  This file has three
targets:
* ant build - build the application
* ant clean - clean the workspace
* ant zip - build a zip file for distribution.  You have to edit
  the version.num property at the top of the build.xml file.  This build target
  also unpacks the other jars and incorporates them into the distributable
  jar and it also creates the manifest file. 

Contributors
============

The following people have contributed to the development of this 
program:
* Mike Charlton - SWT gui development / Java consulting
* Jim Clark - bug fixing and new feature development
* Chris Cook - xslt development
* Andy Davison - testing
* Mike Gibson - testing and the splash screen / logo
* Kris Henderson (Zymurgist) - preferences coding
* Don Kelly - Promash recipe format decoding
* Colin Kilburn - testing / bug fixes
* Jason Landry - database updates
* Jeroen Wouters - bug fixes
* Greg LaPolla - bug fixes / ant build / windows installer
* Sean Cotterill - for his research into Refractometer accuracy


Copyrights
==========

Parts of this program are copyright by:
        Copyright (C) 2002-2004 Roedy Green 
        (CSVReader and CSVWriter classes)
        Copyright (C) Copyright (c) 2003-2004 Werner Randelshofer
        (Splash and SplashWindow classes)
        Copyright (c) 2001-2006 JGoodies Karsten Lentzsch. All rights reserved.
        (JGoodies Look and Feel)
        Copyright (c) 2005-2006, Michael Baranov
        (Microba library)


License
=======

        Copyright (C) 2006-2008  Drew Avis

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
    
    See the gpl.txt file for more information.
    

