package webdriver_practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven_TextFile {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		
		FileReader file = new FileReader ("C:\\Users\\Kannu\\Downloads\\TestData.txt");
		BufferedReader br = new BufferedReader(file);
		String line = br.readLine();
		
		while (line!=null)
		{
			String [] A = line.split(",", 2);
			line = br.readLine();
			
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://www.gcrit.com/build3/admin");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			driver.findElementByName("username").sendKeys(A[0]);
			Thread.sleep(3000);
			driver.findElementByName("password").sendKeys(A[1]);
			Thread.sleep(3000);
			driver.findElementByXPath(".//*[@id='tdb1']");
			driver.close();
		}	
	br.close();	
  }
}
