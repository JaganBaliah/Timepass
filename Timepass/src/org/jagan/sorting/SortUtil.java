package org.jagan.sorting;

public class SortUtil {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int getMax(int[] arr) {
		int max = arr[0];
		for(int val : arr) if(val > max) max = val;
		return max;		
	}

}
