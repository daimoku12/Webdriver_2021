package java_selfstudy;

import java.util.HashMap;

public class Hashmap 
{
	public static HashMap<String, String> practice()
	{
		HashMap <String, String> test= new HashMap<>();
		test.put("Name", "Kunal");
		test.put("Name", "Malik");  //Value for Key Name will be overridden; Key should be unique
		test.put("Place", "Milton");
		return test;	
	}

	public static void main(String[] args) 
	{
	    System.out.println(practice().get("Name"));
	    System.out.println(practice().get("Place"));
	}

}
