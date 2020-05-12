package org.jagan.solutions.az;

import java.util.Arrays;

public class TwoSumUniquePairs {

	/*
	 * 
	 * Given an int array nums and an int target, find how many unique pairs in the
	 * array such that their sum is equal to target. Return the number of pairs.
	 * 
	 * Example 1:
	 * Input: nums = [1, 1, 2, 45, 46, 46], target = 47 
	 * Output: 2 
	 * Explanation: 1 + 46 = 47 2 + 45 = 47 
	 *
	 * Example 2:
	 * Input: nums = [1, 1], target = 2 
	 * Output: 1 
	 * Explanation: 1 + 1 = 2 
	 * 
	 * Example 3:
	 * Input: nums = [1, 5, 1, 5], target = 6 
	 * Output: 1 
	 * Explanation: [1, 5] and [5, 1] are considered the same.
	 * 
	 */
	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 45, 46, 46};
		System.out.println("Input : " + Arrays.toString(nums));
		System.out.println("Output : " + uniquePairs(nums, 47));
		
	}

	public static int uniquePairs(int[] nums, int target) {
		int count = 0;
		int i = 0;
		int j = nums.length - 1;
		Arrays.sort(nums);
		while(i < j) {
			int sum = nums[i] + nums[j];
			if(sum < target) {
				i++;
			} else if(sum > target) {
				j--;
			} else {
				count++;
				i++;
				j--;
				while(i < j && nums[i] == nums[i-1]) i++;
				while(i < j && nums[j] == nums[j+1]) j--;
			}
		}
		return count;
	}

}
