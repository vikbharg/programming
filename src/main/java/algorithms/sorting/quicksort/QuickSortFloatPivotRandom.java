package algorithms.sorting.quicksort;
import java.io.BufferedInputStream;
import java.util.Random;
import java.util.Scanner;

public class QuickSortFloatPivotRandom {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		int numberOfElements = 0;
		if (stdin.hasNext()) {
			numberOfElements = Integer.parseInt(stdin.nextLine());
		}
		
		float inputArray[] = new float[numberOfElements];
		for(int i=0;i<numberOfElements;i++) {
			inputArray[i] = stdin.nextFloat();
		}
		printSortedArray(inputArray);
	}
	
	public static void printSortedArray(float[] inputArray) {
		
		performQuickSort(inputArray, 0, inputArray.length-1);
		System.out.println("Sorted Array : ");
		for(float i: inputArray) {
			System.out.print(i + " ");
		}
	}
	
	public static void performQuickSort(float[] inputArray, int low, int high) {
		
		if(low < high) {
			int partition = partition(inputArray, low, high);
			
			performQuickSort(inputArray, low, partition - 1);
			performQuickSort(inputArray, partition + 1, high);
			
		}
	}
	
	public static int partition(float[] inputArray, int low, int high) {
		
		random(inputArray, low, high);
		float pivot = inputArray[high];
		int i= low - 1;
		for(int j = low;j<= high; j++) {
			
			if(Float.compare(inputArray[j], pivot) < 0) {
				i++;
				swap(inputArray, i, j);
			}
		}
		swap(inputArray, i+1, high);
		return i+1;
	}
	
	public static void swap(float[] inputArray, int index1, int index2) {
		float temp = inputArray[index1];
		inputArray[index1] = inputArray[index2];
		inputArray[index2] = temp;
	}
	
	public static void random(float inputArray[],int low,int high)
    {
     
        Random rand= new Random();
        int pivot = (low+high)/2;
        if((high-low)!= 0) {
        	pivot = rand.nextInt(high-low)+low;
        }
         
        float temp1=inputArray[pivot]; 
        inputArray[pivot]=inputArray[high];
        inputArray[high]=temp1;
    }
}
