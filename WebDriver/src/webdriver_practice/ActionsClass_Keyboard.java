package webdriver_practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass_Keyboard {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com");
	
	driver.findElementById("email").sendKeys("ABC");
	
	boolean a = driver.findElementById("email").isDisplayed();
	
	
	Actions act = new Actions(driver);
	
	//act.sendKeys(Keys.TAB).perform();
	//act.sendKeys("XYZ").perform();
	//act.sendKeys(Keys.RETURN).perform();
	
	act.sendKeys(Keys.CONTROL).sendKeys("a").build().perform();
	act.sendKeys(Keys.CONTROL).sendKeys("c").build().perform();
	act.sendKeys(Keys.TAB).perform();
	act.sendKeys(Keys.CONTROL).sendKeys("v").build().perform();
	Thread.sleep(5000);
	driver.quit();
		
	}

}
