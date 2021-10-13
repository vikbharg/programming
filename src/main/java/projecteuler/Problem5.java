package projecteuler;
/*
 * Smallest Multiple
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

	What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem5 {

	public static void main(String[] args) {
		int limit = 20;
		int number = limit+1;
		boolean found = false;
		
		while(!found) {
			boolean complete = false;
			for(int i=2;i<=limit;i++) {
				if(number % i != 0) {
					break;
				}
				if(i == limit) {
					complete = true;
				}
			}
			if(complete) {
				System.out.println(number);
				break;
			}
			number++;
		}
	}
}
