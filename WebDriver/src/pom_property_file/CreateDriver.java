package pom_property_file;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CreateDriver {
	
	public WebDriver driver;
	ResourceBundle rb;
	
	@BeforeMethod
	public void initiateDriver(){
	
		rb = ResourceBundle.getBundle("Elements");
		
		if (rb.getString("browser").equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		driver = new ChromeDriver();	
		}
		
		else if (rb.getString("browser").equalsIgnoreCase("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "./Driver_Exe/geckodriver.exe");
		driver = new FirefoxDriver();
		}
		
		driver.get(rb.getString("URL"));
	}
	
	@AfterMethod
	public void closeDriver(){
		
		driver.quit();
	}
}
