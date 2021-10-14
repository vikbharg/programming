package algorithms.sorting.quicksort;
import java.io.BufferedInputStream;
import java.util.Scanner;

public class QuickSortFloatPivotLastKthOddElement {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		int numberOfElements = Integer.parseInt(stdin.nextLine());
		int index = Integer.parseInt(stdin.nextLine());
		
		float inputArray[] = new float[numberOfElements];
		for(int i=0;i<numberOfElements;i++) {
			inputArray[i] = stdin.nextFloat();
		}
		
		printKthSmallestOddElement(inputArray, index);
	}
	
	public static void printKthSmallestOddElement(float[] inputArray, int kthIndex) {
		
		if(kthIndex > inputArray.length) {
			System.out.println("Invalid input");
			return;
		}
		
		float kElement = getKthSmallestOddElement(inputArray, 0, inputArray.length-1, kthIndex);
		
		if(isEven(String.valueOf(kElement))) {
			System.out.println("Array does not have that many odd numbers");
		}else {
			System.out.println("Kth Smallest Element : "+ kElement);
		}
		
		
		
	}
	
	public static float getKthSmallestOddElement(float[] inputArray, int low, int high, int kthIndex) {
			int partition = partition(inputArray, low, high);
			
			if(partition == kthIndex-1) {
				return inputArray[partition];
			}else if(partition < kthIndex-1) {
				return getKthSmallestOddElement(inputArray, partition + 1, high, kthIndex);
			}else {
				return getKthSmallestOddElement(inputArray, low, partition - 1, kthIndex);
			}
	}
	
	public static int partition(float[] inputArray, int low, int high) {
		
		float pivot = inputArray[high];
		int i= low - 1;
		for(int j = low;j<= high; j++) {
			
			if(isEven(String.valueOf(inputArray[j]))) {
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
	
	public static void swap(float[] inputArray, int index1, int index2) {
		float temp = inputArray[index1];
		inputArray[index1] = inputArray[index2];
		inputArray[index2] = temp;
	}
	
	public static boolean isEven(String s1)
    {
        int l = s1.length();
        char[] s = s1.toCharArray();
 
        // Loop to traverse number from LSB
        boolean dotSeen = false;
        for (int i = l - 1; i >= 0; i--) {
 
            // We ignore trailing 0s after dot
            if (s[i] == '0' && dotSeen == false)
                continue;
 
            // If it is '.' we will check next digit and it
            // means decimal part is traversed.
            if (s[i] == '.') {
                dotSeen = true;
                continue;
            }
 
            // If digit is divisible by 2
            // means even number.
            if ((s[i] - '0') % 2 == 0)
                return true;
 
            return false;
        }
 
        return false;
    }
}
