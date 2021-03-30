package webdriver_practice;


import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//capture screenshot of an element
//Open new tab
//open new window
//get Height, Width, Coordinates
//Relative locators - below(), above(), toLeftOf(), toRightOf(), near()

//try driver.findElement(new ByAll(By.name(""), By.id(""))).sendKeys("");
//try driver.findElement(new ByIdOrName("")).sendKeys("");

public class Selenium4 {

	@Test
	public void newTab() throws Exception
	{
		//WebDriverManager.chromedriver().setup();
		
		
		System.setProperty("webdriver.chrome.driver", "././Driver_Exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		String parent = driver.getWindowHandle(); //get window handle
	
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB); //open new tab
		newTab.get("https://www.facebook.com/");
		
		newTab.close();
		driver.switchTo().window(parent);
		
		
	    WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW); //open new window
	    newWindow.get("https://www.facebook.com/");
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void location() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	    
		WebElement control = driver.findElement(By.xpath("//div[@id='divLogo']//img"));

	    System.out.println(control.getRect().getDimension().getHeight());
	    System.out.println(control.getRect().getDimension().getWidth());
	    System.out.println(control.getRect().getX());
	    System.out.println(control.getRect().getY());
	    
	    Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void relativeLocator() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://automationbookstore.dev/");
		driver.manage().window().maximize();
	    
        WebElement book5 = driver.findElement(RelativeLocator.withTagName("li").toLeftOf(By.id("pid6")).below(By.id("pid1")));
        System.out.println(book5.getAttribute("id"));
	    Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void screenshotTest() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File trg = new File("HomePage.png");
//		FileUtils.copyFile(src, trg);
		
		WebElement test = driver.findElement(By.xpath("//div[@class='header-lower']"));
		File src1 = test.getScreenshotAs(OutputType.FILE);
		File trg1 = new File("Home.png");
		FileUtils.copyFile(src1, trg1);
		
	    Thread.sleep(5000);
		driver.quit();
	}
	

		




}
