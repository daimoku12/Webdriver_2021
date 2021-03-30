package webdriver_practice;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;

//Completely Automated Public Turing test to tell Computers and Humans Apart

public class Captcha {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.services.irctc.co.in/cgi-bin/bv60.dll/irctc/services/login.do");
		
		driver.findElementByName("userName").sendKeys("abc");
		driver.findElementByName("password").sendKeys("xyz");
		
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter captcha");
		String captcha = scan.nextLine();
		
		driver.findElementByName("captchaImage").sendKeys(captcha);
		
		scan.close();
		driver.close();

	}
}
