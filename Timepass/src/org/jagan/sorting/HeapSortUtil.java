package org.jagan.sorting;

import java.util.Arrays;

public class HeapSortUtil {

	public static void main(String[] args) {
		int[] arr = {12, 11, 12, 13, 7, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int len = arr.length;
		for(int i = len/2 - 1; i >= 0; i--) heapify(arr, len, i);
		
		int j = len-1;
		while(j > 0) {
			swap(arr, 0, j);
			heapify(arr, j, 0);
			j--;
		}		
	}
	
	public static void heapify(int[] arr, int n, int i) {
		int j = 2 * i + 1;
		int k = 2 * i + 2;
		int largestIndex = i;
		
		if(j < n && arr[j] > arr[largestIndex]) largestIndex = j;
		if(k < n && arr[k] > arr[largestIndex]) largestIndex = k;
		if(i != largestIndex) {
			swap(arr, i, largestIndex);
			heapify(arr, n, largestIndex);
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
	}
	
}
