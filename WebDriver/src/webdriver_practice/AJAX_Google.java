package webdriver_practice;


import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AJAX_Google {
	
	 @Test
     public void tc001() throws InterruptedException, IOException {
	  System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
	  ChromeDriver driver = new ChromeDriver(); 
	  
	  driver.get("https://www.google.com");
	  driver.findElementByName("q").sendKeys("hello");
	  
	  
/*	 File src= driver.getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(src, new File("./Screenshot/"+"screenshot.png"));  */ 
	  
	  Thread.sleep(5000);

	//Try xpath: //ul[@class='sbsb_b']/li/descendant::div[@class='sbqs_c']
	  
	//String str =  driver.findElementByXPath(".//*[@id='sbtc']/div[2]/div[2]/div[1]/div/ul/li[1]/parent::*").getText();
	
	String str =  driver.findElementByXPath("//ul[@class='erkvQe']").getText();
	System.out.println(str);
	
	String A[] = str.split("\n");
	for(int i=0;i<A.length;i++){
		
		if (A[i].contains("hello kitty")){
			driver.findElementByName("q").clear();
			driver.findElementByName("q").sendKeys(A[i]);
			Thread.sleep(3000);		
	}
  }
 }
}