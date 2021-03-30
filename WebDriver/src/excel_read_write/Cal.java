package excel_read_write;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Cal {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:/Users/Kannu/Downloads/Compressed/chromedriver_win32/chromedriver.exe");
		//WebDriver driver =new ChromeDriver(options);
		ChromeDriver driver = new ChromeDriver(options);

	   	driver.get("https://www.redbus.in");
	   	 
	   	driver.findElementByXPath(".//*[@id='search']/div/div[3]/span").click();
	   	//((RemoteWebDriver) driver).findElementByXPath(".//*[@id='search']/div/div[3]/span").click();
	    Thread.sleep(2000);
	      
	    List <WebElement> dates = driver.findElementsByXPath(".//*[@id='rb-calendar_onward_cal']/table/tbody//td");
	    //List <WebElement> dates = ((FindsByXPath) driver).findElementsByXPath(".//*[@id='rb-calendar_onward_cal']/table/tbody//td");
	      
	      for (int i =0; i<dates.size(); i++){
	    	  
	    	  String dateValue = dates.get(i).getText();
	    	  
	    	  if (dateValue.contains("31")){
	    		  dates.get(i).click();
	    		  Thread.sleep(5000);
	    		  break;
	    	  }
	      }   	  
	  }
}
