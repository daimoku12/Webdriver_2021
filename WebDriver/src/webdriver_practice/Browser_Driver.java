package webdriver_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_Driver {
	
	public static void main(String[] args) {
		
	//System.setProperty("webdriver.chrome.driver","./Driver_Exe/chromedriver.exe");	
		
/*  Create folder in project and paste the driver exe	
	'./' represents current project	*/
		
		
	System.setProperty("webdriver.chrome.driver","C:/Users/Kannu/Downloads/Compressed/chromedriver_win32/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com");
		
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kannu\\Downloads\\Compressed\\geckodriver-v0.12.0-win64\\geckodriver.exe");
    WebDriver driver1 = new FirefoxDriver();
    driver1.get("https://www.google.com");
	
    driver.close();
    driver1.close();
    
 }
}
