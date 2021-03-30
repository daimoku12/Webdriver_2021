package webdriver_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class practice {

	@Test
	public void pract()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
		//Dropdown using for loop............................................................
		
		driver.get("https://www.facebook.com");
		List <WebElement> month = driver.findElements(By.xpath("//select[@id='month']/option"));
		
		for (WebElement m : month)
		{
			if (m.getText().equalsIgnoreCase("may"))
			{
				m.click();
				break;
			}
		}
		
		//Dropdown select.....................................................................
		
	    WebElement date = driver.findElement(By.xpath(".//*[@id='day']"));
		Select day = new Select (date);
	    day.selectByVisibleText("21");
		
		//JSE Scroll...........................................................................
		
		driver.get("https://www.visier.com/careers/test-development-manager-data-management/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,800)");
		
		driver.findElement(By.xpath("//a[@href='https://www.visier.com/clarity/']")).click();
		
		//AJAX, UL, Actions Keyboard - Google...................................................
		
		driver.get("http://www.gooogle.com");
		driver.findElement(By.id("lst-ib")).sendKeys("hello world");

		String str = driver.findElement(By.xpath("//ul[@class='sbsb_b' and @role='listbox']")).getText();
		System.out.println(str);
		String[] A = str.split("\n");
		
		Actions action = new Actions (driver);
		
        for (int i=0; i < A.length; i++){
        	if (A[i].equalsIgnoreCase("hello world french")){
        		driver.findElement(By.id("lst-ib")).clear();
        		driver.findElement(By.id("lst-ib")).sendKeys(A[i]);
        		action.sendKeys(Keys.ENTER).perform();
        		//driver.findElement(By.xpath("//input[@value='Google Search']")).click();
        		break;
        	}
        }
		
		//Frames.................................................................................
		
		driver.navigate().to("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//a[@href='com/thoughtworks/selenium/condition/package-summary.html']")).click();
		driver.switchTo().defaultContent();
		
        //Search for Frame Index + Scroll .........................................................
		
		driver.navigate().to("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		
		int totalFrames = driver.findElements(By.tagName("frame")).size();
		System.out.println(totalFrames);
		
		for (int i = 0; i < totalFrames; i++) {
			driver.switchTo().frame(i);
			int test = driver.findElements(By.xpath("//a[@href='com/thoughtworks/selenium/condition/package-frame.html']")).size();
			System.out.println(test);
			driver.switchTo().defaultContent();
		}
		
		driver.switchTo().frame(0);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,50);");
		
		//Multiple windows using Set only............................................................
		
		driver.get("http://seleniumpractise.blogspot.in/2017/07/multiple-window-examples.html");
		
		String parent1 = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[@href='http://www.google.com']")).click();
		driver.switchTo().window(parent1);
		driver.findElement(By.xpath("//a[@href='http://www.facebook.com']")).click();
		
		Set <String> allWindows1 = driver.getWindowHandles();
		
		for (String child : allWindows1){
			
			if (!child.equalsIgnoreCase(parent1)){
				driver.switchTo().window(child);
				driver.close();
			}
		}
		
		//Multiple windows (convert Set into ArrayList).................................................
		
		driver.get("http://seleniumpractise.blogspot.in/2017/07/multiple-window-examples.html");
		
		String parent = driver.getWindowHandle();
		
		System.out.println(parent);
		
		driver.findElement(By.xpath("//a[@href='http://www.google.com']")).click();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//a[@href='http://www.facebook.com']")).click();
		
		Set <String> allWindows = driver.getWindowHandles();
		
		System.out.println(allWindows);
		
		ArrayList <String> child = new ArrayList<>(allWindows);
		driver.switchTo().window(child.get(1));
		driver.close();
		driver.switchTo().window(parent);
		
		driver.switchTo().window(child.get(2));
		driver.close();
		driver.switchTo().window(parent);
		driver.close();
		
		//WebTable.....................................................................................
		
		driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");

		WebElement table = driver.findElement(By.xpath("//*[@id='customers']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement row : rows) {

			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {
				System.out.print(cell.getText() + "\t");
			}

			System.out.println();
		}
		
		//WebTable using XPath.........................................................................
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		for (int i=2; 1<=7; i++){
			for (int j=1; j<=3; j++){
				System.out.print(driver.findElement(By.xpath(".//*[@id='customers']//tr["+i+"]//td["+j+"]")).getText()+"\t");
			}
			System.out.println();
		}
        
        
	}
}
