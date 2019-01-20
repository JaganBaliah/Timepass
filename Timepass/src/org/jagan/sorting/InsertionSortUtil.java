package org.jagan.sorting;

import java.util.Arrays;

public class InsertionSortUtil {

	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int len = arr.length;
		for(int i = 1; i < len; i++) {
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > key) {
				swap(arr, j, j+1);
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
	}

}