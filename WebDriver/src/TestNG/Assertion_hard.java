package TestNG;

//Assertion fail will give Error not Exception
//Hard Assertion - If Assertion fails, control will out of test case 

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

public class Assertion_hard {

	@Test
	public void tcase1(){
			
	Assert.assertEquals(12, 13,"Expected and Actual does not Match");   //Statement will print only if Assertion fails
	System.out.println("Statement after Assertion fail");               
	}
	
	@Test
	public void tcase3(){
		
	System.setProperty("webdriver.chrome.driver","C:/Users/Kannu/Downloads/Compressed/chromedriver_win32/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.google.com");
	Assert.assertEquals(driver.getTitle(), "Google","Title does not match");
	driver.close();
	}
	
	@Test
	public void tcase2(){
	
	String str = "Kunal Malik";
	Assert.assertTrue(str.contains("bhui"), "Does not match");
	System.out.println("Test Print");
	}	
}