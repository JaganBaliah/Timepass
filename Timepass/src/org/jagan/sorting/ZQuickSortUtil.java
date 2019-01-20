package org.jagan.sorting;

import java.util.Arrays;

public class ZQuickSortUtil {

	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
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
		int i = low - 1;
		int pivot = arr[high];
		for(int j = low; j < high; j++) {
			if(arr[j] <= pivot) {
				i++;
				swap(arr, j , i);
			}			
		}
		i++;
		swap(arr, i, high);
		return i;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
	}

}
