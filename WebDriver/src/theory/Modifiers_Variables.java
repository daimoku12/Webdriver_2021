package theory;

/*Java compiler converts the code into 'bytecode'. The output is a .class file. This code can only be understood by JVM (Java Virtual machine)
which resides in the RAM of OS. JVM converts the bytecode into native machine code.
During execution, using the class loader the class files are brought on the RAM.

Java variables (named memory location to store temporary data within a program) are case sensitive
java variable name should start with a letter or '$' or '_'
 
 Primary memory (RAM), Secondary memory (HDD, DVD etc)
 
 3 types of variables in Java
 ----------------------------------------------------------------------
 Local variables - declared in methods or blocks
 Instance Variables - declared in class but outside of method/block
 Class/ Static variables - declared as static before Main method
-----------------------------------------------------------------------*/

/* Two types of modifiers in Java.

Access modifiers - are used to define access control for classes, methods and variables 	
 - Private (accessible only within class)
 - Default (accessible only within package)
 - Protected (accessible within package, outside package using inheritance)
 - Public (accessible everywhere)	
----------------------------------------------------------------------------------------------------------	
Modifier 	Within Class   Within Package  Outside Package (subclass/ Inheritance)  Outside Package 
Private	         Y				N							N								N
Default			 Y				Y							N								N
Protected		 Y				Y							Y								N
Public			 Y				Y							Y								Y			
----------------------------------------------------------------------------------------------------------	
Non Access Modifiers (3 for automation) 	
 - Static (used to create classes, methods and variables)
 - Final (used for finalizing classes, methods and variables)	
 - Abstract (to create abstract classes and abstract methods)	
---------------------------------------------------------------------------------------------------------*/

/*Final Class - Cannot be inherited
Final Method - Cannot be overrided
Final Variable - Will remain constant*/

//In case of Overriding - To run super class method in child class use super keyword

public class Modifiers_Variables {

}
