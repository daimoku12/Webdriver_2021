package java_selfstudy;

import java.util.Scanner;

public class PrimeNumber {


	    public static void main(String args[])
	    {
	        int i, count =0;
	        Scanner scan = new Scanner(System.in);
			
	        System.out.print("Enter a Number : ");
	        
	        int num;
	        
	        num = scan.nextInt();
			
	        for(i=2; i<num; i++)
	        {
	            if(num % i == 0){
	            	
	            count++;
	            	
	            }	            
	        }   
	            
	        if (count==0)
	        System.out.println("This is a Prime Number");	
	        else 
		    System.out.print("This is not a Prime Number");    
	         
	        scan.close();
	}		
}
