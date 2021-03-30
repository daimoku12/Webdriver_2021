package weekend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TransferToTextFile {

	public static void main(String[] args) throws IOException 
	{	

		BufferedReader br = new BufferedReader(new FileReader("C:/Users/Kannu/Downloads/Original.txt"));
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Kannu/Downloads/New.txt", true));

		String S1 = br.readLine();
		
		while (S1!=null)
		
		{
			bw.write(S1);
			S1 = br.readLine();
			bw.newLine();
			
		}
		
		bw.close();
		br.close();
				
	}

}
