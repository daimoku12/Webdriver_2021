package inhetitance;

public class Test2 extends Test1
{
	int d = 200;
	int temp;
	
	static
	{
	  System.out.println("hello static");
	}
	
	Test2(int a)
	{
	  this();		
	  System.out.println("Parametrized constructor");
	}
	
	Test2(String b)
	{
	  System.out.println(b);	
	}
	
	Test2()
	{
	  super();
	  System.out.println("Test2 Constructor");
	  System.out.println(super.d);
	  System.out.println(d);
	  super.justLikeThat();
	  System.out.println(this.d);
	  this.justLikeThat();
	}
	
	public void justLikeThat()
	{
	  System.out.println("Hello there from Test2");
	}
	

	public static void main(String[] args)
	{
	  Test2 obj = new Test2();
	  Test2 obj1 = new Test2(10);
	  Test2 obj2 = new Test2("Hello hello");
	}
}
