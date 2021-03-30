package java_selfstudy;

import java.util.ArrayList;
import java.util.Collections;

//If values are assigned to elements more than the length of the Array - Runtime error
//If values are assigned to some elements - No error

public class Arrays {

public static void main (String [] args){	

	ArrayList <Integer>li = new ArrayList<Integer>();
	
	li.add(1);
	li.add(10);
	li.add(2);
	Collections.sort(li);
	System.out.println(li);
	System.out.println(li.get(2));
	
int [] a = new int [3]; //Array declaration	(option 1)

a[0]=10;	
a[1]=20; // a[2] not initialized. It will be zero	

for (int j : a) //enhanced for loop
System.out.println(++j);	// 11 21 1

int [] b= {1,2,3,4}; //Array declaration (option 1)

System.out.println(b[2]); //3

//Different Arrays (based on data types)

char [] abc = {'A','B','C'}; //Array of characters
int [] xyz= {10, 20, 30, 40}; //Array of integers
String [] c = {"UFT","QTP","Selenium"}; //Array of String
boolean [] d = {true,false,true}; //Array of Boolean values

System.out.println(abc[0]); //A
System.out.println(xyz[0]); //10
System.out.println(c[0]); //UFT
System.out.println(d[0]); //true

int array1[] = {1,2,3};
int array2[] = array1; //Copying Array

for (int z : array2) //Displaying Array characters using Enhanced for loop
	System.out.println(z);

for (int y=0;y<array2.length;y++) //Displaying Array characters using for loop and length function
System.out.println(array2[y]);

for (int y=0;y<3;y++) //Displaying Array characters using for loop
System.out.println(array2[y]);

//Multi Dimensional Array

int array3 [][] = {{1,3,5,7},{2,4,6,8}};
System.out.println(array3[0][3]); //7
System.out.println(array3[1][3]); //8

//Example of 'Enhanced For' loop 

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