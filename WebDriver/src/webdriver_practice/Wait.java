package webdriver_practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://thetestingworld.com/");
		
        //If page is loaded in 3 seconds, it will not wait for 17 seconds
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		Thread.sleep(2000); //Java. It will wait for time defined
		
		//Written once, applicable for all FindElement commands 
		//If element is found early, it will not wait for entire time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Existence/Property of element - Explicitly Wait
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementById("name"), "Delhi"));
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("name")));
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sbqs_c']")));	
		
		wait.until(ExpectedConditions.elementSelectionStateToBe(By.id("name"), true));
		
	}

}
