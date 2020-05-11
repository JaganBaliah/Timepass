package org.jagan.sorting;

import java.util.Arrays;

public class ZCountingSortUtil {

	public static void main(String[] args) {
		int[] arr = {12, 11, 12, 13, 7, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		int max = SortUtil.getMax(arr);
		int[] cArr = new int[max + 1];
		for(int val : arr) ++cArr[val];
		for(int i = 1; i < cArr.length; i++) cArr[i] += cArr[i-1];
		int[] tArr = new int[arr.length];
		for(int i = arr.length - 1 ; i>= 0; i--) {
			tArr[--cArr[arr[i]]] = arr[i];
		}
		for(int i = 0; i < arr.length;i ++) arr[i] = tArr[i];
	}
}
