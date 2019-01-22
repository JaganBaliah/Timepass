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

	public static void sort(int[] arr){
		int code[] = hash(arr);
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new ArrayList[code[1]];
		for(int i = 0; i < buckets.length; i++) buckets[i] = new ArrayList<Integer>();
		for(int value : arr) {
			int index = getBucketIndex(value, code);
			buckets[index].add(value);
		}
		for(List<Integer> bucket : buckets) {
			Collections.sort(bucket);			
		}
		
		int i = 0;
		for(List<Integer> bucket : buckets) {
			for(Integer entry : bucket) arr[i++] = entry;			
		}		
	}
	
	private static int getBucketIndex(int value, int[] code) {
		return (value / code[0]) * (code[1] - 1);
	}
	
	private static int[] hash(int[] arr) {
		int max = arr[0];
		int len = arr.length;
		for(int i = 1; i < len; i++) {
			if(arr[i] > max) max = arr[i];
		}
		return new int[] {max, (int)Math.sqrt(len)};
	}
}
