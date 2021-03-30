package java_selfstudy;

class Hii implements Runnable
{
	public void run()
	{
		for (int i=1 ; i<=5 ; i++)
		{
			System.out.println("HiHi");
			try { Thread.sleep(500);} catch(Exception e) {}
		}
	}
}

class Helloo implements Runnable
{
	public void run()
	{
		for (int i=1 ; i<=5 ; i++)
		{
			System.out.println("HelloHello");
			try { Thread.sleep(500);} catch(Exception e) {}
		}
	}
}

public class ThreadDemo1
{
	public static void main(String[] args) throws Exception 
	{
        Hii obj1 = new Hii();
        Helloo obj2 = new Helloo();
        
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        
        t1.start();    //start will automatically call run
        try { Thread.sleep(10);} catch(Exception e) {}
        t2.start();
        
        t1.join();   //wait for thread to die
        t2.join();
        System.out.println(t1.isAlive());
        System.out.println("After thread");
	}

}
