package java_selfstudy;

/* Encapsulation - Process of wrapping code and data into a single unit
It enables making the fields in a class as private and providing access via public methods*/

//Run--> Run configurations

    class Encapsulation {

	int a; //default access
	public int b; //public access
	private int c; // private access

	void setvalue(int i){
	c=i;	
	}

	int getvalue(){
	return c;	
	}
	}

	class B {
			
	public static void main(String args []) {
			
	Encapsulation obj = new Encapsulation();
	obj.a =10; //allowed as 'a' has default access
	obj.b =20; //allowed as 'b' has default access
	System.out.println(obj.a + obj.b);	

// obj.c = 30; private variable cannot be accessed from this class

	obj.setvalue(4);
//	int z = obj.getvalue();
	System.out.println(obj.getvalue()); // 'c' can be accessed using public methods 
		
	}
	}	

