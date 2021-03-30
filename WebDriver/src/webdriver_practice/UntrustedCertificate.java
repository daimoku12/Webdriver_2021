package webdriver_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class UntrustedCertificate {
	
public static void main(String[] args) {
	
DesiredCapabilities cap = DesiredCapabilities.chrome();
cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
System.setProperty("webdriver.chrome.driver","./Driver_Exe/chromedriver.exe");
WebDriver driver=new ChromeDriver(cap);

driver.get("https://expired.badssl.com/");

/*FirefoxProfile profile=new FirefoxProfile();
profile.setAcceptUntrustedCertificates(true);
WebDriver driver=new FirefoxDriver(profile);
driver.get("url");*/

//https://badssl.com/

/*for IE
driver.Navigate().GoToUrl("javascript:document.getElementById('overridelink').click()");*/

 }
}
