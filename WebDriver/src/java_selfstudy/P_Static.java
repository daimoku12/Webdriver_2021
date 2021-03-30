package java_selfstudy;

//Static members can be accessed using Class
//Non static members can be accessed using objects

public class P_Static {

//declare static variables
static int a=10, b=20;

//declare non static variables
int c=30, d=40;
	
//create static method with returning value
public static int add(){
int result = a+b;
return result;	
}
//create static method without returning value
public static void multiply(){
System.out.println(a*b);	
}
//create non static method with returning value
public int add2(){
int res = c+d;
return res;
}
//create non static method without returning value
public void multiply2 (){
System.out.println(c*d);	
}
	
public static void main(String[] args) {

//Access static variable
System.out.println(P_Static.a);//10

//Access static method with returning value
int x = P_Static.add();    //using class
System.out.println(x); 
int y = add();             //without using class
System.out.println(y);

//Access static method without returning value
P_Static.multiply();       //200

P_Static obj = new P_Static (); //create object of class

//Access non static variable
System.out.println(obj.c);    //30

//Access non static method without returning value
obj.multiply2();

//Access non static method with returning value	
int z = obj.add2();
System.out.println(z);        //70
 }
}
