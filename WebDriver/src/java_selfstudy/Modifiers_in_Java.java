package java_selfstudy; // Project-->Package-->Class

public class Modifiers_in_Java {
	
	static int a=100;              // class level variable
	
	public int salary(){           // Create Method
	
		int mysalary = 12000+1500; // mysalary is local variable
		return mysalary;
	}
                
	public static void main (String Args []){
		
/* main - Starting place for program
 
 Keyword 'Static' allows main () to be called without without having to instantiate a particular instance of the class. This is necessary as main ()
 is called by JVM before any objects are made */		
	
		int b = 200;               // Instance variable
	    System.out.println(a);     // 100
	    System.out.println(b);     // 200
	    
	    //  System.out.println(mysalary); - mysalary is local. Cannot be used outside
	    
	    Modifiers_in_Java obj = new Modifiers_in_Java (); // create object of a class
		System.out.println(obj.salary()); // 13500
		
		for (int i=1;i<=5; i++)
			System.out.println(i);
		    System.out.println(b);  // 200
	
	int c=10, d=20;
	System.out.println(c>d); // false (Relational operator)
		    
	}	
}
