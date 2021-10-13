package projecteuler;
/*
 * Sum Square Difference
 * The sum of the squares of the first ten natural numbers is,

	The square of the sum of the first ten natural numbers is,
	
	Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is .
	
	Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem6 {

	public static void main(String[] args) {
		int limit = 100;

		int sumOfSquare = limit * (limit+1) * (2*limit + 1)/6;
		int squareOfSum = ((Double)Math.pow(limit * (limit+1)/2, 2)).intValue();
		System.out.println(squareOfSum - sumOfSquare);
	}

}
