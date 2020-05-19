package org.jagan.solutions.az;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalUtilization {

	/*
	 * 
	 * Given 2 lists a and b. Each element is a pair of integers where the first
	 * integer represents the unique id and the second integer represents a value.
	 * Your task is to find an element from a and an element form b such that the
	 * sum of their values is less or equal to target and as close to target as
	 * possible. Return a list of ids of selected elements. If no pair is possible,
	 * return an empty list.
	 * 
	 * Example 1:
	 * Input: 
	 * 		a = [[1, 2], [2, 4], [3, 6]] 
	 * 		b = [[1, 2]] 
	 * 		target = 7
	 * Output: [[2, 1]]
	 * 
	 * Explanation: There are only three combinations [1, 1], [2, 1], and [3, 1],
	 * which have a total sum of 4, 6 and 8, respectively. Since 6 is the largest
	 * sum that does not exceed 7, [2, 1] is the optimal pair. 
	 * 
	 * 
	 * Example 2:
	 * Input: 
	 * 		a = [[1, 3], [2, 5], [3, 7], [4, 10]] 
	 * 		b = [[1, 2], [2, 3], [3, 4], [4, 5]] 
	 * 		target = 10
	 * Output: [[2, 4], [3, 2]]
	 * 
	 * Explanation: There are two pairs possible. Element with id = 2 from the list
	 * `a` has a value 5, and element with id = 4 from the list `b` also has a value
	 * 5. Combined, they add up to 10. Similarly, element with id = 3 from `a` has
	 * a value 7, and element with id = 2 from `b` has a value 3. These also add up
	 * to 10. Therefore, the optimal pairs are [2, 4] and [3, 2]. 
	 * 
	 * 
	 * Example 3:
	 * Input: 
	 * 		a = [[1, 8], [2, 7], [3, 14]] 
	 * 		b = [[1, 5], [2, 10], [3, 14]] 
	 * 		target = 20
	 * Output: [[3, 1]] 
	 * 
	 * 
	 * Example 4:
	 * Input: 
	 * 		a = [[1, 8], [2, 15], [3, 9]] 
	 * 		b = [[1, 8], [2, 11], [3, 12]] 
	 * 		target = 20
	 * Output: [[1, 3], [3, 2]]
	 * 
	 */
	public static void main(String[] args) {
		List<int[]> a = new ArrayList<int[]>();
		a.add(new int[]{1, 2});
		a.add(new int[]{2, 4});
		a.add(new int[]{3, 6});
		List<int[]> b = new ArrayList<int[]>();
		b.add(new int[]{1, 2});
		int t = 7;
		printInput(a, b, t);
		List<int[]> output = solution1(a, b, t);
		printOutput(output);
		
		a = new ArrayList<int[]>();
		a.add(new int[]{1, 3});
		a.add(new int[]{2, 5});
		a.add(new int[]{3, 7});
		a.add(new int[]{4, 10});
		b = new ArrayList<int[]>();
		b.add(new int[]{1, 2});
		b.add(new int[]{2, 3});
		b.add(new int[]{3, 4});
		b.add(new int[]{4, 5});
		t = 10;
		printInput(a, b, t);
		output = solution1(a, b, t);
		printOutput(output);
		
		a = new ArrayList<int[]>();
		a.add(new int[]{1, 8});
		a.add(new int[]{2, 7});
		a.add(new int[]{3, 14});
		b = new ArrayList<int[]>();
		b.add(new int[]{1, 5});
		b.add(new int[]{2, 10});
		b.add(new int[]{3, 14});
		t = 20;
		printInput(a, b, t);
		output = solution1(a, b, t);
		printOutput(output);

		a = new ArrayList<int[]>();
		a.add(new int[]{1, 8});
		a.add(new int[]{2, 15});
		a.add(new int[]{3, 9});
		b = new ArrayList<int[]>();
		b.add(new int[]{1, 8});
		b.add(new int[]{2, 11});
		b.add(new int[]{3, 12});
		t = 20;
		printInput(a, b, t);
		output = solution1(a, b, t);
		printOutput(output);
	}

	public static List<int[]> solution(List<int[]> aList, List<int[]> bList, int target) {
		Map<Integer, List<int[]>> sumMap = new HashMap<>();
		for(int i = 0; i < aList.size(); i++) {
			for(int j = 0; j < bList.size(); j++) {
				int[] aEntry = aList.get(i);
				int[] bEntry = bList.get(j);
				int sumVal = aEntry[1] + bEntry[1];
				if(sumVal <= target) {
					List<int[]> sumKeys = sumMap.getOrDefault(sumVal, new ArrayList<int[]>());
					sumKeys.add(new int[] {aEntry[0], bEntry[0]});
					sumMap.put(sumVal, sumKeys);
				}
			}
		}
		int maxVal = 0;
		for(Integer sumVal : sumMap.keySet()) {
			if(sumVal == target) return sumMap.get(sumVal);
			if(sumVal > maxVal) maxVal = sumVal;
		}
		return sumMap.get(maxVal);
	}
	
	public static List<int[]> solution1(List<int[]> aList, List<int[]> bList, int target) {
		List<int[]> rtnVal = new ArrayList<int[]>();
		Collections.sort(aList, (a1, a2) -> a1[1] - a2[1]);
		Collections.sort(bList, (b1, b2) -> b1[1] - b2[1]);
		int aSize = aList.size();
		int bSize = bList.size();
		int a = 0;
		int b = bSize - 1;
		int max = 0;
		while(a < aSize && b >= 0) {
			int[] aEntry = aList.get(a);
			int[] bEntry = bList.get(b);
			int sumVal = aEntry[1] + bEntry[1];
			if(sumVal > target) {
				b--;
			} else {
				if(sumVal >= max) {
					if(sumVal > max) {
						max = sumVal;
						rtnVal.clear();
					}
				}
				rtnVal.add(new int[] {aEntry[0], bEntry[0]});
				int index = b;
				int val = bEntry[1];
				while(--index >= 0 && bList.get(index)[1] == val) {
					rtnVal.add(new int[] {aEntry[0], bList.get(index)[0]});
				}
				a++;
			}			
		}
		return rtnVal;
	}
	
	private static void printOutput(List<int[]> output) {
		System.out.println("Output : ");
		output.stream().forEach(e -> System.out.print(Arrays.toString(e)));
		System.out.println();
		System.out.println();
	}

	private static void printInput(List<int[]> a, List<int[]> b, int t) {
		System.out.println("Input a : ");
		a.stream().forEach(e -> System.out.print(Arrays.toString(e)));
		System.out.println();
		System.out.println("Input b : ");
		b.stream().forEach(e -> System.out.print(Arrays.toString(e)));
		System.out.println();
		System.out.println("Target : " + t);
	}
	
}
