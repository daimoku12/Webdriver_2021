package java_selfstudy;

/* Java Flow Control
 
- Conditional statements (If else, Switch) Types of conditions (Single, Compound, Nested)
- Loop Statements (For, While, Do While, Enhanced For) */

public class FlowStatements {

public static void main (String [] args){

char grade = 'A';

// Example of Switch Statement

switch (grade){
    case 'A':
        System.out.println("Excellent");
        break;
    case 'B':
        System.out.println("Better");
        break;    
    case 'C':
        System.out.println("Fail");
        break;    
  }
// Switch Statement example - Default

for (int i=1; i<=3; i++)
	switch (i){
	case 1:
		System.out.println("i is " + i );
		break;
	case 2:
		System.out.println("i is " + i );
		break;
	default:
		System.out.println("i is " + i + ". Since case is not defined for 3, default is printed");
		break;
  }
// Example of While loop

int z = 1;

while (z <=10){
	System.out.println(z);
    z++;
  }

// Difference between ++a and a++............................................

int e= 10, f= 20;

e= ++f; // f=f+1, e=f
System.out.println(e); // 21
System.out.println(f); // 21

e= 10; f= 20;

e= f++; // e=f, f=f+1
System.out.println(e); // 20
System.out.println(f); // 21

// Example of Do while loop
  
    int g = 1;
    do
    {
    	System.out.println(g);
    	g++;
    } while (g>= 4);
    
// Example of 'Enhanced For' loop 
    
    int [] salary = {1,2,3,4}; // Array declaration and value assignment
    for (int y : salary)
    	System.out.print(y); //1234
        System.out.println();    
    
//Enhanced for loop for 2 d array

    String[][] chords = {{"A", "C", "D", "E"},{"Am","Dm"}};

    for (String X[] : chords) {
      for(String Y : X) {
            System.out.print(Y + " "); //A C D E Am Dm 
        }
        }   
 }
}