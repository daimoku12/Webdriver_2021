package webdriver_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test123 
{
	private WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void bootstrapperDropDown() throws InterruptedException
	{		
		driver.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
		driver.findElement(By.xpath(".//*[@id='menu1']")).click();
		Thread.sleep(1000);
		WebElement dropdown = driver.findElement(By.xpath("//ul[@class='dropdown-menu test']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(dropdown.findElement(By.xpath("//*[@role='menuitem'][contains(text(), 'HTML')]"))).perform();
	}
	
	@Test
	public void computedStyle()
	{
		//driver.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
		//WebElement element = driver.findElement(By.xpath("//a[@class='w3-left w3-btn'][contains(text(), 'Previous')]"));
		//System.out.println(element.getCssValue("background-color"));
		
	    driver.get("https://www.w3schools.com");
	    WebElement el = driver.findElement(By.xpath("//a[text()='LEARN HTML']"));
	    String contents = (String) ((JavascriptExecutor) driver)
	            .executeScript("return window.getComputedStyle(arguments[0]).getPropertyValue('background-color');", el);
	    System.out.println(contents);
	    //driver.close();
	}
	
}
