package org.jagan.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<Integer, Integer> countMap = new HashMap<>();
		for(int num : nums) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}
		/*
		Queue<Integer> queue = new PriorityQueue<Integer>((n1, n2) -> countMap.get(n1) - countMap.get(n2));
		for(Integer val : countMap.keySet()) {
			queue.offer(val);
			if(queue.size() > k) queue.poll();
		}
		return queue.toArray(new Integer[k]);
		*/
		List<Integer> keys = new ArrayList<>(countMap.keySet());
		Collections.sort(keys, (n1, n2) -> {
			return countMap.get(n2) - countMap.get(n1);
		});
		Integer[] rtnVal = new Integer[k];
		for(int i = 0; i < k; i++) {
			rtnVal[i] = keys.get(i);
		}
		return rtnVal;
	}
}
