package org.jagan.solutions.az;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	/*
	 * 
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * Example 1:
	 * 
	 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
	 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
	 * 
	 * Example 2:
	 * 
	 * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5]
	 * are considered overlapping. 
	 * 
	 * NOTE: input types have been changed on April 15, 2019. 
	 * Please reset to default code definition to get new method signature.
	 * 
	 */
	public static void main(String[] args) {
		int[][] intervals = new int[][] {
			{1, 3},
			{2, 6},
			{8, 10},
			{15, 18}
		};
		System.out.println("Input : " + Arrays.deepToString(intervals));
		int[][] output = merge(intervals);
		System.out.println("Output : " + Arrays.deepToString(output));
		
		intervals = new int[][] {
			{1, 4},
			{4, 5}
		};
		System.out.println("Input : " + Arrays.deepToString(intervals));
		output = merge(intervals);
		System.out.println("Output : " + Arrays.deepToString(output));
	}
	
	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] lastInterval = intervals[0];
		result.add(lastInterval);
		for (int i = 1; i < intervals.length; i++) {
			int[] interval = intervals[i];
			if (interval[0] <= lastInterval[1]) // Overlapping intervals, move the end if needed
				lastInterval[1] = Math.max(lastInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				lastInterval = interval;
				result.add(lastInterval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}
	
	
}
