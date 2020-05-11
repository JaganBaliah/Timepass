package org.jagan.solutions.arrays;

import java.util.Arrays;

import org.jagan.sorting.SortUtil;

public class ZRemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4};
		System.out.println("Input Array : " + Arrays.toString(arr));
		int newLen = removeDuplicates(arr);
		System.out.println("New Length : " + newLen);
		System.out.println("Input Array : " + Arrays.toString(arr));
	}
	
	private static int removeDuplicates(int[] arr) {
		int i = 0;
		for(int j = 1; j < arr.length; j++) {
			if(arr[j] != arr[i]) {
				i++;
				if(i != j) SortUtil.swap(arr, i, j);
			}
		}
		return i + 1;
	}
}
