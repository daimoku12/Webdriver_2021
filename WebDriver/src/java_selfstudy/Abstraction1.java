package java_selfstudy;

public class Abstraction1 extends Abstraction {// Inheritance will only happen when abstract methods are defined

@Override
public void engine() {
System.out.println("Bikes have engine");	
}

@Override
public void wheels() {
System.out.println("Bikes have wheels");	
}

public static void main(String[] args) {

Abstraction1 obj = new Abstraction1();
obj.handle();
obj.brake();
obj.engine();
obj.wheels();

}
}
