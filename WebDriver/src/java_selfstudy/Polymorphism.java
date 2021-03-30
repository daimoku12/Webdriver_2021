package java_selfstudy;

/*2 types of Polymorphism

- Compile time/ Method Overloading/ Early binding - If 2 or more methods in same class have same name but different signature
- Runtime/ Method Overriding/ Late binding - If 2 or more methods with same name available in super class and sub class*/

//Example of Method Overloading

public class Polymorphism {

public void add (int a , int b){
System.out.println(a+b);
}

public void add (int a , int b, int c){
System.out.println(a+b+c);
}

public void add (float a , double b){
System.out.println(a+b);
}

public static void main(String[] args) {
		
Polymorphism P = new Polymorphism();

P.add(10, 20); //30
P.add(1, 2, 3); //6
P.add(1.1f, 2.1); //3.2
	
}
}
