package org.jagan.sorting;

import java.util.Arrays;

public class ZSelectionSortUtil {
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 12, 13, 7, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for(int j = i; j < arr.length; j++) {
				if(arr[j] < arr[min]) min = j;
			}
			SortUtil.swap(arr, i, min);
		}
	}
	
}