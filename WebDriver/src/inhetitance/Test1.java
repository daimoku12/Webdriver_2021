package inhetitance;

public class Test1 extends Test
{
	int d = 100;
	
	Test1() //try private here
	{
	  System.out.println("Test1 Constructor");
	}
	
	public void justLikeThat()
	{
		System.out.println("Hello there from Test1");
	}
	
	public static void main(String[] args) 
	
	{
      Test1 a = new Test1();
      a.two();
      System.out.println(a.c);
      System.out.println(a.d);
      System.out.println(c);
      System.out.println(Test.c);
	}

}
