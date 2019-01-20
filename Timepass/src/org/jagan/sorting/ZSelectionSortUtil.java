package org.jagan.sorting;

import java.util.Arrays;

public class ZSelectionSortUtil {

	public static void main(String[] args) {
		Integer[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.asList(arr));
		sort(arr);
		System.out.println(Arrays.asList(arr));
	}

	public static void sort(Integer[] arr){
		int len = arr.length;
		int k = 0;
		while(k < len) {
			int minIndex = k;
			for(int i = k+1; i < len; i++) {
				if(arr[i] < arr[minIndex]) minIndex = i; 
			}
			if(minIndex != k) swap(arr, minIndex, k);
			k++;
		}
	}

	private static void swap(Integer[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}