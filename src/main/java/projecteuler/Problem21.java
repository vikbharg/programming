/*
 * Amicable Numbers
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
	If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.
	
	For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
	
	Evaluate the sum of all the amicable numbers under 10000.
 */
package projecteuler;

import java.util.ArrayList;
import java.util.List;

public class Problem21 {

	public static void main(String[] args) {
		
		int limit = 10000;
		int amicableSum = 0;

		List<Integer> amicableNumbers = new ArrayList<>();
		for(int i=2;i<limit;i++) {
			if(amicableNumbers.contains(i)) {
				continue;
			}
			int sumOfDivisors = getSumOfAllDivisors(i);
			if(i != sumOfDivisors && i == getSumOfAllDivisors(sumOfDivisors)) {
				
				amicableNumbers.add(i);
				amicableNumbers.add(sumOfDivisors);
			}
		}
		for(int num : amicableNumbers) {
			amicableSum += num;
		}
		System.out.println(amicableSum);
	}
	
	public static int getSumOfAllDivisors(int number) {
		int sum = 0;
		
		for (int i = 1; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				if (number / i == i)
					sum += i;

				else
					if(number/i != number) {
						sum += i + number/i;
					}else {
						sum += i;
					}
					
			}
		}
		return sum;
	
	}
}
