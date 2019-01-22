package org.jagan.sorting;

import java.util.Arrays;

public class ZRadixSortUtil {

	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr){
		int max = arr[0];
		for(int val : arr) {
			if(val > max) max = val;
		}
		for(int exp = 1; max/exp > 0; exp *= 10) {
			countSort(arr, exp);			
		}
	}
	
	private static void countSort(int[] arr, int exp) {
		int[] countArr = new int[10];
		int len = arr.length;
		for(int val : arr) 	countArr[(val/exp) % 10]++;
		for(int i = 1; i < countArr.length; i++) countArr[i] += countArr[i - 1];
		int[] outputArr = new int[len];
		for(int i = len - 1; i >= 0; i--) {
			outputArr[--countArr[(arr[i] / exp) % 10]] = arr[i];
		}
		for(int i = 0; i < len; i++) arr[i] = outputArr[i];
	}
}
