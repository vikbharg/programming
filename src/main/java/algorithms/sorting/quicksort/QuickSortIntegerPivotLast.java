package algorithms.sorting.quicksort;
import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSortIntegerPivotLast {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		int numberOfCases = 0;
		if (stdin.hasNext()) {
			numberOfCases = Integer.parseInt(stdin.nextLine());
		}
		String inputValues = stdin.nextLine();
		int[] inputArray = Arrays.stream(inputValues.split(" ")).mapToInt(Integer::parseInt).toArray();
		
		printSortArray(inputArray);
		//printKthSmallestElement(inputArray);
	}
	
	public static void printSortArray(int[] inputArray) {
		
		performQuickSort(inputArray, 0, inputArray.length-1);
		System.out.println("Sorted Array : ");
		for(int i: inputArray) {
			System.out.print(i + " ");
		}
	}
	
	public static void performQuickSort(int[] inputArray, int low, int high) {
		
		if(low < high) {
			int partition = partition(inputArray, low, high);
			
			performQuickSort(inputArray, low, partition - 1);
			performQuickSort(inputArray, partition + 1, high);
			
		}
	}
	
	public static int partition(int[] inputArray, int low, int high) {
		
		int pivot = inputArray[high];
		int i= low - 1;
		for(int j = low;j<= high; j++) {
			
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
