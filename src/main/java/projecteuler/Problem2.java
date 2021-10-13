package projecteuler;
/*
 * Even Fibonacci numbers
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

	1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

	By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
public class Problem2 {

	public static void main(String[] args) {
		int previous = 1;
		int current = 2;
		int nextNum = 0;
		int evenSum = 2;
		while(nextNum < 4000000) {
			nextNum = previous + current;
			previous = current;
			current = nextNum;
			if(nextNum %2 == 0) {
				evenSum += nextNum;
			}
		}
		System.out.println(evenSum);
	}

}