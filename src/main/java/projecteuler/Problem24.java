/*
 * Lexicographic Permutations
 * 
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

	012   021   102   120   201   210
	
	What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
package projecteuler;

import java.util.stream.IntStream;

public class Problem24 {

	public static void main(String[] args) {
		long numberLeft = 1000000;
		String output = "";
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		for(int i=0;i<=9;i++) {
			int index = 0;
			int number = arr[index];
			while(numberLeft > factorial(10-i-1)) {
				index++;
				number = arr[index];
				numberLeft -= factorial(10-i-1);
			}
			output += number;
			arr = removeArrayElement(arr, number);
		}
		
		System.out.println(output);
	}
	
	
	public static int[] removeArrayElement(int[] oddArray, int index) {

		return IntStream.range(0, oddArray.length).filter(i -> oddArray[i] != index).map(i -> oddArray[i]).toArray();
	}
	
	public static int factorial(int number) {
		if(number == 0 || number ==1)
			return 1;
		
		return number * factorial(number-1);
	}
}