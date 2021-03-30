package excel_read_write;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead_Refined {
	
	
	public static void main(String[] args) throws IOException {
		
	FileInputStream file = new FileInputStream("C:/Users/Kannu/Downloads/1.xlsx");
	
	XSSFWorkbook wb = new XSSFWorkbook(file);
	XSSFSheet sh = wb.getSheet("Sheet1");
	XSSFRow row = sh.getRow(0);
//	XSSFCell cell = row.getCell(0);
		
	for (int i=0; i<sh.getPhysicalNumberOfRows();i++){
		for (int j=0; j<row.getPhysicalNumberOfCells();j++){
			System.out.print(sh.getRow(i).getCell(j).getStringCellValue());
			
		}
		System.out.println();
	}	
	
	wb.close();
	file.close();
	
/*	FileOutputStream file1 = new FileOutputStream("C:/Users/Kannu/Downloads/1.xlsx");
	sh.getRow(0).createCell(2).setCellValue("New Value");
	wb.write(file1);
	wb.close();*/
	
 }
}
