package java_selfstudy;
/* Data types

Integers - byte (8-bit), short(16), int(32), long(64)
Floating - float(32), double(64)
Character - Char(16). Range: 0 to 65536. Java uses 'Unicode' to represent characters 
Boolean */

public class String_Handling {
   public static void main (String [] args){
	    
	 char char1, char2;
	 char1 = 88;
	 char2 = 'Y';	 
	 System.out.println(char1+char2);// 177
	 System.out.println(char1 + " " + char2);// X Y	 
	   
// String Concatenation	
// String + String = Concatenation, String + Integer = Concatenation 	 
	   
	String str1 = "Sele";
	String str2 = "nium";
	System.out.println(str1+str2); //Selenium     
	System.out.println(1+str1+str2); //1Selenium
	System.out.println(str1+str2+1+1); //Selenium11
	System.out.println(1+1+str1+str2); //2Selenium
	System.out.println(1+" "+1+str1+str2); //1 1Selenium
	System.out.println(" "+str1+str2); // Selenium
	
/* String comparison is of two types:
 - 2 way comparison (true/false)
 - 3 way comparison (<0,0,>0) */
	
// String comparison using (==) Relational comparison (2 way comparison)	
	
   String str3 = "selenium";
   String str4 = "SELENIUM";
   String str5 = "SELENIUM";
   String str6 = "zselenium";
   
   System.out.println(str3 == str4);  //false
   System.out.println(str4 == str5);  //true
   	
// String comparison using 'equals()' method (2 way comparison)
   
   if (str3.equals(str4)==false)
	   System.out.println("Strings are different"); //Strings are different
   
   System.out.println(str3.equals(str4)); //false
	
// String comparison using 'compareTo()' method (3 way comparison)	
	
   System.out.println(str3.compareTo(str4)); //32 (greater than 0)
   System.out.println(str4.compareTo(str5)); //0 (equal to 0)
   System.out.println(str3.compareTo(str6)); //-7 (less than 0)
   
/* ASCII values
   A to Z (65 to 90)
   a to z (97 to 122)
   0 to 9 (48 to 57)  */ 	
 }
}