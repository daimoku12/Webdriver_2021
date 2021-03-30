package java_selfstudy;

public class Practice {
	
	Practice(){
		System.out.println("A");
	}
	
	public void add(){
		System.out.println("addition");
	}
	
	public static void main(String[] args) {

		
		System.out.println("a");
		System.out.println("b");
		
	}

}

/*Error: Main method must return a value of type void in class java_selfstudy.Practice, please 
define the main method as:
   public static void main(String[] args)*/

/*Error: Main method is not static in class java_selfstudy.Practice, please define the main method as:
	   public static void main(String[] args)*/

/*Main can be Final. But, the sub class cannot have a main method*/ 

