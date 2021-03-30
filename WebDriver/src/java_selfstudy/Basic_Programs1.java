package java_selfstudy;

public class Basic_Programs1 {

	public static void main(String[] args) {

//Sum of elements of an array
		
	int A [] = {1,2,3,4};
	int z=0;
	for (int j : A){
		z=z+j;	
	}
	System.out.println(z); //10
	
//Reverse of a String
	
	String s ="Hello";
	String x ="";
	System.out.println(s.length()); //5
	
	for (int i = s.length()-1; i >=0 ; i--){
	  x = x + s.charAt(i);
	}
System.out.print(x); //olleH

System.out.println();

//Enhanced for loop for 2 d array

String[][] chords = {{"A", "C", "D", "E"},{"Am","Dm"}};

for (String X[] : chords) {
  for(String Y : X) {
        System.out.print(Y + " "); //A C D E Am Dm 
    }
    }
System.out.println();

//Find duplicate characters in a string

String str = "selennium";

char[] inp = str.toCharArray(); //convert String to Char Array 

System.out.println("Duplicate Characters are:");

for (int i = 0; i < str.length(); i++) {
 for (int j = i+1; j < str.length(); j++) {
  if (inp[i] == inp[j]) {
   System.out.println(inp[i]);
  }
 }
}

}
}

