package org.jagan.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ZBucketSortUtil {
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 12, 13, 7, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		int[] hash = getHash(arr);
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new List[hash[1]];
		for(int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		for(int val : arr) {
			int bucketIndex = getBucketIndex(val, hash);
			buckets[bucketIndex].add(val);
		}
		for(List<Integer> bucket : buckets) Collections.sort(bucket);
		int i = 0;
		for(List<Integer> bucket : buckets) {
			for(Integer entry : bucket) {
				arr[i++] = entry;
			}
		}
	}
	
	public static int getBucketIndex(int val, int[] hash) {
		return (val/hash[0]) * (hash[1] - 1);
	}
	
	public static int[] getHash(int[] arr) {
		int max = arr[0];
		for(int val : arr) if(val > max) max = val;
		return new int[] {max, (int)Math.sqrt(arr.length)};
	}
}
