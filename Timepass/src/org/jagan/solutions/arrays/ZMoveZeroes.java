package org.jagan.solutions.arrays;

import java.util.Arrays;

import org.jagan.sorting.SortUtil;

public class ZMoveZeroes {

	public static void main(String[] args) {
		int[] arr = new int[] {2, 0, 1, 0, 0, 3, 0};
		System.out.println("Input Array : " + Arrays.toString(arr));
		moveZeroes(arr);
		System.out.println("Output Array : " + Arrays.toString(arr));
		
		arr = new int[] {2, 0, 1, 0, 0, 3, 0};
		System.out.println("Input Array : " + Arrays.toString(arr));
		moveZeroesFirstAndRetainOrder(arr);
		System.out.println("Output Array : " + Arrays.toString(arr));
	}

	public static void moveZeroesFirstAndRetainOrder(int[] arr) {
		int len = arr.length, i = len - 1, j = len - 1;
		while(j >= 0) {
			if(arr[j] != 0) SortUtil.swap(arr, i--, j); 
			j--;
		}
	}

	public static void moveZeroes(int[] arr) {
		int i = 0;
		for(int j = 0; j < arr.length; j++) {
			if(arr[j] != 0) {
				SortUtil.swap(arr, i, j);
				i++;
			}
		}
	}
	
}
