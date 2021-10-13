package projecteuler;
/*
 * Special Pythagorean Triplet
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

	a2 + b2 = c2
	For example, 32 + 42 = 9 + 16 = 25 = 52.
	
	There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	Find the product abc
 */
public class Problem9 {

	public static void main(String[] args) {

		long limit = 10000;
		long count = 0;
		for (long i = 1; i < limit; i++) {
			for (long j = i + 1; j < limit; j++) {
				long sumOfSquares = ((Double) Math.pow(i, 2)).longValue() + ((Double) Math.pow(j, 2)).longValue();
				if (Math.ceil((double) Math.sqrt(sumOfSquares)) == Math.floor((double) Math.sqrt(sumOfSquares))
						&& i + j + ((Double) Math.sqrt(sumOfSquares)).longValue() == limit) {

					System.out.println(i * j * ((Double) Math.sqrt(sumOfSquares)).longValue());
					count++;
					break;
				}
			}
			if (count == 1) {
				break;
			}
		}
	}
}
