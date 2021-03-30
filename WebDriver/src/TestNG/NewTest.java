package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
 
/*@BeforeClass
public void login() {
System.out.println("Login successful");
}*/
@Test (priority = 1)
public void addVendor() {
System.out.println("Vendor added");
}
@Test (priority = 2)
public void addProduct() {
System.out.println("Product added");
}
@Test (priority = 3)
public void addCurrency() {
System.out.println("Currency added");
}
/*@AfterClass
public void logout() {
System.out.println("Logout successful");
}*/

}
