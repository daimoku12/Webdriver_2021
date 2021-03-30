package webdriver_practice;

import org.openqa.selenium.By;

/*Switch from Top Window to Frame

- Using Frame index
- Using Frame Name   */

//driver.switchTo().parentFrame();
//driver.switchTo().defaultContent();

import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		driver.manage().window().maximize();
		
		
		//driver.switchTo().frame(2);
		driver.switchTo().frame("classFrame");
		
		driver.findElementByLinkText("org.openqa.selenium").click();
		
		// Find index of a Frame
           
		int size = driver.findElements(By.tagName("iframe")).size();
		
		System.out.println(size);
		
		for(int i=0; i<size; i++){
			
			driver.switchTo().frame(i);
			int found = driver.findElements(By.xpath(".//*[@id=':d1']/h2/div[2]")).size();
			System.out.println(found);
			driver.switchTo().defaultContent();
			}	
		
	}

}
