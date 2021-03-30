package java_selfstudy;

/*Collection (Framework)

-Dynamic Data Structure (Heap memory)-To store and manipulate group of objects

Collection (i)
-Set(i) - Hashset(c), LinkedHashSet(c), TreeSet(c)
-List(i) - LinkedList(c), Vector(c), ArrayList(c)

ArrayList -dynamic array-can store duplicate values-maintains insertion order-slow (always start from 0)
Generic in Collection - specify a type */ 

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_Collection {
	
	public static void main(String[] args) {
		
		ArrayList obj1 = new ArrayList();
		
        //List <String> obj2 = new ArrayList(); //Child class object, parent class reference - Only parent methods can be accessed
		//ArrayList <String> obj2 = new ArrayList<String>();      //Generic
		//java.util.ArrayList obj1 = new java.util.ArrayList(); (If Class name is ArrayList)
		
		obj1.add(57657);
		obj1.add('C');
		obj1.add("Selenium");
		obj1.add(12.23);
		
		System.out.println(obj1);
        
		for (int i=0;i<obj1.size();i++){
		System.out.println(obj1.get(i));
		}

		for (Object abc:obj1){
		System.out.println(abc);
		}

		Iterator itr = obj1.iterator();

		while(itr.hasNext())
		{
		  Object value = itr.next();
		  System.out.println(value);
		}
	}
}
