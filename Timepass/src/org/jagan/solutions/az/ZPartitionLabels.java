package org.jagan.solutions.az;

import java.util.List;

public class ZPartitionLabels {

	/*
	 * 
	 * A string S of lowercase letters is given. We want to partition this string
	 * into as many parts as possible so that each letter appears in at most one
	 * part, and return a list of integers representing the size of these parts.
	 * 
	 * Example 1: 
	 * 
	 * Input	: S = "ababcbacadefegdehijhklij" 
	 * Output	: [9,7,8] 
	 * Explanation:
	 * The partition is "ababcbaca", "defegde", "hijhklij". This is a partition so
	 * that each letter appears in at most one part. A partition like
	 * "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less
	 * parts.
	 * 
	 * Note: S will have length in range [1, 500]. S will consist of lowercase
	 * letters ('a' to 'z') only.
	 * 
	 */
	public static void main(String[] args) {
		String input = "ababcbacadefegdehijhklij";
		System.out.println("Input : " + input);
		System.out.println("Output : " + partitionLabels(input));
		
		input = "ababcbacadefegdehijhklij";
		System.out.println("Input : " + input);
		System.out.println("Output : " + partitionLabels1(input));
	}

	public static List<Integer> partitionLabels1(String input) {
		return null;
	}

	public static List<Integer> partitionLabels(String S) {
		return null;
	}
}
