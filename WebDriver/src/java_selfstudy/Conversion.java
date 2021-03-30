package java_selfstudy;

public class Conversion {
	
	public static void main(String[] args) {
		
		int i;
		String s="100";
		i=Integer.parseInt(s);     //convert to int
		System.out.println(i+10);  //110

		double j = 10.23;
		String a;
		a=String.valueOf(j);       //convert to string
		System.out.println(a);     //10.23
		
		Float k;
		String s1="100.34";
		k=Float.parseFloat(s1);    //convert to float
		System.out.println(k+10);  //110.34
		
		//int=short (implicit Type casting) - Small assigned to big
		//Explicit (Big to small. EX: int to short)
		
		int x = 100;
		short y = 10;
		
		x=y;
		System.out.println(x);    //10 - Implicit
		
		y=(short)x;
		System.out.println(y);    //10 - Explicit
	}

}
