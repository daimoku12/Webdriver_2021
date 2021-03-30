package webdriver_practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import library.Utility;

public class Highlight_Element {
 
public static void main(String []args){
 
	System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
    driver.get("http://www.facebook.com");
 
    WebElement username= driver.findElementById("email"); 
    username.sendKeys("hello");
    highLightElement(driver,username);
    Utility.captureScreenShot(driver);
 }
 
public static void highLightElement(WebDriver driver, WebElement element)
{
    JavascriptExecutor js=(JavascriptExecutor)driver; 
    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
 
    try 
      {
       Thread.sleep(3000);
      } 
    catch (InterruptedException e) {
       System.out.println(e.getMessage());
      } 
 js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
 
}
}