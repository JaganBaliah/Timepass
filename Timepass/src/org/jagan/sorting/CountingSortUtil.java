package org.jagan.sorting;

import java.util.Arrays;

public class CountingSortUtil {

	public static void main(String[] args) {
		char[] arr = {'a', 'l', 'p', 'h', 'a', 'b', 'e', 't'};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(char[] arr) {
		int n = arr.length;
		char[] outputArr = new char[n];
		int[] countArr = new int[256];
		for(int i = 0; i < 256; i++) countArr[i] = 0;
		for(int i = 0; i < n; i++) {
			//++countArr[arr[i]];
			countArr[arr[i]] = countArr[arr[i]] + 1;
		}
		for(int i = 1; i < 256; i++) {
			//countArr[i] += countArr[i - 1];
			countArr[i] = countArr[i] + countArr[i - 1];
		}
		for(int i = n - 1; i >= 0; i--) {
			//outputArr[--countArr[arr[i]]] = arr[i];
			outputArr[countArr[arr[i]] - 1] = arr[i];
			countArr[arr[i]] = countArr[arr[i]] - 1;
		}
		System.out.println(Arrays.toString(outputArr));
	}
	
}
