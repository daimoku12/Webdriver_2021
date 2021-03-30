package webdriver_practice;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Dropdown_Bootstrap {
	
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
		driver.findElementByXPath(".//*[@id='menu1']").click();
		
		//String str = driver.findElementByXPath(".//*[@id='menu1']/following::ul").getText();
		//System.out.println(str);
		
		List <WebElement> dropdown = driver.findElementsByXPath(".//*[@id='menu1']/following::ul/li/a");
		
		for (WebElement el : dropdown){
			
			//if(el.getAttribute("innerHTML").contentEquals("JavaScript")){
				if (el.getText().contentEquals("JavaScript")){
				System.out.println(el.getAttribute("innerHTML"));
				el.click();
				break;
			}
		}
		
		//CSS Dropdown
		driver.get("https://www.w3schools.com/css/css_dropdowns.asp");
		driver.findElementByXPath(".//*[@id='main']/div[6]/button").click();
		Thread.sleep(4000);
	    String str1 = driver.findElementByXPath(".//*[@id='main']/div[6]/button/following::div[1]/a[2]").getText();
		System.out.println(str1);
		

	}
}

