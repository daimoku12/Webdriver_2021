package webdriver_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*An HTML table is defined with the <table> tag.

Each table row is defined with the <tr> tag. A table header is defined with the <th> tag. 
By default, table headings are bold and centered. A table data/cell is defined with the <td> tag*/

public class WebTable {

	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver", "./Driver_Exe/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
//	driver.manage().window().maximize();
		
	WebElement Table = driver.findElementByXPath("//div[@class='w3-white w3-padding notranslate']");
	
	List <WebElement> rows = Table.findElements(By.tagName("tr"));
	int rowcount = rows.size();
	System.out.println(rowcount);  //7
	
	List <WebElement> cells = Table.findElements(By.tagName("td"));
	int cellcount = cells.size();
	System.out.println(cellcount); //18
		
	List <WebElement> cc = Table.findElements(By.tagName("th"));
	int columncount = cc.size();
	System.out.println(columncount); //3
	
	for (WebElement row : rows){
	  List<WebElement> cols = row.findElements(By.tagName("td"));
		for (WebElement col : cols){
		   System.out.print(col.getText() + "\t");
		}
      System.out.println();
    }
	
    for (int i =2;i<=rows.size();i++){
		for (int j=1; j<=cc.size();j++){
			System.out.print(driver.findElementByXPath(".//*[@id='customers']/tbody//tr["+i+"]//td["+j+"]").getText());
		      }
	  System.out.println();
	  }	
 }	
}
