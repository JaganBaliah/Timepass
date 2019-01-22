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
		for(int val : arr) {
			if(val > max) max = val;
		}
		int[] countArr = new int[max + 1];
		for(int val : arr) 	countArr[val]++;
		for(int i = 1; i < countArr.length; i++) countArr[i] += countArr[i - 1];
		
		int len = arr.length;
		int[] outputArr = new int[len];
		for(int i = len -1; i >= 0 ; i--) {
			outputArr[countArr[arr[i]] - 1] = arr[i];
			countArr[arr[i]]--;
		}
		for(int i = 0; i < len; i++) arr[i] = outputArr[i];
	}
}
