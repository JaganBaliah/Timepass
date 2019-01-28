package org.jagan.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ZBucketSortUtil {
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void sort(int[] arr) {
		int[] code = hash(arr);
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new List[code[1]];
		for(int i = 0 ; i < buckets.length; i++) buckets[i] = new ArrayList<Integer>();
		for(int val : arr) {
			int bucketIdex = getBucketIndex(val, code);
			buckets[bucketIdex].add(val);
		}
		for(List<Integer> bucket : buckets) Collections.sort(bucket);
		int i = 0;
		for(List<Integer> bucket : buckets) {
			for(int val : bucket) arr[i++] = val;
		}	
	}
	
	private static int getBucketIndex(int val, int[] code) {
		return (val/code[0]) * (code[1] - 1); 
	}
	
	private static int[] hash(int[] arr) {
		int len = arr.length;
		int max = arr[0];
		for(int i = 1; i < len; i++) if(arr[i] > max) max = arr[i];
		return new int[] {max, (int)Math.sqrt(len)};
	}
	
}
