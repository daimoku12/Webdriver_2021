package weekend;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnit {
	
// JUnit 4 - Test cases can be executed without Main
// @ Annotation
// Order of search - @Test-->@Before-->@After
// Execution Order - @Before-->@Test-->@Order
// Before and After will execute after each test case
// If there is no @Test, Before and After will not execute
// Test cases/ BeforClass and AfterClass will be executed based on sorting
// @Ignore - Test case will not be executed	
// @AfterClass and @BeforeClass - Will only be executed once irrespective of total number of test cases. Methods will be 'static' 	
	
	@Test 
	public void tcase1(){
      System.out.println("TC_001");
    }
	
	@Test
	//@Ignore
	public void tcase2(){
      System.out.println("TC_002");
    }

	@BeforeClass 
    public static void abc(){
      System.out.println("Browser start");
	}
	
	@AfterClass
	public static void def(){
      System.out.println("Browser close");
    }
	
/*	@AfterClass
	public static void xyz(){
      System.out.println("DB Connection close");
	}*/
      
	@Before 
    public void abcd(){
      System.out.println("Browser start");
	}
	
	@After
	public void efgh(){
      System.out.println("Browser close");
    }

/*	Output if no comments in code
    
Browser start    BeforeClass
Browser start    Before
TC_001           TC
Browser close    After
Browser start    Before
TC_002           TC
Browser close    After
Browser close	 AfterClass   */
	
}
