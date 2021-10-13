/*
 * Distinct Powers
 * 
 * Consider all integer combinations of ab for 2 <= a <= 5 and 2 <= b <= 5:

	22=4, 23=8, 24=16, 25=32
	32=9, 33=27, 34=81, 35=243
	42=16, 43=64, 44=256, 45=1024
	52=25, 53=125, 54=625, 55=3125
	If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:
	
	4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
	
	How many distinct terms are in the sequence generated by ab for 2 <= a <= 100 and 2 <= b <= 100?
 */
package projecteuler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem29 {

	public static void main(String[] args) {
		int lowerLimit = 2;
		int upperLimit = 100;
		System.out.println(getDistinctCount(lowerLimit, upperLimit));
	}

	public static long getDistinctCount(int lowerLimit, int upperLimit) {
		Set<BigInteger> distinctSet = new HashSet<>();
		
		for(int i=lowerLimit; i<=upperLimit;i++) {
			
			for(int j=lowerLimit;j<=upperLimit;j++) {
				BigInteger number = new BigInteger(String.valueOf(i));
				number = number.pow(j);
				distinctSet.add(number);
			}
		}
		
		return distinctSet.size();
	}
}