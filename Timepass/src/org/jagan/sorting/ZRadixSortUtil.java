package org.jagan.sorting;

import java.util.Arrays;

public class ZRadixSortUtil {
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 12, 13, 7, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		int max = arr[0];
		for(int val : arr) if(val > max) max = val;
		for(int exp = 1; max/exp > 0; exp *= 10) {
			countSort(arr, exp);
		}
	}
	
	public static void countSort(int[] arr, int exp) {
		int[] countArr = new int[10];
		for(int i = 0; i < arr.length; i++) ++countArr[(arr[i]/exp) % 10];
		for(int i = 0; i < countArr.length - 1; i++) countArr[i+1] += countArr[i];
		int[] outputArr = new int[arr.length];
		for(int i = arr.length - 1; i >= 0; i--) outputArr[--countArr[(arr[i]/exp) % 10]] = arr[i];
		for(int i = 0; i < arr.length; i++) arr[i] = outputArr[i];
	}
}
