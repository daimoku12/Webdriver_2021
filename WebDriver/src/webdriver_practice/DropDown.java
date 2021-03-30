package webdriver_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./Driver_Exe/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");                        //get - opens a url
		
		//driver.manage().window().maximize();    //Open browser in full screen
		
		//navigate() - used to perform browser operations
		
	  /*driver.navigate().to("https://www.facebook.com");
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();*/
		
		driver.findElement(By.id("email")).sendKeys("xyz");            //sendkeys - to enter data in text box/ text area/ edit box
	
		//WebElement uname = driver.findElement(By.id("email"));       //Create object of a web element
		//uname.clear();                                               //clear - clears value in text box
		
		driver.findElement(By.id("pass")).sendKeys("goldenman$!!");
//		driver.findElement(By.xpath("//input[@value='Log In']")).click(); //click (button, checkbox, radio button, link)
		
//		String Url = driver.getCurrentUrl();                           //getCurrentUrl
//		System.out.println(Url);
		
//		driver.close();                                                //close - close the current browser (window/tab)
//		driver.quit();                                                 //quit - close all windows/tabs opened by driver
		
//      Drowpdown/ list - Element's html will start with 'select'		
		
        Select month = new Select(driver.findElementById("month"));    //This statement or below 2 statements are same
		
		/*WebElement dropdown_month = driver.findElementById("month");
		Select month = new Select(dropdown_month);*/
        
        month.selectByIndex(10);
        Thread.sleep(3000);
        month.selectByValue("5");
        Thread.sleep(3000);
        month.selectByVisibleText("Jun");
        //Thread.sleep(3000);
        //month.deselectByIndex(10);
        
        List <WebElement> a = month.getOptions();
        System.out.println(a.size()); //13
        
        driver.close();
        
	}

}
