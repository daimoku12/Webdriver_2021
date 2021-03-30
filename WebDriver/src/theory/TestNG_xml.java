package theory;

//Project>Right-CLick>Create SourceFolder>src/main/resources>create file>testng.xml
//Tip - (create multiple files for different purpose)
//to run a testMethod > right click > Run as TestNG
//TestNG logs - "Reporter.log"

/*parallel="methods": TestNG will run all your test methods in separate threads. 
Dependent methods will also run in separate threads but they will respect the order that you specified.

parallel="tests": TestNG will run all the methods in the same tag in the same thread, but each tag will be in a separate thread.
This allows you to group all your classes that are not thread safe in the same and guarantee they will all run in the same thread
while taking advantage of TestNG using as many threads as possible to run your tests.

parallel="classes": TestNG will run all the methods in the same class in the same thread, but each class will be run in a separate thread.

parallel="instances": TestNG will run all the methods in the same instance in the same thread, 
but two methods on two different instances will be running in different threads.*/

//xml for parallel testing (classes in sequential order)......................................................

/*<suite name="Suite">
<test name="Test" parallel="classes"> //append and try - thread-count='2'>, parallel = "methods"
<classes>
     <class name="TestNG.NewTest"> </class>
</classes>
</test>
<test name="Test 1" parallel="classes">
<classes>
     <class name="TestNG.NewTest1"> </class>
</classes>
</test>
</suite>*/

//xml for executing multiple classes.......................................................

/*<suite name="Suite" parallel = "false">
<test name="Test">
  <classes>
    <class name="TestNG.NewTest"/>
    <class name="TestNG.NewTest1"/>
  </classes>
</test> <!-- Test -->
</suite> <!-- Suite -->*/

//xml for grouping test cases...........................................................

/*<suite name="Suite" parallel = "false">
<test name="Test">
<groups>
<run>
<include name ="sanity"/>
</run>
</groups>
  <classes>
    <class name="TestNG_grouping.Grouping_Methods"/>
  </classes>
</test> <!-- Test -->
</suite> <!-- Suite -->*/

//xml for parallel testing (methods)......(in case of classes add another class)........

/*<suite name="Suite">
<test name="Test" parallel="methods" thread-count='4'>
 <classes>
  <class name="TestNG_parallel.TestNG_Parallel"> </class>
 </classes>
</test>
</suite>*/

//XML for cross browser testing (using paramerts)

/*<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite">

<test name="Test" parallel="none">
<parameter name="browser" value="chrome"/>
 <classes>
  <class name="TestNG.Cross_Browser"/>
 </classes>
</test>

<test name="Test1" parallel="none">
<parameter name="browser" value="firefox"/>
 <classes>
  <class name="TestNG.Cross_Browser"/>
 </classes>
</test>
</suite>

@Test
@Parameters("browser")
public  void test1(String browser) {*/


//XML for parallel test execution

/*<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite" parallel="tests">

<test name="Test" parallel="none">
<parameter name="browser" value="chrome"/>
 <classes>
  <class name="TestNG.Cross_Browser"/>
 </classes>
</test>

<test name="Test1" parallel="none">
<parameter name="browser" value="firefox"/>
 <classes>
  <class name="TestNG.Cross_Browser"/>
 </classes>
</test>
</suite>*/


public class TestNG_xml{
}
