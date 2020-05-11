package org.jagan.solutions.arrays;

import java.util.Arrays;

import org.jagan.sorting.SortUtil;

public class MoveZeroes {

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

	public static void moveZeroes(int[] arr) {
		for(int i = 0, j = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				SortUtil.swap(arr, i, j);
				j++;
			}
		}
	}
	
	public static void moveZeroesFirstAndRetainOrder(int[] arr) {
		for(int i = arr.length - 1, j = arr.length - 1; i >= 0; i--) {
			if(arr[i] != 0) {
				SortUtil.swap(arr, i, j);
				j--;
			}
		}
	}
}
