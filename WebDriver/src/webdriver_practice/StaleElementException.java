package webdriver_practice;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class StaleElementException {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		WebElement login = driver.findElementById("email");
		driver.navigate().refresh();
		
		login.sendKeys("ABC");
		
		//wait.until(ExpectedConditions.elementSelectionStateToBe(By.id("name"), true));
		
/*	A stale element reference exception is thrown in one of two cases, the first being more common than the second:

	-The element has been deleted entirely (Ex: Page refresh, user navigated to some other page)
	-The element is no longer attached to the DOM   */
		
// http://darrellgrainger.blogspot.in/2012/06/staleelementexception.html		
		
	}

}
