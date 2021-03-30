package TestNG;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;

public class Runner {
	
	public static void main(String[] args) {

		//Program to run failed test cases
		
		TestNG runner = new TestNG();

		List <String> list = new ArrayList<>();
		list.add(System.getProperty("user.dir")+"/test-output/testng-failed.xml");
        
		runner.setTestSuites(list);
		runner.run();
		
	}
}
