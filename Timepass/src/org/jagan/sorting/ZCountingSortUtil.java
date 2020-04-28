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
		int max = arr[0];
		for(int val : arr) if(val > max) max = val;
		int[] countArr = new int[max + 1];
		for(int val : arr) ++countArr[val];
		for(int i = 0 ; i < countArr.length - 1; i++) countArr[i+1] += countArr[i];
		int[] outputArr = new int[arr.length];
		for(int i = arr.length - 1; i >= 0; i--) {
			outputArr[--countArr[arr[i]]] = arr[i];
		}
		for(int i = 0 ; i < arr.length; i++) arr[i] = outputArr[i];
	}
}
