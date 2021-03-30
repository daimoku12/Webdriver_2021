package webdriver_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown_ForLoop {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		List <WebElement> days = driver.findElements(By.xpath("//select[@id='day']//child::option"));
		
		for (WebElement day : days){
			
			if (day.getText().equalsIgnoreCase("15")){
				day.click();
				break;
			}
		}		
	}
}
