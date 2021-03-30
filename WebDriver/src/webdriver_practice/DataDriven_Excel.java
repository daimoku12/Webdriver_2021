package webdriver_practice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven_Excel {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
		
    FileInputStream file = new FileInputStream("C:\\Users\\Kannu\\Downloads\\TestData.xlsx");		
	
	XSSFWorkbook wb = new XSSFWorkbook(file);
	XSSFSheet sheet = wb.getSheet("Sheet1");
	XSSFRow row = sheet.getRow(0);
	
	//System.out.println(sheet.getPhysicalNumberOfRows()); //3
	//System.out.println(row.getPhysicalNumberOfCells());  //2
	
	for (int i=0; i<sheet.getPhysicalNumberOfRows(); i++)
	{	
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.gcrit.com/build3/admin");
		driver.manage().window().maximize();
		
		for (int j=0; j<row.getPhysicalNumberOfCells();j++)
		{
			
			String str = sheet.getRow(i).getCell(j).getStringCellValue();
			
			if (j==0){
				driver.findElementByName("username").sendKeys(str);
				Thread.sleep(5000);
			}
			if (j==1){
				driver.findElementByName("password").sendKeys(str);
				Thread.sleep(5000);
			}	
		}
		driver.findElementByXPath(".//*[@id='tdb1']").click();
		driver.close();
	}	
	wb.close();
 }
}
