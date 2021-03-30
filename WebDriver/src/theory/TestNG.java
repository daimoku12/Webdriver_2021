package theory;

/*Source - http://testng.org/doc/documentation-main.html

@BeforeSuite: The annotated method will be run before all tests in this suite have run. 
@AfterSuite: The annotated method will be run after all tests in this suite have run. 
@BeforeTest: The annotated method will be run before any test method belonging to the classes inside the <test> tag is run. 
@AfterTest: The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run. 
@BeforeGroups: The list of groups that this configuration method will run before. This method is guaranteed to run shortly 
before the first test method that belongs to any of these groups is invoked. 
@AfterGroups: The list of groups that this configuration method will run after. This method is guaranteed to run shortly 
after the last test method that belongs to any of these groups is invoked. 
@BeforeClass: The annotated method will be run before the first test method in the current class is invoked. 
@AfterClass: The annotated method will be run after all the test methods in the current class have been run. 
@BeforeMethod: The annotated method will be run before each test method. 
@AfterMethod: The annotated method will be run after each test method.

@DataProvider
Marks a method as supplying data for a test method. The annotated method must return an Object[ ][ ],
where each Object[ ] can be assigned the parameter list of the test method. The @Test method that wants 
to receive data from this DataProvider needs to use a dataProvider name equals to the name of this annotation.

@Factory
Marks a method as a factory that returns objects that will be used by TestNG as Test classes. The method must return Object[ ].

@Listeners
Defines listeners on a test class.

@Parameters
Describes how to pass parameters to a @Test method.

@Test
Marks a class or a method as a part of the test.

...................................................................................................

Parameters associated with @Test

@Test (enabled = false)
@Test (groups = { "functest", "checkintest" })
@Test (expectedExceptions = ArithmeticException.class)
@Test (priority=1, dependsOnMethods = "tcase3", alwaysRun =true)
@Test (priority =3,dependsOnMethods = {"tcase2","tcase1"})
@Test (description = "This is to verify title")
@Test (dependsOnGroups={"",""})
@Test (invocationCount= 10) : The number of times this method should be invoked.

public class ParameterizedTest1 {
   @Test
   @Parameters("myName")
   public void parameterTest(String myName) {
      System.out.println("Parameterized value is : " + myName);
   }
}

<suite name = "Suite1">
   <test name = "test1">
     <parameter name = "myName" value="manisha"/> 
         <classes>
         <class name = "ParameterizedTest1" />
      </classes>
   </test>
</suite>

--Listeners defined on suite level

<listeners>
<listener class-name="listener.TestNGListener" />
</listeners>

--Hard dependencies. All the methods you depend on must have run and succeeded for you to run. 
If at least one failure occurred in your dependencies, you will not be invoked and marked as a SKIP in the report.

--Soft dependencies. You will always be run after the methods you depend on, even if some of them have failed. 
This is useful when you just want to make sure that your test methods are run in a certain order but their success 
doesn't really depend on the success of others. A soft dependency is obtained by adding "alwaysRun=true" in your @Test annotation.

Important

java org.testng.TestNG this class has a main method which is the starting point of TestNG.  
TestNG run is triggered by calling the main method in TestNG.java class 

file: https://github.com/cbeust/testng/blob/master/src/main/java/org/testng/TestNG.java

SO when you do right click >> Menu >> Run As >> TestNG suite. Eclipse actually calls the main method of this class. 
Also, check how the args parameter in the main method are used. This will give you an idea of what parameters you 
can pass to command line while running your tests in TestNG

*/

public class TestNG {

}
