package weekend;

public class This {
	
	int a = 100;
	int x = 21;
	
	public void a()
	{
		System.out.println("Printing from method a");
		this.b();  //Same class method called using 'This keyword'. Object is not required
	}
	public void b()
	{
		System.out.println("Printing from method b, calling from a");
	}
	
	public void number()
	{
		int a = 10;
		System.out.println(a);        //10  (Local variable is printed) 
		System.out.println(this.a);   //100 (Global variable is printed)
	}
		
	public void print (int x)
	{
		this.x=x;                     //Differentiate between local and global variables  
		System.out.println(x);        //23
	}
	
public static void main(String[] args) {
	
	This obj = new This();
	obj.a();
	obj.number();
	obj.print(23);
 }	
}
