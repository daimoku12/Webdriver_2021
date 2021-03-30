package webdriver_practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass_Mouse {
	
  public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://thetestingworld.com/");
	
	driver.manage().window().maximize();
		
	Actions act = new Actions(driver);
	
	//act.click();
	//act.contextClick();  //Right Click
	//act.dragAndDrop(source, target);
	
	//perform - mouse hover only
	
	act.moveToElement(driver.findElementByXPath("//span[text()='Video Courses']")).perform();
	Thread.sleep(2000);
	driver.findElementByXPath("//a[@href='http://thetestingworld.com/product-category/databases/']").click();
	//move mouse and click - click().build().perform();  
	driver.close();  
	  	  
  }	
}
