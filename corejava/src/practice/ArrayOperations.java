package practice;

import java.util.Arrays;
import java.util.Iterator;



public class ArrayOperations {
	public static void main(String[] args) {
//		int [] arr = {1,2,3,4,5};
//		swap(arr,1,4);
//		System.out.println(Arrays.toString(arr));
//		
//	}
//	static void swap(int[] arr, int index1, int index2) {
//		int temp = arr[index1];
//		arr[index1]= arr[index2];
//		arr[index2]=temp;
		
		
		int[]arr = {1,2,21,31};
		System.out.println(max(arr));
	}
	
	// imagine that arr is not empty
	static int max(int[]arr) {
		int maxVal = arr[0];
	for (int i = 1; i < arr.length; i++) {
		if (arr[i] > maxVal) {
			maxVal=arr[i];
		}
		
	}
	return maxVal;
		
	}
}
