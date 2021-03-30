package inhetitance;

//Example of accessing 'Protected' class members. Look for 'ClassY' in 'Selfstudy' package

public class ClassX {

protected int a=10, b=20;
protected void add(){
System.out.println(a+b);	
}
	
public static void main(String[] args) {
		
ClassX objx = new ClassX();
System.out.println(objx.a);//10
objx.add();//30

}
}
