package java_selfstudy;

/*Calling 'add' method from class 'P_User_Defined_Methods'. Create object in this class and then call the method 'add'. 
Methods within class can be used in other classes within the same package*/

/*class A {

public void subtract (int a, int b){
int c= a-b;
System.out.println(c);
}
}*/
	
public class User_Defined_Methods1 {

	public static void main(String[] args) {
		
		User_Defined_Methods obj = new User_Defined_Methods (); //object created for previous class
		int x = obj.add(2, 3); 
		System.out.println(x);
		
/*		A obja = new A();
		obja.subtract(5, 3);*/
		
	}
}
