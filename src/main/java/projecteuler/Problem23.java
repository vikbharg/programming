/*
 * Non Abundant Sums
 * 
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

	A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
	
	As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
	
	Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
package projecteuler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Problem23 {

	public static void main(String[] args) {
		
		System.out.println(new Date());
		int limit = 28123;
		int sumPositiveNumbers = 0;
		
		//Way 1
		/*List<Integer> allAbundantSum = getAllAbundantSum(limit);
		
		for(int i=1;i<=limit;i++) {
			if(!allAbundantSum.contains(i)) {
				sumPositiveNumbers += i;
			}
		}*/
		
		//Way 2
		int[] allAbundantSum = getAllAbundantSum(limit);
		
		for(int i=1;i<=limit;i++) {
			if(allAbundantSum[i] == 0) {
				sumPositiveNumbers += i;
			}
		}
		
		System.out.println(sumPositiveNumbers);
		System.out.println(new Date());
	}
	
	//Way 1 - takes 1 min 52 sec
	/*public static List<Integer> getAllAbundantSum(int limit) {
		
		List<Integer> abundantNumbers = getAllAbundantNumbers(limit);
		
		List<Integer> sumAbundantNumbers = new ArrayList<>();
		for (int first = 0; first < abundantNumbers.size(); first++) {
			for (int second = first; second < abundantNumbers.size(); second++) {
				sumAbundantNumbers.add(abundantNumbers.get(first) + abundantNumbers.get(second));
				
			}
		}

		return sumAbundantNumbers;
	}*/
	
	//Way 2 - takes less than a second
	public static int[] getAllAbundantSum(int limit) {
		
		List<Integer> abundantNumbers = getAllAbundantNumbers(limit);
		
		int[] sumAbundantNumbers = new int[limit+1];
		for (int first = 0; first < abundantNumbers.size(); first++) {
			for (int second = first; second < abundantNumbers.size(); second++) {
				int sum = abundantNumbers.get(first) + abundantNumbers.get(second);
				
				if(sum <= limit) {
					sumAbundantNumbers[sum] = sum;
				}
			}
		}

		return sumAbundantNumbers;
	}
	
	public static List<Integer> getAllAbundantNumbers(int limit){
		List<Integer> abundantNumbers = new ArrayList<>();
		for(int i=1;i<=limit;i++) {
			if(i < getSumOfAllDivisors(i)) {
				abundantNumbers.add(i);
			}
		}
		return abundantNumbers;
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
