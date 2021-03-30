package weekend;

import org.testng.annotations.Test;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// Goto Project (Practice) and Refresh --> test-output --> index.html --> Right Click, select Properties and copy path
// Goto Project --> TestNG --> Convert to TestNG (check the classes names and .xml file) - Multiple can be executed as test suite
// Execute Failed test cases --> Refresh Project - test-output - testing-failed.xml (Run)
// Suite, Test, Class
// Before Suite, Before Test, Before Class, Before Method, Test, After Method, After Class, After Test, After Suite
// Cyclic dependency will throw error - 1 depends on 3 and 3 depends on 1


public class TestNG {
	
	@Test (priority=-1, alwaysRun =true)
	public void tcase1(){
      System.out.println("TC_001");
    }
	
	@Test (priority =2) 
	public void tcase2(){
//	Assert.assertTrue(false,"Anything"); //failed
	  System.out.println("TC_002"); 
    }

	@Test (priority =3,dependsOnMethods = {"tcase2","tcase1"})  // If tcase2/ tcase1 fails, tcase3 will be skipped
	public void tcase3(){
      System.out.println("TC_003");
	}  
	
	@BeforeMethod 
    public void abcd(){
      System.out.println("Browser start");
	}
	
	@AfterMethod (alwaysRun = true)
	public void efgh(){
      System.out.println("Browser close");
    }	
	
	@Test (groups = {"P1","Smoke"}) //group name is user defined
	public void tcase4(){
      System.out.println("P1 or Smoke");
    }
}
