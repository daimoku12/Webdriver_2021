package webdriver_practice;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class Multiple_Window {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver_Exe/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.in/2017/07/multiple-window-examples.html");
		
		String parent = driver.getWindowHandle();
		
		//First get all windows opened to get the size of Set fixed
		
		driver.findElementByXPath("//a[@href='http://www.google.com']").click();
		driver.switchTo().window(parent);
		driver.findElementByXPath("//a[@href='http://www.yahoo.com']").click();
		
		Set <String> allWindows = driver.getWindowHandles();  
		
/*		for (String child : allWindows){                     //First method
			  if (!parent.equalsIgnoreCase(child)){
			         driver.switchTo().window(child);
			         driver.findElementByName("q").sendKeys("hello");
			         driver.close();
			  }
			}
		
		driver.switchTo().window(parent);*/
		
		ArrayList <String> tabs = new ArrayList<>(allWindows);  //Second method
        	
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.findElementByName("q").sendKeys("hello");
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parent);
		
		driver.switchTo().window(tabs.get(2));
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parent);
	}
}

/*driver.get("https://www.naukri.com");
Set<String> wins = driver.getWindowHandles();

for (String s : wins)
{

 driver.switchTo().window(s);
 if (driver.getCurrentUrl().equalsIgnoreCase("https://naukri.com/"))
  {
  }

 else
  {
   driver.close();
  }
} */
