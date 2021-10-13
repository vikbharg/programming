package projecteuler;
/*
 * Largest Prime Factor
 * The prime factors of 13195 are 5, 7, 13 and 29.

	What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {

	public static void main(String[] args) {
		long number = 600851475143L;
		long largestPrimeFactor = -1;
		for(long i=2;i<=Math.sqrt(number);i++) {
			if(number % i == 0) {
				if(isDivisorPrime(i)) {
					if(largestPrimeFactor < i) {
						largestPrimeFactor = i;
					}
				}
			}
		}
		System.out.println(largestPrimeFactor);
	}
	
	public static boolean isDivisorPrime(long num) {
		
		if(num == 2 || num % 2 == 0) {
			return false;
		}
		
		for(long i=3;i<Math.sqrt(num);i+=2) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
