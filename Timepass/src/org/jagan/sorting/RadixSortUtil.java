package org.jagan.sorting;

import java.util.Arrays;

public class RadixSortUtil {

	public static void main(String[] args) {
		int[] arr = {12, 11, 12, 13, 7, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		int max = getMax(arr);
		for(int exp = 1; max/exp > 0; exp *= 10) {
			countSort(arr, exp);
		}
	}

	private static void countSort(int[] arr, int exp) {
		int len = arr.length;
		int[] outputArr = new int[len];
		int[] countArr = new int[10];
		Arrays.fill(countArr, 0);
		for(int i = 0; i < len; i++) ++countArr[getIndex(arr[i], exp)];
		for(int i = 1; i < 10; i++) countArr[i] += countArr[i - 1];
		for(int i = len - 1; i >= 0; i--) outputArr[--countArr[getIndex(arr[i], exp)]] = arr[i];
		for(int i = 0; i < len; i++) arr[i] = outputArr[i];		
	}

	private static int getIndex(int value, int exp) {
		return (value / exp) % 10;
	}
	private static int getMax(int[] arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) max = arr[i];
		}
		return max;
	}

}
