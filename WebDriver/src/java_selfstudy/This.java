package java_selfstudy;

import javax.sound.sampled.SourceDataLine;

public class This {
	
	This()
	{
	  System.out.println("hello a");
	}  

	This(int x)
	{  	
	  this();  //should be the first statement	
	  System.out.println(x);  
	}
	
	public void thisFunction()
	{
      System.out.println("hello");		
	}
	
	public void thisFunction2()
	{
	  this.thisFunction();
	}

	public static void main(String args[]){  
		
	This a=new This(10);
	a.thisFunction2();
   }
}  


