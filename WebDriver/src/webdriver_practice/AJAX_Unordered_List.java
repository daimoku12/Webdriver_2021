package webdriver_practice;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AJAX_Unordered_List {
		
	      @Test
	      public void tc001() throws InterruptedException{
		  System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		  ChromeDriver driver = new ChromeDriver(); 
		  
		  driver.get("https://www.udemy.com");
		  //driver.manage().window().maximize();
		  	  
		  driver.findElementByXPath("//input[@name='q']").sendKeys("selenium");
		  Thread.sleep(5000);
		  		  
		  String str = driver.findElementByXPath("//ul[@class='dropdown-menu c_quick-search__results']").getText();
		  //System.out.println(str);
		  
		  String A [] = str.split("\n");
		  System.out.println(A.length);
		  
		  for (int i=0; i<A.length;i++){
			  
			  if (A[i].equalsIgnoreCase("selenium webdriver with java")){
				  driver.findElementByXPath("//input[@name='q']").clear();
				  driver.findElementByXPath("//input[@name='q']").sendKeys(A[i]);
				  driver.findElementByXPath(".//*[@id='searchbox']/div/span/span/button").click();
			  }
		  }	  
	}
}
