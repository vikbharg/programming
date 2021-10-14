package algorithms.sorting.quicksort;
import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSortIntegerPivotLastKthOddElement {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		int arrayLength = Integer.parseInt(stdin.nextLine());
		int index = Integer.parseInt(stdin.nextLine());
		String inputValues = stdin.nextLine();
		int[] inputArray = Arrays.stream(inputValues.split(" ")).mapToInt(Integer::parseInt).toArray();
		
		printKthSmallestOddElement(inputArray, index);
	}
	
	public static void printKthSmallestOddElement(int[] inputArray, int kthIndex) {
		
		if(kthIndex > inputArray.length) {
			System.out.println("Invalid input");
			return;
		}
		
		int kElement = getKthSmallestOddElement(inputArray, 0, inputArray.length-1, kthIndex);
		
		if(kElement % 2 == 0) {
			System.out.println("Array does not have that many odd numbers");
		}else {
			System.out.println("Kth Smallest Element : "+ kElement);
		}
		
		
		
	}
	
	public static int getKthSmallestOddElement(int[] inputArray, int low, int high, int kthIndex) {
			int partition = partition(inputArray, low, high);
			
			if(partition == kthIndex-1) {
				return inputArray[partition];
			}else if(partition < kthIndex-1) {
				return getKthSmallestOddElement(inputArray, partition + 1, high, kthIndex);
			}else {
				return getKthSmallestOddElement(inputArray, low, partition - 1, kthIndex);
			}
	}
	
	public static int partition(int[] inputArray, int low, int high) {
		
		int pivot = inputArray[high];
		int i= low - 1;
		for(int j = low;j<= high; j++) {
			
			if(inputArray[j] % 2 == 0) {
				continue;
			}
			if(inputArray[j] < pivot) {
				i++;
				swap(inputArray, i, j);
			}
		}
		swap(inputArray, i+1, high);
		return i+1;
	}
	
	public static void swap(int[] inputArray, int index1, int index2) {
		int temp = inputArray[index1];
		inputArray[index1] = inputArray[index2];
		inputArray[index2] = temp;
	}
}
