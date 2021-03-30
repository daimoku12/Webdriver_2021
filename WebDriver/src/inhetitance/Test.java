package inhetitance;

public class Test 
{
	public static int c =10;
	public final int d = 1000;
	
	int x;
	
	Test()
	{
	  System.out.println("Test Constructor");
	}
	
	private void one()
	{
	  System.out.println("Shuld not be ingerited");
	}
	
	public final void two()
	{
	  System.out.println("Should be inherited");
	}
	
	public void justLikeThat()
	{
	  System.out.println("Hello there from Test");
	}	
	
	public void justLikeThat(int a)
	{
	  System.out.println("Hello there from Test");
	}
}
