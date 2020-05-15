package org.jagan.solutions;

import java.util.Arrays;

public class ZTopKFrequentElements {

	/*
	 * Given a non-empty array of integers, return the k most frequent elements.
	 * 
	 * Example 1:
	 * Input: nums = [1,1,1,2,2,3], k = 2 
	 * Output: [1,2] 
	 * 
	 * Example 2:
	 * Input: nums = [1], k = 1 
	 * Output: [1]
	 *
	 */
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		System.out.println("Top 2 Frequent Elements : " + Arrays.toString(topKFrequent(nums, 2)));
		nums = new int[]{1};
		System.out.println("Top 2 Frequent Elements : " + Arrays.toString(topKFrequent(nums, 1)));
	}
	
	public static Integer[] topKFrequent(int[] nums, int k) {
		return null;
	}
}
