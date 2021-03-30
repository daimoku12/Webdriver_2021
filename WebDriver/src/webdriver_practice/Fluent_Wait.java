package webdriver_practice;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;



public class Fluent_Wait {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","./Driver_Exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		
		  // Waiting 30 seconds for an element to be present on the page, checking
		  // for its presence once every 5 seconds.
		  
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	       
		       wait.withTimeout(30), TimeUnit.SECONDS);
		       wait.pollingEvery(5, TimeUnit.SECONDS);
		       
		       wait.ignoring(NoSuchElementException.class);

		   WebElement element = wait.until(new Function<WebDriver, WebElement>()
		   {
			 @Override  
		     public WebElement apply(WebDriver arg0) 
		     {
		      return arg0.findElement(By.xpath("//p[text()='WebDriver']"));
		     }
		   }
		   );
		   
		   element.click();
	}

}
