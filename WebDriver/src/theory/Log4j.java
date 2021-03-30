package theory;

public class Log4j {
	
	/*Download jar
	Create log4j.xml under project root folder

	log.(info, warn, error, fatal, debug, startTestCase, endTestCase)	
	
	--XML
	
	<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
	 
	<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/" debug="false">
	 
	<appender name="fileAppender" class="org.apache.log4j.FileAppender">
	 
	<param name="Threshold" value="INFO" />
	 
	<param name="File" value="logfile.log"/>
	 
	<layout class="org.apache.log4j.PatternLayout">
	 
	<param name="ConversionPattern" value="%d %-5p [%c{1}] %m %n" />
	 
	</layout>
	 
	</appender>
	 
	<root>
	 
	<level value="INFO"/>
	 
	<appender-ref ref="fileAppender"/>
	 
	</root>
	 
	</log4j:configuration>
	
	--Base Class Constructor
	
	log=Logger.getLogger("TestBase");
	DOMConfigurator.configure("log4j.xml");
	
*/
}
