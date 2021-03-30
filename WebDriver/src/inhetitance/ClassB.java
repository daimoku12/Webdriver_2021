package inhetitance;

public class ClassB extends ClassA {

int a= 100; 
int b= 200;

/*ClassB(){
	System.out.println("ClassB");
}*/

public void add1()
{ 
	
//try the output by changing this method name to 'add'
//Method name 'add' is an example of Method Overriding ('add' exists in SuperClass (A) and SubClass (B))	
	
  System.out.println(a+b);	
}

ClassB()
{
  //super();
  System.out.println("ClassB");
}
	
ClassB(int b)
{
  System.out.println("param Class B");
}
	
public static void main(String[] args) 
{
		
  ClassB objB = new ClassB();
  System.out.println(objB.a);//100 (100 in this class is given preference over parent class)
  objB.add();//30
  objB.a = 100;

//If Inheritance is not used, then create object of ClassA in ClassB to access the members of ClassA

/*ClassA objA = new ClassA();
System.out.println(objA.a);//10
objA.add();//30 */	
 
}
}
