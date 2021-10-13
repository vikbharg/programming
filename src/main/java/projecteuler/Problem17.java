/*
 * Number Letter Count
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

	If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
	
	
	NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 */

package projecteuler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Problem17 {

	public static void main(String[] args) {
		Map<Integer, String> unitPlace = new HashMap<Integer, String>(){{ 
			put(0,"");
			put(1, "One"); 
			put(2, "Two"); 
			put(3, "Three"); 
			put(4, "Four"); 
			put(5, "Five"); 
			put(6, "Six"); 
			put(7, "Seven"); 
			put(8, "Eight"); 
			put(9, "Nine"); 
		}};
		
		Map<Integer, String> tenPlace = new HashMap<Integer, String>(){{ 
			put(0, "");
			put(11, "Eleven"); 
			put(12, "Twelve"); 
			put(13, "Thirteen"); 
			put(14, "Forteen"); 
			put(15, "Fifteen"); 
			put(16, "Sixteen"); 
			put(17, "Seventeen"); 
			put(18, "Eighteen"); 
			put(19, "Nineteen"); 
			put(2, "Twenty"); 
			put(3, "Thirty"); 
			put(4, "Forty"); 
			put(5, "Fifty"); 
			put(6, "Sixty"); 
			put(7, "Seventy"); 
			put(8, "Eighty"); 
			put(9, "Ninety"); 
		}};
		
		Map<Integer, String> precisionValue = new HashMap<Integer, String>(){{ 
			put(2, "Hundred"); 
			put(3, "Thousand"); 
		}};
		
		int limit = 1000;
		long totalCount = 0;
		for(int i=1;i<=limit;i++) {
			
			int power = -1;
			int number = i;
			StringBuilder value = new StringBuilder("");
			
			LinkedList<Integer> stack = new LinkedList<>();
			while (number > 0) {
			    stack.push( number % 10 );
			    power++;
			    number = number / 10;
			}

			while (!stack.isEmpty()) {
			    int digit = stack.pop();
			    if(power > 1) {
			    	if(digit > 0) {
			    		value.append(unitPlace.get(digit)).append(precisionValue.get(power));
			    	}
			    	if(power == 2 && i % 100 != 0) {
			    		value.append("and");
			    	}
			    }
			    
			    if(power == 1) {
			    	if(digit == 1) {
			    		int finalDigit = Integer.parseInt((digit + "" + stack.pop()));
			    		value.append(tenPlace.get(finalDigit));
			    	}else {
			    		value.append(tenPlace.get(digit));
			    	}
			    }
			    
			    if(power == 0) {
			    	value.append(unitPlace.get(digit));
			    }
			    
			    power--;
			}
			
			totalCount += value.length();
		}
		
		System.out.println(totalCount);
	}
}
