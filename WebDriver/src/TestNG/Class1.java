package TestNG;

/*Select Project/Package>Right Click>New>Others>Enter"TestNG">Select "TestNG Class"

>Enter Source and Package names
>Enter Class name
>xml suite file - provide a name*/

//Run >Run Configutaions >TestNG >Suite >testng.xml

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Class1 {

@Test (description = "This is to verify title")
public void verifyTitle(){

System.setProperty("webdriver.chrome.driver","C:/Users/Kannu/Downloads/Compressed/chromedriver_win32/chromedriver.exe");
ChromeDriver driver = new ChromeDriver();
driver.get("https://www.google.com");
Assert.assertEquals(driver.getTitle(), "Google");
driver.close();
}
}
