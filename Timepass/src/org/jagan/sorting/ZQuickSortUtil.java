package org.jagan.sorting;

import java.util.Arrays;

public class ZQuickSortUtil {
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 12, 13, 7, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr, int low, int high) {
		if(low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}
	
	public static int partition(int[] arr, int low, int high) {
		int i = low;
		int pivot = arr[high];
		for(int j = low ; j < high; j++) {
			if(arr[j] < pivot) {
				SortUtil.swap(arr, i, j);
				i++;
			}
		}
		SortUtil.swap(arr, i, high);
		return i;
	}
}
