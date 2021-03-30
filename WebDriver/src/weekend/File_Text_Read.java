package weekend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class File_Text_Read {

public static void main(String[] args) throws IOException {

                                                               // File f = new File ("C:\\Users\\Kannu\\Desktop\\12.txt");		
File f = new File ("C:/Users/Kannu/Downloads/12.txt");		

FileReader fr = new FileReader(f);

/*int r = fr.read();                                             //reads only one character and returns its ASCII value

while (r!=-1){

	//System.out.println(r);
	System.out.print((char)r);                                //Convert to Char
	r = fr.read();
}*/

BufferedReader br = new BufferedReader(fr);
String s1 = br.readLine();

//System.out.println(s1);

while (s1!=null){

System.out.println(s1);
s1 = br.readLine();	
}

br.close();
 }
}
