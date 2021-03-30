package webdriver_practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

//scroll(horizontal, vertical) i.e. scroll(0,400)

public class Scroll_Upcast_Downcast {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		  
        driver.get("http://jqueryui.com");
		   
		Thread.sleep(5000);
		
		//driver.executeScript("scroll(0,400)");    //Will also work
		
		//JavascriptExecutor je = (JavascriptExecutor) driver;
		JavascriptExecutor je = driver;  // version 3 onwards, will work
		
		je.executeScript("scroll(0,400);");    
	}
}


/*parent obj = new child(); //upcasting
child obj1 = (child)obj;  //downcasting
using obj1, methods of both parent and child can be accessed*/