package excel_read_write;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_WriteClass {
	
public static void main(String[] args) throws IOException {
	
FileOutputStream file1 = new FileOutputStream("C:/Users/Kannu/Downloads/3.xlsx");	
XSSFWorkbook wb = new XSSFWorkbook ();
XSSFSheet sheet = wb.createSheet("Sheet1");
XSSFRow row = sheet.createRow(0);
XSSFCell cell = row.createCell(0);	

sheet.createRow(0).createCell(0).setCellValue("Hello");
sheet.getRow(0).createCell(1).setCellValue("Bye");      //Row 0 is already created, so use getRow
wb.write(file1);
wb.close();

 }	
}
