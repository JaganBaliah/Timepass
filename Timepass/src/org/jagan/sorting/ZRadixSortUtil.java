package org.jagan.sorting;

import java.util.Arrays;

public class ZRadixSortUtil {
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void sort(int[] arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) if(arr[i] > max) max = arr[i];
		for(int exp = 1; max/exp > 0; exp *= 10) {
			countSort(arr, exp);
		}
	}
	
	private static void countSort(int[] arr, int exp) {
		int[] countArr = new int[10];
		for(int val : arr) countArr[val/exp % 10]++;
		for(int i = 1; i < countArr.length; i++) countArr[i]+=countArr[i-1];
		int[] outArr = new int[arr.length];
		for(int i = arr.length - 1; i >= 0; i--) outArr[--countArr[(arr[i]/exp) % 10]] = arr[i];
		for(int i = 0; i < arr.length; i++) arr[i] = outArr[i];
	}
}
