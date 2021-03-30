package TestNG;

//Soft Assertion - If Assertion fails, execution will not stop but test will fail


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_soft {

	@Test
	public void tcase1(){
			
	SoftAssert sa = new SoftAssert();	
	
	System.out.println("Test case 1 started");
	sa.assertEquals(13, 13,"Expected and Actual does not match");
	System.out.println("Test case 2 complete");
	
	System.out.println("Test case 2 started");
	sa.assertEquals(11, 13,"Expected and Actual does not match");
	System.out.println("Test case 2 complete");
	
	sa.assertAll(); //Must to execute assert statement
	}
	
}
