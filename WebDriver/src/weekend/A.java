package weekend;

// Open Class B and Class C

public class A {

	public static void main(String[] args) {
		
	   B object = new B();
	   C x = object.hello(); // Class C object created
       x.cmethod(); //Class C method
 }
}
