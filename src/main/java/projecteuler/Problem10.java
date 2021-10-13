package projecteuler;
/*
 * Summation of Primes
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

	Find the sum of all the primes below two million.
 */
public class Problem10 {

	public static void main(String[] args) {
		
		long limit = 2000000;
		long sumOfPrimes = 0;
		for(int i=2;i<limit;i++) {
			if(isPrimeNumber(i)) {
				sumOfPrimes += i;
			}
		}
		System.out.println(sumOfPrimes);
	}
	
	public static boolean isPrimeNumber(long number) {
		for(int i=2;i<=((Double)Math.sqrt(number)).intValue();i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
