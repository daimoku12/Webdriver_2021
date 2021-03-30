package theory;

/*1) Install Java JDK....................................................................

http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Java SE Development Kit 8u144	
Accept license Agreement
Windows x64

2) Install Eclipse IDE (Any version except Oxygen)......................................

http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/oxygenr
	
3) Attach Javadoc.......................................................................

Ctrl + println (or any keyword)
Attach Source --> External location --> External File
Goto --> "C:\Program Files\Java\jdk1.8.0_144\src.zip" and select src.zip

4) Install TentNG......................................................................

Eclipse IDE --> Help --> Eclipse Marketplace --> Search for 'testng' --> Install TestNG for Eclipse

If Marketplace is not opening:
	
-Goto Window-->Preferences-->Network Connections
-Select Active Provider as 'Manual'
-Check all fields in Proxy entries and Proxy bypass
-Apply	Or turn off Antivirus Firewall

5) Install Apache POI (How to use Maven)......................................................

To read or write an Excel, Apache provides a library POI. This library is capable enough to read and write both 
XLS and XLSX file format of Excel.

Create a new Project - ExcelWork
Right Click
Configure - Convert to Maven project

Groupid - Any domain name - Automation
Artifact Id - Project name - ExcelWork

Under ExcelWork. pom.xml will be created
Goto Dependencies and add .jar poi and poi-ooxml
Press Ctrl S

How to add .jar poi and poi-ooxml
Goto--> mvnrepository.com-->Search 'POI' (Take poi and poi-ooxml)  
Note - Select versions with maximum downloads and select same versions for poi and poi-ooxml

Copy values of: Group Id, Artifact Id and Version

Trivia: Goto Command and type 'm2'. Check in m2. If .jar not available, then install

6) Add Selenium java .jar (from mvnrepository.com)..................................................................................

Copy the dependency section and paste in pom.xml

7) Add Javadoc for Selenium, TestNG.................................................................................

Goto Seleniumhq.org
Goto Download tab
Click on Java-->Javadoc
Copy the path (http://seleniumhq.github.io/selenium/docs/api/java/index.html)

In Eclipse IDE

Goto Project
Right Click.
Build path --> Configure Build Path --> Libraries-->Maven Dependencies-->selenium-java-3.4.0.jar & selenium api-->javadoc location (double Click)

Paste the url and remove index.html

http://seleniumhq.github.io/selenium/docs/api/java - Selenium javaDoc
http://www.javadoc.io/doc/org.testng/testng/6.11 - TestNG JavaDoc
http://extentreports.com/docs/versions/2/java/ - Extent Report
https://www.javadoc.io/doc/info.cukes/cucumber-java/1.2.4 - Cucumber

8) Download Chrome driver.......................................................................

Goto Chrome-->Help-->About Google Chrome (to check version - version 61)
Google - Chromedriver for Chrome 61
Click on first link and check the Latest release
Latest Release: ChromeDriver 2.32

Goto : http://chromedriver.storage.googleapis.com/index.html
Click 2.32
Click chromedriver_win32.zip

save as : Downloads\Compressed\chromedriver_win32.zip
Unzip

provide .exe path in program

9) Install Firebug (Control+F12) and Firepath plugin for Firefox..............................................

You can edit, debug, and monitor CSS, HTML, and JavaScript live in any web page… 
FirePath is a Firebug extension that adds a development tool to edit, inspect and generate XPath expressions and CSS3 Selectors

- Install Firepath from addon options
- Goto https://addons.mozilla.org/en-US/firefox/addon/firebug/versions/?page=1
- Find compatable FireBug

Version 2.0.18 (FireBug)
FirePath 0.9.7.1.1-signed.1-signed (FirePath)
Firefox version - 50.1.0

10) Add External jar (eg - Selenium)..........................................................

GOTO http://www.seleniumhq.org/download/ --> Download Java
Eclipse--> Right Click on project --> Build Path --> Configure Build path --> Libraries -->Add External jars

11) Download GeckoDriver for Firefox........................................................

https://github.com/mozilla/geckodriver/releases
geckodriver-v0.12.0-win64 (only compatible with Selenium 3.4 and greater)

12) To use ArrayList - Use JDK 1.7 .............................................

13) Cucumber Eclipse plugin.......................................................
Goto Marketplace and install

http://cucumber.github.com/cucumber-eclipse/update-site

14) Add tools.jar...........................................................

  <dependency>
   <groupId>com.sun</groupId>
   <artifactId>tools</artifactId>
   <version>1.6</version>
   <scope>system</scope>
   <systemPath>C:\Program Files\Java\jdk1.8.0_144\lib\tools.jar</systemPath>
 </dependency>
 
15) C:\Program Files\Java\jdk1.8.0_144\bin; (Env path variable setup).....................
 
 or Window>Preferences>Installed JRE>Update to JDK
 
16) Cucumber - Junit version 4.11...........................................
 
17) SWD Page recorder, Selenium builder (FF), Katalon Automation (chrome)........................
 

  
*/

public class Env_Setup {

}