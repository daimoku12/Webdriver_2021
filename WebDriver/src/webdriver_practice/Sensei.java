package webdriver_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sensei {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "././Driver_Exe/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.senseilabs.com/senseios/hiring/");
		
		driver.findElement(By.xpath("//li[@id='menu-item-498']")).click();
		driver.findElement(By.xpath("//a[@href='https://www.senseilabs.com/senseios/']")).click();
		
	}

}
