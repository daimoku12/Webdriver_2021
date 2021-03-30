package weekend;

// We can call Static members directly by the class name or just by method name
// static variable will be allocated single memory which will be accessed by all objects
// static method can only access Static members
// static block will be executed when class is loaded in memory 

public class Static_Practice {

	static void hello(){
	System.out.println("hello");	
	}

	int i;
	static int j;   // try without static
	
	int z;
	
	static 
	{
		System.out.println("Static Block");
	}
	
	Static_Practice (){      // constructor
		
		System.out.println("Constructor");
	}
	
public static void main(String[] args) {
	
	Static_Practice.hello();	// Static method called without object
    
	Static_Practice obj1 = new Static_Practice();
	Static_Practice obj2 = new Static_Practice();

	obj1.j = 100;
	obj2.j = 10;
	
	System.out.println(obj2.j);    //100
	System.out.println(obj1.j+obj2.j); //20 very important
	
//	System.out.println(z);         //Error (Static method can only access Static members)
	
/*	Static Block
	hello
	Constructor
	Constructor
	100*/
	
  }
}
