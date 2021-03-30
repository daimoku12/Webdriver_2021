package weekend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class File_Text_Write {

public static void main(String[] args) throws IOException {

	
	File f = new File ("C:/Users/Kannu/Desktop/11.txt");    //File will be created if not present
	
//	FileWriter fw = new FileWriter(f);                      //Data in the file will be overridden every time 
/*	fw.write("Hello");
	fw.flush();                                             //Save
	fw.close();*/

	FileWriter fw = new FileWriter(f,true);                 //Append mode	
	
	BufferedWriter bw = new BufferedWriter(fw);
	bw.write("First Statement");
	bw.newLine();
//	bw.close();                                             //Error  
	bw.write("Second Statement");
	bw.close();
	
	
 }
}
