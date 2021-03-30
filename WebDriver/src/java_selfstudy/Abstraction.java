package java_selfstudy;

/* Abstraction is a process of hiding implementation details and showing only functionality to the user

2 types of methods in Java

- Concrete methods (complete : have body)
- Abstract methods (have no body)

Java class contains 100% concrete methods
Abstract class contains one or more abstract methods

Interface can only have abstract methods (try implements keyword to inherit interface): Can only have constant variables */

public abstract class Abstraction {

public void handle(){
System.out.println("Bikes have handle");	
}

public void brake(){
System.out.println("Bikes have brake");	
}

public abstract void engine();
public abstract void wheels();

public static void main(String[] args) {

//Abstraction obj = new Abstraction(); // Will throw error
	
Abstraction1 obj = new Abstraction1(); // Child class object created in parent class
obj.engine();
obj.wheels();

}
}
