package java_selfstudy;

/*import java.util.Scanner;*/

/* Arithmetic Exception - Eg. num/0
Null Pointer Exception - Eg. String s = ""; Print (s.length)
Number Format Exception - Only integers can be converted to String
ArrayIndexOutOfBounds

*/

public class ExceptionHandling {
	
	public static void main(String[] args) {
	
/*	Scanner s = new Scanner(System.in);
	
	System.out.println("Read two numbers:");
	
	String S1 = s.nextLine();
	String S2 = s.nextLine();
	
	int c = Integer.parseInt(S1); //Convert String to integer
	int d = Integer.parseInt(S2);
	
	System.out.println(c+d);
	
	System.out.println(S1+S2);
	
	s.close();*/

    int a = 10;
    int b = 0;
    
 // Without Exception handling 
    
/*  int result = a/b;
    System.out.println(result);
    System.out.println("Hello");*/
		
// With Exception handling
    
   try{
	  int result = a/b;
	System.out.println(result);
	System.out.println("Bye");
	  }
   
   catch (ArithmeticException e){  //ArithmeticException 'any name'
	 System.out.println("Displaying inspite of Arithmetic exception");  
      }

   System.out.println("That is insanity");

   int A [] = new int [4];
   
   try{
	   System.out.println(A[6]);
	  }
   
   catch (ArrayIndexOutOfBoundsException e1){ //ArrayIndexOutOfBoundsException 'any name'
	
	   System.out.println("Displaying inspite of ArrayIndexOutOfBounds exception");   
      }
 }
}
