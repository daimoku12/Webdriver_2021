package library;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	
	public static void captureScreenShot(WebDriver driver){
		
		  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss");
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		  
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		  try { 	
		      FileUtils.copyFile(src, new File("./Screenshot/"+sdf.format(timestamp)+".png")); 
			  //FileUtils.copyFile(src, new File("./Screenshot/"+System.currentTimeMillis()+".png"));   
		      }
		 
		catch (IOException e)
		      {
		        System.out.println(e.getMessage());
		      }
   }
	
	public static void highlightElement(WebDriver driver, WebElement element)
	{
	    JavascriptExecutor js=(JavascriptExecutor)driver; 
	    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        captureScreenShot(driver);	 
	    try 
	      {
	       Thread.sleep(1000);
	      } 
	    catch (InterruptedException e) {
	       System.out.println(e.getMessage());
	      } 
	 js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
	 
	}	

}
