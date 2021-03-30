package webdriver_practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Dropdown_CSS_Actions_Mouse {
    
	@Test
	public void tcase() throws Exception{
	
	System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("https://www.w3schools.com/css/css_dropdowns.asp");
	
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElementByXPath(".//*[@id='main']/div[6]/button")).perform();
	Thread.sleep(4000);
	
	act.moveToElement(driver.findElementByXPath(".//*[@id='main']/div[6]/button/following::div[1]/a[2]")).perform();
	Thread.sleep(4000);
	
	}
}
