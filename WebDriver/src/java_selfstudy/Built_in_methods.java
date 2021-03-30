package java_selfstudy;

import java.util.Arrays;

public class Built_in_methods {

	public static void main(String[] args) {
		
// String Methods................................................................................................. 
		
    String S1 = "selenium";
	String S2 = "Selenium";
	String S3 = "          Hello         ";
	String S4 = "Hello Child";
	
	System.out.println(S1.compareTo(S2));             //32
	System.out.println(S1.equals(S2));                //False
	System.out.println(S1.equalsIgnoreCase(S2));      //True
	System.out.println(S1.concat(S2));                //seleniumSelenium
	System.out.println(S1 + S2);                      //seleniumSelenium
	System.out.println(S1.charAt(1));                 //e
	System.out.println(S1.toUpperCase());             //SELENIUM
	System.out.println(S2.toLowerCase());             //selenium
	char A [] = S1.toCharArray();                     //Convert String to Character Array 
	System.out.println(A[3]);                         //e
	System.out.println(S3.trim());                    //Trim (removes spaces from start and end) Hello
	System.out.println(S1.substring(2));              //lenium
	System.out.println(S1.substring(2, 4));           //le
	System.out.println(S4.endsWith("Child"));         //True
	System.out.println(S3.length());                  //24 (no index concept)
	System.out.println(S4.startsWith("Hello"));       //true
	System.out.println(S3.replace(" ", ""));          //Hello
	
	StringBuffer s = new StringBuffer ("abcde");
	System.out.println(s.reverse());                  //edcba
	
	String S5 = "My Name is Kunal";
	String Arr [] = S5.split(" ");                    //Split can be done based on ' ' or '$' etc
	System.out.println(Arr.length);                   //4
	
	for (String h : Arr){
	System.out.print(h);                              //MyNameisKunal	
	}
	
	System.out.println();
	
	String S6 = "Testing";
	System.out.println(S6.hashCode());
	S6 = "Java";                                      //String is Immutable - When value of String is changed, new object is created
	System.out.println(S6.hashCode());
		
	
// Number Methods.................................................................................................	

/*Integer class wraps a value of primitive data type int in an object	
An object of type Integer contains a single field of type int*/

	Integer a = 5, b=6;
	
	System.out.println(a.compareTo(5));               //0
	System.out.println(a.compareTo(6));               //-1
	System.out.println(a.compareTo(4));               //1
	
	System.out.println(a.equals(5));                  //true
	System.out.println(a.equals(b));                  //false
	
	double c = 10.234;
	double d = -10.786;
	double e = 10.51;

// Math is a class in java.lang. Method 'abs, round, min, max' are called using Class 'Math' as these methods are static 
	
	System.out.println(Math.abs(c));                  //Math.abs (returns absolute value - positive) 10.234
	System.out.println(Math.abs(d));                  //10.786
	
	System.out.println(Math.round(c));                //10
	System.out.println(Math.round(d));                //-11
	System.out.println(Math.round(e));                //11
	
	System.out.println(Math.min(c, d));               //Min value between two numbers (-10.786)
	System.out.println(Math.max(c, d));               //Max value between two numbers (10.234)
	System.out.println(Math.max(23, 101));            //101
	System.out.println(Math.random());                //Generates random number
	
	int num = 12345;
	System.out.println(Integer.toBinaryString(num));  //11000000111001
	
	
// Character Methods..............................................................................................................	

char x = 'A';
char y = '1';
Character z = 'B';

System.out.println(Character.isLetter(x));            //Checks whether value is alphabet or not - true
System.out.println(Character.isLetter(y));            //false
System.out.println(Character.isLetter(z));            //true
System.out.println(Character.isLetter('1'));          //false
System.out.println(Character.isLetter('*'));          //false

/* According to the API docs, isLetter() returns true if the character has any of the following general category types: 
UPPERCASE_LETTER (Lu), LOWERCASE_LETTER (Ll), TITLECASE_LETTER (Lt), MODIFIER_LETTER (Lm), OTHER_LETTER (Lo). 
If we compare isAlphabetic(), it has the same but adds LETTER_NUMBER (Nl), and also any characters having Other_Alphabetic property */

System.out.println(Character.isAlphabetic(x));        //true
System.out.println(Character.isAlphabetic('%'));      //false

System.out.println(Character.isDigit(x));             //checks whether value is a digit or not - false
System.out.println(Character.isDigit(y));             //true

System.out.println(Character.isUpperCase(x));         //true
System.out.println(Character.isUpperCase(y));         //false

System.out.println(Character.isLowerCase(x));         //false
System.out.println(Character.isLowerCase(x));         //false

// Array Methods.......................................................................................................................

int [] Z = {10,20,30,40};

System.out.println(Z.length);                         //length is property not method - 4

String [] X = {"Selenium","UFT"};
String Str = Arrays.toString(X);                      //'toString' prints an array // 'Arrays' is Class here 
System.out.println(Str);                              //[Selenium, UFT]

boolean aa = Arrays.asList(X).contains("UFT");        //'asList' is property
boolean bb = Arrays.asList(X).contains("Java");

System.out.println(aa);                               //true
System.out.println(bb);                               //false

/*object.method
  class.method
  class/object.property.method*/
 }
}
