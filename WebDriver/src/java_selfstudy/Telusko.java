package java_selfstudy;

public class Telusko {
	
	public static void main(String[] args) {
		
		//byte(1), short(2), int(4), long(8)
		//float(4), double(8)
		//char
		
		int a = 5_0_0_0;      //starting JDK 1.7
		System.out.println(a);
		
		//naming convention for variables
		
		int _qw;  //underscore
		int $qa;  //dollar
	//	int 1qa;  //error
		int _1a;
		long o = 9000000000l;
		float b = 5.5f;
		
		//Implicit and explicit type casting/ conversion
		
		long c = 100;
		c = a; //int to long - Implicit type casting
		a= (int)c; //long to int - Ex 
		
		//ternary operator (condition?1:2)
		
		int i = 8;    //1000
		int j = 9;    //1001
		
		j=i<6?3:4; //if i<6, j=3 else j=4
		System.out.println(j);  //4
		
		//Bitwise operator
		
		int k = i<<2;
		System.out.println(k);  //32  //100000
		
		k = k>>2;               //8   //1000
		System.out.println(k);
		
		//Swap Strings without using third variable
		
		String A = "Hello";
		String B = "World";
		
		A=A+B;
		B=A.substring(0,A.length()-B.length());
		System.out.println(B);
		
		A=A.substring(B.length());
		System.out.println(A);
		
	}

}
