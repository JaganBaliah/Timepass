package org.jagan.solutions.az;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	/*
	 * 
	 * Given an array of integers, return indices of the two numbers such that they
	 * add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 * 
	 * Example:
	 * 
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Output : " + Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 9)));
	}

	public static int[] twoSum(int[] nums, int target) {
        int[] rtnVal = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        for(int num : nums) {
            int pairVal = target - num;
            if(map.containsKey(pairVal)) {
                return new int[] {map.get(pairVal), i};
            }
            map.put(num, i++);
        }
        return rtnVal;
    }
}
