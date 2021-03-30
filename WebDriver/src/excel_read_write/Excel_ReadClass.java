package excel_read_write;

// XSSF (for .xlsx), HSSF (for .xls)

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_ReadClass {
	
public static void main(String[] args) throws IOException{
	
FileInputStream fis = new FileInputStream("C:/Users/Kannu/Downloads/1.xlsx");

XSSFWorkbook wb = new XSSFWorkbook(fis);
XSSFSheet sheet1 = wb.getSheet("Sheet1");                             //Pass sheet using name
XSSFRow row1 = sheet1.getRow(0);
//XSSFCell cell1 = row1.getCell(0);


//XSSFSheet sheet2 = wb.getSheetAt(1);                                  //Pass sheet using index
//System.out.println(sheet2.getRow(0).getCell(0).getStringCellValue()); //kunal


//int a = sheet1.getPhysicalNumberOfRows();
//int b = row1.getPhysicalNumberOfCells();

//System.out.println(a + " " + b); // 7 2


/*for (int i=0; i<sheet1.getPhysicalNumberOfRows(); i++){
	
	XSSFRow row1 = sheet1.getRow(i);
	
      for (int j=0; j<row1.getPhysicalNumberOfCells(); j++){
    	  
    	  XSSFCell cell1= row1.getCell(j);
    	  System.out.println(cell1.getStringCellValue());
    	  
         }
	   }*/

for (int i=0; i<sheet1.getPhysicalNumberOfRows(); i++){
	
      for (int j=0; j<row1.getPhysicalNumberOfCells(); j++){
    	  
    	  System.out.print(sheet1.getRow(i).getCell(j).getStringCellValue());  //Try getNumericCellValue
    	  
         }
      
      System.out.println();
      
	   }
 wb.close();
  }		
}
