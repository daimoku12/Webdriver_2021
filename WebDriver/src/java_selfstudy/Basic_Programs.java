package java_selfstudy;

public class Basic_Programs {
	
/* swap number  

int a=4, b=6;
c=a+b;
a=b;
b=c-a;

swap number without using third variable

a=a+b;
b=a-b;
a=a-b;

a=a*b;
b=a/b;
a=a/b

Palindrome - Reverse then compare
*/
	

public static void main (String [] args){

//factorial of a number		
		
int i, j=1;
for (i = 1; i<=5; i++){
	j = i * j;
  }
System.out.println("Factorial of 5 : " + j);

//reverse a number

int a = 1234, b, c=0;
while (a>0)
{
	b = a % 10;
	a = a / 10;
    c= ((c*10) + b);    
}
System.out.println(c);

//fibonacci series

int d=0, e=1, sum=0;
System.out.println(d);
System.out.println(e);
for (int x=3; x<10;x++){	
	sum=d+e;
	d=e;
	e=sum;
System.out.println(d+e);	
  }	
 }
}

