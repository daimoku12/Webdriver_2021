package TestNG;

import org.testng.annotations.Test;

public class Grouping_Methods {

	@Test (groups = {"sanity","regression"}, priority=1, description = "Hello, this is test case one")
	public void login() {
	System.out.println("Login");
	}
	@Test (groups = {"sanity","regression"}, priority=6)
	public void logout() {
	System.out.println("Logout");
	}
	@Test (groups = {"sanity"}, priority=2)
	public void search() {
	System.out.println("Search");
	}	
	@Test (groups = {"regression"}, priority=3)
	public void advancedSearch() {
	System.out.println("Advanced Search");
	}	
	@Test (groups = {"regression"}, priority=4)
	public void createProfile() {
	System.out.println("Profile created");
	}	
	@Test (groups = {"sanity","regression"}, priority=5)
	public void deleteProfile() {
	System.out.println("Profile deleted");
	}
	
	
}
