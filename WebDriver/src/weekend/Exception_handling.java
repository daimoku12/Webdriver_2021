package weekend;

//Logical error/ Runtime error/ Exception. Code will stop if exception occurs

/*Checked exception - compiler will catch. Eg: File
Unchecked exception - Eg: Arithmetic*/

/*Throws (declare exception) - When method is called, then exception will be handled
throws FileNotFoundException, Arithmetic Exception
throws Exception (Parent Class)*/

//Catch block is mandatory for checked exception. Not mandatory for unchecked

//In case of try and finally - we will get Exception + code in finally will also execute

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exception_handling {
	
	public void getData(int a)
	{
         if(a<10)
	         {
	           throw (new ArithmeticException());  //User defined Exception
	         }
	}

	public static void main(String[] args) {
		
		int i = 0;
		int j = 20;
		int k;
		
		try {
			File f = new File ("C:/Users/Kannu/Downloads/12345.txt");
			FileReader fr = new FileReader(f);
			} 
		
/*		catch (Exception e) {           //If first catch is Exception, then we cannot have multiple catch blocks
			System.out.println("End");  //Exception will handle all exceptions
			}*/
		
		catch (FileNotFoundException e) {
			System.out.println("End");
			}
		
		try {
			k = j/i;
		    }
		
		catch (ArithmeticException e) {
			System.out.println("Hello");
			}
		
		finally{
		    System.out.println("Finally");	
		}

		Exception_handling obj = new Exception_handling();
		obj.getData(12);
		obj.getData(8);
	}		
}

