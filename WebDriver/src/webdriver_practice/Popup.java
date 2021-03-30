package webdriver_practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Popup {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		Reporter.log("website opened");
						
		WebElement e = driver.findElementByXPath("//input[@name='proceed']");
		e.click();
		
		String str = driver.switchTo().alert().getText();
		
		System.out.println(str);
		
		Alert popUp = driver.switchTo().alert();
		popUp.accept();
		
		//popUp.sendKeys("");
		
/*		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();*/
	
	}

}
