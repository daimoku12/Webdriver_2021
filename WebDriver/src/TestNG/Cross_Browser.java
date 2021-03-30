package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_Browser {
	
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void test1(String browser) {
	 
	if(browser.equalsIgnoreCase("firefox")){
	
	//System.setProperty("webdriver.gecko.driver", "./Driver_Exe/geckodriver.exe");		
	//WebDriver driver=new FirefoxDriver();
	//driver.get("http://www.facebook.com"); 
    System.out.println("From firefox");
    
	}
	
	else if(browser.equalsIgnoreCase("chrome")){
	 
	System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");	
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.facebook.com");
	}
	
 }
}
