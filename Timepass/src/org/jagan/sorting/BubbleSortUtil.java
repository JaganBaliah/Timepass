package org.jagan.sorting;

import java.util.Arrays;

public class BubbleSortUtil {
	public static void main(String[] args) {
		int[] arr = {12, 11, 12, 13, 7, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int len = arr.length;
		int i = 0;
		while(i < len - 1) {		
			for(int j = 0; j < len - i - 1; j++) {
				if(arr[j] > arr[j+1]) swap(arr, j, j+1);
			}
			i++;
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
	}
}
