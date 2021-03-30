package webdriver_practice;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail_Compose {
	
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.navigate().to("https://gmail.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	String password = "SGFyaW9tMTI=";
	
	driver.findElementByXPath("//input[@id='identifierId']").sendKeys("kunalkicks");     //username
	driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();              //next
	driver.findElementByName("password").sendKeys(Decode(password));                     //password
	Thread.sleep(2000);
	driver.findElementByXPath("//span[@class='RveJvd snByac']").click();                 //next
	driver.findElementByXPath("//div[@class='T-I J-J5-Ji T-I-KE L3']").click();          //compose
	Thread.sleep(2000);
	driver.findElementByXPath(".//*[@id=':8a']").sendKeys("smita.smi@gmail.com");        //To
	driver.findElementByXPath("//input[@id=':7t']").sendKeys("Automated");               //Subject
	driver.findElementByXPath(".//*[@id=':8u']").sendKeys("Sent from Automation Script");//Body
	driver.findElementByXPath(".//*[@id=':7j']").click();                                //Send
	
	driver.close();
  }
	
	public static String Decode(String password1){
		
		byte[] decode = Base64.decodeBase64(password1);
		return new String (decode);
	}
}
