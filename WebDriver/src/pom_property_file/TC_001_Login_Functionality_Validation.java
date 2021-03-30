package pom_property_file;

import org.testng.annotations.Test;

/**
 * Test case to validate login functionality
 * Name: Kunal Malik
 * Date: 10/16/2017
 */

public class TC_001_Login_Functionality_Validation extends CreateDriver{
	
	@Test
	public void tcase1(){
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername("Hello");
		login.enterPassword("Hello");
		login.clickSignin();
		
	}
}
