package org.jagan.sorting;

import java.util.Arrays;

public class ZInsertionSortUtil {
	
	public static void main(String[] args) {
		Integer[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.asList(arr));
		sort(arr);
		System.out.println(Arrays.asList(arr));
	}

	public static void sort(Integer[] arr){
		int len = arr.length;
		int i, j, key;
		for(i = 1; i < len; i++) {
			key = arr[i];
			j = i - 1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}		
	}

}
