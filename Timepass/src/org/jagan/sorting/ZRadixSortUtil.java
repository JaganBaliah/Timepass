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
		int max = SortUtil.getMax(arr);
		for(int exp = 1; max/exp > 0; exp *= 10) countSort(arr, exp);
	}
	
	public static void countSort(int[] arr, int exp) {
		int[] cArr = new int[10];
		int len = arr.length;
		for(int i = 0; i < len; i++) {
			int val = arr[i];
			int index = val/exp % 10;
			++cArr[index];
		}
		for(int i = 1; i < cArr.length; i++) cArr[i] += cArr[i - 1];
		int[] tArr = new int[len];
		for(int i = len - 1; i >= 0; i--) {
			int val = arr[i];
			int index = val/exp % 10;
			tArr[--cArr[index]] = val;
		}
		for(int i = 0; i < len; i++) arr[i] = tArr[i];
	}
	
}
