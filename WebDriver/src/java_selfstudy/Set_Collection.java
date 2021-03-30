package java_selfstudy;

import java.util.ArrayList;

/*-Set does not allow duplicate values
-unordered collection*/

import java.util.HashSet;

public class Set_Collection {
	
	public static void main(String[] args) {
		
	HashSet<String> values =  new HashSet<>();                      //Will return in random order
	
	values.add("Selenium");
	values.add("QTP");
	values.add("1");
	values.add("abc");
	
	System.out.println(values);
	
	for (String s : values){
		System.out.println(s);
	}
	
	//LinkedHashSet<String> values =  new LinkedHashSet<>();         //Will return in insertion order
	//TreeSet<String> values =  new TreeSet<>();                     //Will return in ascending order
	
	//Set<String> values =  new HashSet<>();
	ArrayList<String> list = new ArrayList<>(values);                //convert to Array List
	
	System.out.println(list.get(3));                                 //QTP
	
  }
}
