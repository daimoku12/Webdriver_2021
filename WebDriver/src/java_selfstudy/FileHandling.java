package java_selfstudy;

import java.io.File;
import java.io.IOException;

public class FileHandling {

public static void main(String[] args) throws IOException {

	File f = new File ("C:/Users/Kannu/Desktop/Selenium"); //Create object of 'File' class
	f.mkdir(); //Create folder
	
	if (f.exists()== true){  //Check existence of a File/ Folder
	System.out.println("Folder exists");	
	}
	else{
	System.out.println("No Folder");	
	}
	
	f.delete(); //Delete a folder
	
	if (f.exists()== true){  //Check existence of a File/ Folder
		System.out.println("Folder exists");	
		}
		else{
		System.out.println("No Folder");	
		}
	
	File f1 = new File ("C:/Users/Kannu/Desktop/Selenium.txt");
	
	f1.createNewFile(); //Create text file
	f1.delete(); //Delete text file
	
 }	
}
