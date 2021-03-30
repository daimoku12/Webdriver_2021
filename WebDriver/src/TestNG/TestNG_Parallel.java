package TestNG;

import org.testng.annotations.Test;

public class TestNG_Parallel {

	@Test
	public void testCase1(){
	long id = Thread.currentThread().getId();
	System.out.println("test case 1: " + "Thread count: "+id);
	}
	
	@Test
	public void testCase2(){
	long id = Thread.currentThread().getId();
	System.out.println("test case 2: " + "Thread count: "+id);
	}
	
	@Test
	public void testCase3(){
	long id = Thread.currentThread().getId();
	System.out.println("test case 3: " + "Thread count: "+id);
	}
	
	@Test
	public void testCase4(){
	long id = Thread.currentThread().getId();
	System.out.println("test case 4: " + "Thread count: "+id);
	}
	
}
