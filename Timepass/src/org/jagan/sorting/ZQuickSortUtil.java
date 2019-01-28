package org.jagan.sorting;

import java.util.Arrays;

public class ZQuickSortUtil {
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void sort(int[] arr, int low, int high) {
		if(low < high) {
			int pi = pivot(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}
	
	private static int pivot(int[] arr, int low, int high) {
		int key = arr[high];
		int i = low;
		for(int j = low; j < high; j++) {
			if(arr[j] <= key) SortUtil.swap(arr, i++, j);			
		}
		SortUtil.swap(arr, i, high);
		return i;		
	}
}
