package inhetitance;

//Only 'non static' class members can be inherited 

/* 3 types of inheritance
 - Single (ClassB extends ClassA)
 - Multilevel (ClassB extends ClassA, ClassC extends ClassB)
 - Multiple Inheritance (Java doesn't support directly)(ClassB extends ClassA and ClassB extends ClassC)*/

//In multilevel Inheritance, priority is given to Child class over Parent class if the both the classes have same variables/methods  

public class ClassA {

public static int a=10;
int b=20;

ClassA(){
	System.out.println("ClassA");
}

ClassA (int a)
{
System.out.println("param constructor A");	
}
public void add(){
System.out.println(a+b);	
}
	
public static void main(String[] args) {

ClassA objA = new ClassA();
ClassA objB = new ClassA();
ClassA objC = new ClassA();

objA.a=120;
objB.a=10;
objC.a=2;

System.out.println("Static test :"+ (a + objB.a + objC.a));


objA.add();//30


 }
}
