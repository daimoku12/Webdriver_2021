package java_selfstudy;

import inhetitance.ClassX;

//Look for 'ClassX' in 'Inheritance' Package

public class ClassY extends ClassX{

	public static void main(String[] args) {
		
		ClassY objy = new ClassY();
		System.out.println(objy.a);//10
		objy.add();//30		
}
}