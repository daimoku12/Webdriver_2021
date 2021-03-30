package webdriver_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Udemy_Actions {
			
		public static void main(String[] args) throws Exception {
			
			System.setProperty("webdriver.chrome.driver", "././Driver_Exe/chromedriver.exe");
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			//driver.manage().window().maximize();
			
			driver.get("https://www.udemy.com/");
			Actions action = new Actions (driver);
			
			//perform - mouse hover
			//click.build.perform - mouse hover and click
			
			action.moveToElement(driver.findElementByClassName("ellipsis")).perform();
			action.moveToElement(driver.findElementByXPath("//span[text()='Development']")).perform();
					
			//action.moveToElement(driver.findElementByXPath("//span[text()='Web Development']")).click().build().perform();
			
			/*WebDriverWait wait = new WebDriverWait (driver,10);			
			WebElement button = driver.findElementByXPath("//span[text()='Web Development']");
			wait.until(ExpectedConditions.elementToBeClickable(button));
			button.click();*/
			
			WebElement element = driver.findElementByXPath("//span[text()='Web Development']");
			JavascriptExecutor jse = driver;
			jse.executeScript("arguments[0].click();", element);
			
		
	}

}
