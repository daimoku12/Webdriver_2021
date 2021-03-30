package webdriver_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_Print {
	
	public static void main(String[] args) {
	
	
	System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
	
	WebElement table = driver.findElementByXPath(".//*[@id='main']/div[3]/div");
	
	List <WebElement> rows = table.findElements(By.tagName("tr"));
		
	for (WebElement row : rows)
	{
		List <WebElement> cols = row.findElements(By.tagName("td")); 
		
		for (WebElement col : cols)
		{
			System.out.print(col.getText());
		}
		
		System.out.println();
	}		
 }
}
