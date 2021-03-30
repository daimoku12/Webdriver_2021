package java_selfstudy;

import java.util.Scanner;

public class IO {

public static void main (String [] args){	
	
	Scanner scan = new Scanner (System.in); //system.in is a stream
	
//If syso statement is not mentioned, dialog box will not open asking for input. Syso is mandatory for taking input from user
	
	System.out.println("enter a name"); 
	String a = scan.nextLine();
	System.out.println(a);


	System.out.println("Enter your phone number");
	long num = scan.nextLong();
	System.out.println(num);
	
	System.out.println("Enter a decimal value");
    double num1 = scan.nextDouble();
    System.out.println(num1);
    
    System.out.println("Enter a character");
    char b = scan.next().charAt(1); //scan.next().
    System.out.println(b);
    
    System.out.println("Enter True or False");
    boolean x = scan.nextBoolean();
    System.out.println(x);
    
    scan.close(); //To release the memory.
    
	
 }
}