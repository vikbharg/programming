/*
 * Reciprocal Cycles
 * 
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

	1/2	= 	0.5
	1/3	= 	0.(3)
	1/4	= 	0.25
	1/5	= 	0.2
	1/6	= 	0.1(6)
	1/7	= 	0.(142857)
	1/8	= 	0.125
	1/9	= 	0.(1)
	1/10	= 	0.1
	Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
	
	Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
package projecteuler;

import java.util.HashMap;
import java.util.Map;

public class Problem26 {

	public static void main(String[] args) {
		int limit = 1000;
		
		int longestCycle = 0;
		int output = 0;
	
		for(int i=2;i<limit;i++) {
			int cycle = getRecurringCycle(i);
			if(longestCycle < cycle) {
				longestCycle = cycle;
				output = i;
			}
		}
		System.out.println(output);
	}
	
	public static int getRecurringCycle(int number) {
		int rem = 1;
		String quotient = "";
		Map<Integer, Integer> remMap = new HashMap<>();

		while (rem != 0 && (!remMap.containsKey(rem))) {
			
			remMap.put(rem, quotient.length());
			rem = rem * 10;
			int currentQuotient = rem / number;
			quotient += String.valueOf(currentQuotient);
			rem = rem%number;
		}

		if (rem == 0)
			return 0;
		else if (remMap.containsKey(rem))
			return quotient.substring(remMap.get(rem)).length();
		else 
			return 0;
	}
}
