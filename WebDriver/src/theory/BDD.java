package theory;

public class BDD {
	
/*	 1: Feature: Some terse yet descriptive text of what is desired
	 2:   Textual description of the business value of this feature
	 3:   Business rules that govern the scope of the feature
	 4:   Any additional information that will make the feature easier to understand
	 5: 
	 6:   Scenario: Some determinable business situation
	 7:     Given some precondition
	 8:       And some other precondition
	 9:     When some action by the actor
	10:       And some other action
	11:       And yet another action
	12:     Then some testable outcome is achieved
	13:       And something else we can check happens too*/
	
	//https://github.com/cucumber/cucumber/wiki/Given-When-Then
	
/*	Tagged Hooks

	@Second	
	Scenario: This is Second Scenario
		Given this is the first step
		When this is the second step
		Then this is the third step

	@Before("@Second")
	    public void beforeSecond(){
	        System.out.println("This will run only before the Second Scenario");
	    }
		
	@After("@Second")
	    public void afterSecond(){
	        System.out.println("This will run only after the Second Scenario");   
	    }	

	@Before("@First,@Third")


	How to set the Order or Priority of Cucumber Hooks?

	The very important thing to note here is:

	@Before(order = int) : This runs in increment order, means value 0 would run first and 1 would be after 0.
	@After(order = int) : This runs in decrements order, means apposite of @Before. Value 1 would run first and 0 would be after 1.*/

/*	
	Regular Expression

	|              Alternation	(Navigate to|Open|Launch) http://www.google.com
	.	           one of anything (except a newline)
	.*	           any character 0 or more times
	(.*)	       Capture Group/ Step Definition argument
	(?:.*)	       Not a capture group. Just regular expression
		           ^User (?:is on|navigates to|launches) (http.*com)$
	\"(.*)\"       "Kunalmalik"  (" will not be ignored)
	.{2}	       Exactly two of any character
	.{1,3}	       one to three of any character
	[0-9]* or \d*  matches a series of digits or nothing
	^pattern	   anchors match to beginning of string
	pattern$	   anchors match to end of string

	*/
	
	
}
