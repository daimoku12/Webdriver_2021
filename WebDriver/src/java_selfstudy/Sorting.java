package java_selfstudy;

import java.util.Scanner;

public class Sorting {

public static void main(String[] args) {
	
Scanner scan = new Scanner (System.in);	

System.out.println("Enter the total number of elements to be sorted");
int a = scan.nextInt();
int A [] = new int [a]; //size of array defined

System.out.println("Enter the elements");

for (int i=0;i<A.length;i++){
	A[i] = scan.nextInt(); //Elements entered by user
}

int temp;

for (int i=0; i<=a-1; i++){
	for (int j =i+1; j<=a-1; j++){
		if (A[i] > A[j]){		
		   
		temp = A[j];
		A[j] = A[i];
		A[i] = temp;
	}
   }
 }

for (int k: A){
System.out.println(k);	//Print elements after sorting
}
scan.close();
}
}
