/*
 * Quadratic Primes
 * 
 * Euler discovered the remarkable quadratic formula:


	It turns out that the formula will produce 40 primes for the consecutive longeger values . However, when  is divisible by 41, and certainly when  is clearly divisible by 41.
	
	The incredible formula  was discovered, which produces 80 primes for the consecutive values . The product of the coefficients, -79 and 1601, is -126479.
	
	Considering quadratics of the form:
	
	, where  and 
	
	where  is the modulus/absolute value of 
	e.g.  and 
	Find the product of the coefficients,  and , for the quadratic expression that produces the maximum number of primes for consecutive values of , starting with .
 */
package projecteuler;

public class Problem27 {

	public static void main(String[] args) {
		
		long limit1 = 999;
		long limit2 = 1000;
		System.out.print(getCoefficientProduct(limit1, limit2));
	}
	
	public static long getCoefficientProduct(long limit1, long limit2) {
		
		long coefficient1 = -limit1-1;
		long coefficient2 = -limit2-1;
		long longestPrimes = 0;
		for(long i=-limit1;i<=limit1;i++) {
			for(long j=-limit2;j<=limit2;j++) {
				
				long n = 0;
				long number = (new Double(Math.pow(n, 2))).longValue() + i*n + j;
				while(isPrime(number)) {
					n++;
					number = (new Double(Math.pow(n, 2))).longValue() + i*n + j;
				}
				if(longestPrimes < n) {
					longestPrimes = n;
					coefficient1 = i;
					coefficient2 = j;
				}
			}
			
		}
		return coefficient1 * coefficient2;
	}

 
    // Check for number prime or not
    static boolean isPrime(long n)
    {
 
        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;
 
        // Check if number is 2
        else if (n == 2)
            return true;
 
        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;
 
        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
