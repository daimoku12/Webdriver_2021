package webdriver_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll_IntoView {
	
	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver","./Driver_Exe/chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	 
	driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		 
	JavascriptExecutor je = (JavascriptExecutor) driver;
	
	//Identify the WebElement which will appear after scrolling down
	 WebElement element = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));
	 // now execute query which actually will scroll until that element is not appeared on page.
	je.executeScript("arguments[0].scrollIntoView(true);",element);
	 // Extract the text and verify
	System.out.println(element.getText());
	 
	}
}
