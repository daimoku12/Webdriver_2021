package java_selfstudy;

public class Parameterized_Constructor {

	int c;	
	
	Parameterized_Constructor(int a, int b){
	c = a+b;
	System.out.println(c);
	}

	public static void main(String[] args) {
		
	Parameterized_Constructor obj = new Parameterized_Constructor(1,2);
	Parameterized_Constructor obj1 = new Parameterized_Constructor(4,5);
}
}