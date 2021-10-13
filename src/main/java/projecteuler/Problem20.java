/*
 * Factorial Digit Sum
 * n! means n × (n - 1) × ... × 3 × 2 × 1

	For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
	and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
	
	Find the sum of the digits in the number 100!
 */
package projecteuler;

import java.math.BigInteger;

public class Problem20 {

	public static void main(String[] args) {
		System.out.println(sumOfFactorialDigits(factorial(100)));
	}
	
	public static BigInteger factorial(int n) {
		if(n == 0 || n == 1) {
			return new BigInteger(String.valueOf("1"));
		}
		BigInteger b = new BigInteger(String.valueOf(n));
		return b.multiply(factorial(n-1));
	}
	
	public static long sumOfFactorialDigits(BigInteger b) {
		long sum = 0;
		for(char c : b.toString().toCharArray()) {
			sum += Character.getNumericValue(c);
		}
		return sum;
	}
}
