package java_selfstudy;

public class Constructor {

int a,b,c;	
	
Constructor(){
a =10;
b=20;
}

public void add(){
c= a+b;	
System.out.println(c);
}

public static void main(String[] args) {

//Class can have multiple objects
//Constructor is called as soon as object is created.	
Constructor obj = new Constructor();
obj.add();

Constructor obj1 = new Constructor();
obj1.add();
}
}
