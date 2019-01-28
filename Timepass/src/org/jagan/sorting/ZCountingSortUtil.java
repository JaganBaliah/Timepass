package org.jagan.sorting;

import java.util.Arrays;

public class ZCountingSortUtil {

	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr){
		int max = arr[0];
		for(int i = 0; i < arr.length; i++) if(arr[i] > max) max = arr[i];
		int[] countArr = new int[max + 1];
		for(int val : arr) countArr[val]++;
		for(int i = 1; i < countArr.length; i++) countArr[i]+=countArr[i-1];
		int[] output = new int[arr.length];
		for(int i = arr.length - 1; i >= 0; i--) {
			output[--countArr[arr[i]]] = arr[i];
		}
		for(int i = 0; i < arr.length; i++) arr[i] = output[i];
	}
}
