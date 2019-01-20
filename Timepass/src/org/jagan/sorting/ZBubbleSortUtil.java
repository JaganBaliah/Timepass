package org.jagan.sorting;

import java.util.Arrays;

public class ZBubbleSortUtil {

	public static void main(String[] args) {
		Integer[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.asList(arr));
		sort1(arr);
		System.out.println(Arrays.asList(arr));
		arr = new Integer[]{12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.asList(arr));
		sort2(arr);
		System.out.println(Arrays.asList(arr));
	}

	public static void sort1(Integer[] arr){
		int len = arr.length;
		while(len > 1) {
			for(int i = 0; i < len - 1; i++) {
				if(arr[i] > arr[i+1]) swap(arr, i, i+1);
			}
			len--;
		}
	}

	public static void sort2(Integer[] arr){
		int len = arr.length;
		for(int i = 1; i < len; i++) {
			for(int j = 0; j < len - i; j++) {
				if(arr[j] > arr[j+1]) swap(arr, j, j+1);
			}
		}
	}
	
	private static void swap(Integer[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
