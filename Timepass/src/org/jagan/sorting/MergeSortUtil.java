package org.jagan.sorting;

import java.util.Arrays;

public class MergeSortUtil {

	public static void main(String[] args) {
		int[] arr = {12, 11, 12, 13, 7, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int l, int r) {
		if(l < r) {
			int m = (l + r)/2;
			sort(arr, l, m);
			sort(arr, m+1, r);
			merge(arr, l, m, r);
		}
	}
	
	public static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] N1 = new int[n1];
		int[] N2 = new int[n2];
		
		for(int i = 0; i < n1; i++) N1[i] = arr[l+i];
		for(int i = 0; i < n2; i++) N2[i] = arr[m+1+i];
		
		int k = l;
		int i = 0, j = 0;
		while(i < n1 && j < n2) {
			if(N1[i] <= N2[j]) {
				arr[k++] = N1[i++];
			} else {
				arr[k++] = N2[j++];
			}
		}
		while(i < n1) arr[k++] = N1[i++];
		while(j < n2) arr[k++] = N2[j++];
	}
}
