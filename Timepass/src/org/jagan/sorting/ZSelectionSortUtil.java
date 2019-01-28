package org.jagan.sorting;

import java.util.Arrays;

public class ZSelectionSortUtil {
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr){
		int len = arr.length;
		for(int i = 0 ;i < len; i++) {
			int lowestIndex = i;
			for(int j = i + 1; j < len; j++) {
				if(arr[j] < arr[lowestIndex]) lowestIndex = j;
			}
			if(i != lowestIndex) SortUtil.swap(arr, i, lowestIndex);	
			
		}
	}
}