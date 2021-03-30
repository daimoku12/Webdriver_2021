package webdriver_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender_jse {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "././Driver_Exe/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://www.spicejet.com");
		
		WebElement date = driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','30-01-2018');", date);
		
		
		
		
	}

}
