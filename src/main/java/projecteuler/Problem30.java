/*
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

	1634 = 14 + 64 + 34 + 44
	8208 = 84 + 24 + 04 + 84
	9474 = 94 + 44 + 74 + 44
	As 1 = 14 is not a sum it is not included.
	
	The sum of these numbers is 1634 + 8208 + 9474 = 19316.
	
	Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
package projecteuler;

public class Problem30 {

	public static void main(String[] args) {
		int power = 5;
		
		System.out.println(getSumOfNumbers(power));
	}

	public static long getSumOfNumbers(int power) {
		long sumOfDigitPower = 0;
		int upperLimit = 0;
		Integer number = (new Double(Math.pow(9, power))).intValue();
		Integer numberOfDigit = 1;
		while((new Integer(numberOfDigit*number)).toString().length() >= numberOfDigit) {
			upperLimit = numberOfDigit*number;
			numberOfDigit++;
		}
		
		for(int i=2;i<=upperLimit;i++) {
			if(i == getSumOfDigitPower(i, power)) {
				sumOfDigitPower += i;
			}
		}
		return sumOfDigitPower;
	}
	
	public static long getSumOfDigitPower(int number, int power) {
		long sum = 0;
		while(number != 0) {
			int rem = number % 10;
			sum += (new Double(Math.pow(rem, power))).longValue();
			number = number/10;
		}
		return sum;
	}
}
