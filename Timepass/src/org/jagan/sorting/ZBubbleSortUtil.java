package org.jagan.sorting;

import java.util.Arrays;

public class ZBubbleSortUtil {

	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr){
		int len = arr.length;
		int i = 0;
		while(i < len - 1) {
			for(int j  = 0; j < len - i - 1; j++) {
				if(arr[j] > arr[j+1]) SortUtil.swap(arr, j, j+1);			
			}
			i++;
		}
	}

}
