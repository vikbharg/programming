package projecteuler;
/*
 * 10001st Prime
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

	What is the 10 001st prime number?
 */
public class Problem7 {

	public static void main(String[] args) {
		
		int requiredPrime = 10001;
		int primeCount = 0;
		int number = 2;
		while(true) {
			boolean isPrime = true;
			for(int i=2;i<=((Double)Math.sqrt(number)).intValue();i++) {
				if(number % i == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				primeCount++;
			}
			if(primeCount == requiredPrime) {
				break;
			}
			number++;
		}
		System.out.println(number);
	}

}
