/*
 * 1000-digit Fibonacci Number
 * 
 * The Fibonacci sequence is defined by the recurrence relation:

	Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.
	Hence the first 12 terms will be:
	
	F1 = 1
	F2 = 1
	F3 = 2
	F4 = 3
	F5 = 5
	F6 = 8
	F7 = 13
	F8 = 21
	F9 = 34
	F10 = 55
	F11 = 89
	F12 = 144
	The 12th term, F12, is the first term to contain three digits.
	
	What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */

package projecteuler;

import java.math.BigInteger;

public class Problem25 {

	public static void main(String[] args) {
		int counter = 1;
		while(fibonacci(counter).toString().length() < 1000) {
			System.out.println(fibonacci(counter).toString().length());
			counter++;
		}
		System.out.println(counter+1);
	}
	
	
	//Recursion
	/*public static BigInteger fibonacci(int number) {
		if(number == 0 || number == 1) {
			return new BigInteger(String.valueOf(number));
		}
		
		return fibonacci(number-1).add(fibonacci(number-2));
	}*/
	
	public static BigInteger fibonacci(int number) {
		BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(0);
        for (int j=2 ; j<=number ; j++)
        {
            c =  a.add(b);
            a = b;
            b = c;
        }
        return c;
	}
}
