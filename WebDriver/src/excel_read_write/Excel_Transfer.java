package excel_read_write;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Transfer {
	
public static void main(String[] args) throws IOException {
	
FileInputStream file1 = new FileInputStream("C:/Users/Kannu/Downloads/1.xlsx"); 
XSSFWorkbook wb1 = new XSSFWorkbook(file1); 	
XSSFSheet sheet1 = wb1.getSheet("Sheet1");	
XSSFRow row1 = sheet1.getRow(0);
//XSSFCell cell1 = row1.getCell(0);
	
FileOutputStream file2 = new FileOutputStream ("C:/Users/Kannu/Downloads/New.xlsx");
XSSFWorkbook wb2 = new XSSFWorkbook();
XSSFSheet sheet2 = wb2.createSheet("Sheet1");
XSSFRow row2 = sheet2.createRow(0);
//XSSFCell cell2 = row2.createCell(0);

for (int i=0; i<sheet1.getPhysicalNumberOfRows();i++){
	
	sheet2.createRow(i);
	
	for (int j=0; j<row1.getPhysicalNumberOfCells();j++){
		
		String str = sheet1.getRow(i).getCell(j).getStringCellValue();
		sheet2.getRow(i).createCell(j).setCellValue(str);	
	    }
     }
  wb2.write(file2);
  wb2.close();
  wb1.close();
 }	
}
