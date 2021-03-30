package webdriver_practice;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hidden_Element {

	public static void main(String[] args) throws Exception {
		
	System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");
	
	/*<input id="male" name="male" hidden="" type="radio"/>
	  <input id="male" name="male" type="radio"/>*/
	
	List <WebElement> radio=driver.findElementsById("male");
	
	for(int i=0; i<radio.size(); i++){
	
		int x = radio.get(i).getLocation().getX();   //If X and Y coordinates are 0 - Element is hidden
	
		if (x!=0)                         //Run for x=0; element not visible exception
		{
		   radio.get(i).click();
		   break;
		}
	}
	driver.quit();
  }
}