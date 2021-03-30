package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest1 {
	
	@BeforeTest
	public void login() {
	System.out.println("Login successful");
	}
	@Test (priority = 4)
	public void deleteVendor() {
	System.out.println("Vendor deleted");
	}
	@Test (priority = 5)
	public void deleteProduct() {
	System.out.println("Product deleted");
	}
	@Test (priority = 6)
	public void deleteCurrency() {
	System.out.println("Currency deleted");
	}
	@AfterTest
	public void logout() {
	System.out.println("Logout successful");
	}	
}
//If priorities are 1,2 and 3

/*Login successful - before class1
Vendor added     - P1
Login successful - before class2
Vendor deleted   - P1
Product added    - P2
Product deleted  - P2
Currency added   - P3
Logout successful -After class1 
Currency deleted  - P3
Logout successful - After class2*/
