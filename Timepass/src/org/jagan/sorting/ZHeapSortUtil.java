package org.jagan.sorting;

import java.util.Arrays;

public class ZHeapSortUtil {
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		int len = arr.length;
		for(int i = (len + 1)/2; i >= 0; i--) {
			heapify(arr, len, i);
		}
		
		int j = len - 1;
		while(j > 0) {
			SortUtil.swap(arr, 0, j);			
			heapify(arr, j, 0);
			j--;
		}
	}
	
	public static void heapify(int[] arr, int n, int i) {
		int j = 2*i + 1;
		int k = 2*i + 2;
		int highestIndex = i;
		if(j < n && arr[j] > arr[highestIndex]) highestIndex = j;
		if(k < n && arr[k] > arr[highestIndex]) highestIndex = k;
		
		if(highestIndex != i) {
			SortUtil.swap(arr, highestIndex, i);
			heapify(arr, n, highestIndex);
		}
	}
} 
