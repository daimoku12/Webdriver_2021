package java_selfstudy;

public class User_Defined_Methods {
	
	
public int add (int a, int b) //Public Method returning an int value 
{
int c = a+b;
return c;
}
	
static int multiply (int c, int d) //Static method - To call this object is not required
{
int e= c*d;
return e;
}

public static void main(String args []) {
	
	User_Defined_Methods obj = new User_Defined_Methods (); 
	int x = obj.add(2, 3); //Public method called using object
	System.out.println(x);
	
	int y = multiply (3,4); //Static method called without creating object
	System.out.println(y);
	int z = User_Defined_Methods.multiply(5, 6); //Static method called without creating an object - using class name
	System.out.println(z);
 }	
}
