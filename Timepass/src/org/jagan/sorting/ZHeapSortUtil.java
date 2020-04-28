package org.jagan.sorting;

import java.util.Arrays;

public class ZHeapSortUtil {
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 12, 13, 7, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int len = arr.length;
		for(int i = len / 2; i >= 0; i--) {
			heapify(arr, len, i);
		}
		int j = len - 1;
		while(j >= 0) {
			SortUtil.swap(arr, 0, j);
			heapify(arr, j, 0);
			j--;
		}
	}
	
	public static void heapify(int[] arr, int len, int i) {
		int j = 2 * i + 1;
		int k = 2 * i + 2;
		int maxIndex = i;
		if(j < len && arr[j] > arr[maxIndex]) maxIndex = j;
		if(k < len && arr[k] > arr[maxIndex]) maxIndex = k;
		if(i != maxIndex) {
			SortUtil.swap(arr, maxIndex, i);
			heapify(arr, len, maxIndex);
		}
	}
	
} 
