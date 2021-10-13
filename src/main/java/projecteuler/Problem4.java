package projecteuler;
/*
 * Largest palindrome product
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

	Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {

	public static void main(String[] args) {
		
		int digits = 2;
		int largestProduct = 0;
		int lowerLimit = ((Double)Math.pow(10, digits)).intValue();
		int upperLimit = ((Double)Math.pow(10, digits+1)).intValue();
		for(int i=lowerLimit;i<upperLimit;i++) {
			for(int j=i+1;j<upperLimit;j++) {
				if(isPalindrome(i*j) && largestProduct < i*j) {
					largestProduct = i*j;
				}
			}
		}
		System.out.println(largestProduct);
	}
	
	public static boolean isPalindrome(long number) {
		
		long tempNumber = number;
		String str = "";
		while(tempNumber > 0) {
			str+= tempNumber % 10;
			tempNumber = tempNumber/10;
		}
		
		return (number == Long.parseLong(str));
	}
}
