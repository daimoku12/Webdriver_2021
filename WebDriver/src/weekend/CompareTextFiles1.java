package weekend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompareTextFiles1 {
	
	    public static void main(String[] args) throws IOException
	    {    
	        BufferedReader br1 = new BufferedReader(new FileReader("C:/Users/Kannu/Downloads/1.txt"));
	         
	        BufferedReader br2 = new BufferedReader(new FileReader("C:/Users/Kannu/Downloads/2.txt"));
	         
	        String S1 = br1.readLine();
	         
	        String S2 = br2.readLine();
	         
	        boolean B = true;
	              
	        while (S1 != null || S2 != null)
	        {
	            if(S1 == null || S2 == null)
	            {
	                B = false;
	                 
	                break;
	            }
	            else if(! S1.equals(S2))
	            {
	                B = false;
	                 
	                break;
	            }
	             
	            S1 = br1.readLine();
	             
	            S2 = br2.readLine();
	             
	        }
	         
	        if(B)
	        {
	            System.out.println("Two files have same content.");
	        }
	        else
	        {
	             
	            System.out.println("File1 has : " + S1 + " and File2 has : "+ S2);
	        }
	         
	        br1.close();
	         
	        br2.close();
	    }
	}

