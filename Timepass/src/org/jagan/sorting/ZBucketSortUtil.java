package org.jagan.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ZBucketSortUtil {
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 12, 13, 7, 5, 6, 7, 4, 1, 3, 8};
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
			int i = getIndex(val, hash);
			buckets[i].add(val);
		}
		for(int i = 0; i < buckets.length; i++) {
			Collections.sort(buckets[i]);
			System.out.println(buckets[i].size());
		}
		int i = 0;
		for(List<Integer> bucket : buckets) {
			for(int val : bucket) arr[i++] = val;
		}
	}
	
	public static int[] getHash(int[] arr) {
		return new int[] {SortUtil.getMax(arr), (int)Math.sqrt(arr.length)};
	}
	
	public static int getIndex(int val, int[] hash) {
		double factor = (double)val/hash[0];
		double index = factor * (hash[1] - 1);
		return (int)index;
	}
}
