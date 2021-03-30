package theory;

public class Jenkins {
	
/*	Jenkins installation and setup..................................................
	 
	Google download Jenkins war file
	https://updates.jenkins-ci.org/download/war/
	permalink to the latest
	command prompt
	cd Downloads\Jenkins
	java -jar jenkins.war or java -jar "jenkins.war" --httpPort=8085 (any port)
	Admin user created 
	password: 0c4d00d6a8b547d5bb78f477cfaaffd7
	(C:\Users\Kannu\.jenkins\secrets\initialAdminPassword)
	goto localhost:8080
	Enter Administrator password
	Install default plugins

	Manage Jenkins
	Manage plugins
	available - install GitHub, Maven, TestNG Report and Cucumber plugins

	Manage Jenkins
	Global tool configuration
	JDK > Add JDK > uncheck automatic installation and provide JDK path set as env variable
	MAVEN > download Maven and extract > Add MAVEN (same steps as JDK) (C:\Users\Kannu\Downloads\apache-maven-3.5.2\bin)
	GIT > Download GIT and install > Add to system variable and Jenkins GIT (C:\Program Files\Git\bin\git.exe)

	Create New Job
	Goto New Item > Enter a name > select Maven project > ok > 
	Project Confg > Enter Git Repository url, goals (clean install), POM (Framework\pom.xml),  

	Post build action > Publish HTML Reports > Index page(s) - Framework\Report\extent.html
	CucumberBDD\extent-report\extent-report.html (for Cucumber project)
	
	Cucumber test result report - CucumberBDD\target\json-report\cucumber.json

	Setting to get extent report in good format (install HTML report plugin)
	Manage Jenkins > Script Console
	System.setProperty("hudson.model.DirectoryBrowserSupport.CSP","")
	System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", 
	"sandbox allow-scripts; default-src 'self'; script-src * 'unsafe-eval'; img-src *; style-src * 'unsafe-inline'; font-src *");
	Run twice until you see result:

	Email Setting

	Manage Jenkins> Configure System > Email Notification
	SMTP server - smtp.gmail.com
	Use SMTP Authentication (check)
	USE SSL check
	SMTP port - 465 (for gmail)
	Reply to address - noreply@gmail.com
	
	CRON (time-based job scheduler)
	
	# ┌───────────── minute (0 - 59)
	# │ ┌───────────── hour (0 - 23)
	# │ │ ┌───────────── day of month (1 - 31)
	# │ │ │ ┌───────────── month (1 - 12)
	# │ │ │ │ ┌───────────── day of week (0 - 6) (Sunday to Saturday;
	# │ │ │ │ │                                      
	# │ │ │ │ │
	# │ │ │ │ │
	# * * * * *  command to execute

	For example, the following clears the Apache error log at one minute past midnight (00:01) every day, 
	assuming that the default shell for the cron user is Bourne shell compliant:

	1 0 * * * printf > /var/log/apache/error_log
	This example runs a shell program called export_dump.sh at 23:45 (11:45 PM) every Saturday.

	45 23 * * 6 /home/oracle/scripts/export_dump.sh

	Entry	Description	                                               Equivalent to
	@yearly Run once a year at midnight of 1 January	                0 0 1 1 *
	@monthl Run once a month at midnight of the first day of the month  0 0 1 * *
	@weekly	Run once a week at midnight on Sunday morning	            0 0 * * 0
	@daily	Run once a day at midnight	                                0 0 * * *
	@hourly	Run once an hour at the beginning of the hour	            0 * * * *
	@reboot	Run at startup	N/A
	*/

}
