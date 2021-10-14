package algorithms.sorting.quicksort;
import java.io.BufferedInputStream;
import java.util.Random;
import java.util.Scanner;

public class QuickSortFloatPivotRandomKthElement {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		int numberOfElements = Integer.parseInt(stdin.nextLine());
		int index = Integer.parseInt(stdin.nextLine());
		
		float inputArray[] = new float[numberOfElements];
		for(int i=0;i<numberOfElements;i++) {
			inputArray[i] = stdin.nextFloat();
		}
		
		printKthSmallestElement(inputArray, index);
	}
	
	public static void printKthSmallestElement(float[] inputArray, int kthIndex) {
		
		if(kthIndex > inputArray.length) {
			System.out.println("Invalid input");
			return;
		}
		
		float kElement = getKthSmallestElement(inputArray, 0, inputArray.length-1, kthIndex);
		System.out.println("Kth Smallest Element : "+ kElement);
		
	}
	
	public static float getKthSmallestElement(float[] inputArray, int low, int high, int kthIndex) {
			int partition = partition(inputArray, low, high);
			
			if(partition == kthIndex-1) {
				return inputArray[partition];
			}else if(partition < kthIndex-1) {
				return getKthSmallestElement(inputArray, partition + 1, high, kthIndex);
			}else {
				return getKthSmallestElement(inputArray, low, partition - 1, kthIndex);
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
	
	public static void random(float inputArray[],int low,int high) {
	     
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
