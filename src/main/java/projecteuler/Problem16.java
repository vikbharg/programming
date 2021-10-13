/*
 * Power Digit Sum
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

	What is the sum of the digits of the number 21000?
 */
package projecteuler;

import java.math.BigInteger;

public class Problem16 {

	public static void main(String[] args) {
		int power = 1000;
		BigInteger b = new BigInteger("2");
		b = b.pow(power);
		int sum = 0;
		for(char c : b.toString().toCharArray()) {
			sum+= Character.getNumericValue(c);
		}
		System.out.println(sum);
	}
}
