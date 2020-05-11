package org.jagan.sorting;

import java.util.Arrays;

public class ZBubbleSortUtil {
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 12, 13, 7, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr){
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1 -i; j++) {
				if(arr[j] > arr[j+1]) SortUtil.swap(arr, j, j+1);
			}
		}
	}	
}
