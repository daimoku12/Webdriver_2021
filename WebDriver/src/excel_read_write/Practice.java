package excel_read_write;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
	
	public static String initialise (WebDriver driver, String sheetName, int rowNum, int cellNum) throws Exception{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Kannu\\Desktop\\1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("sheet1");
		XSSFRow row = sh.getRow(0);
		return sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		}
	
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		driver.findElementById("email").sendKeys(initialise(driver, "sheet1", 0, 0));
		driver.findElementById("pass").sendKeys(initialise(driver, "sheet1", 0, 1));
		
	}
}
