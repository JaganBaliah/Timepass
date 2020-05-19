package org.jagan.solutions.az;

import java.util.List;
import java.util.Set;

public class ZSubStringOfSizeKAndKDistinctChars {

	/*
	 * 
	 * Given a string s and an int k, return all unique substrings of s of size k
	 * with k distinct characters.
	 * 
	 * Example 1:
	 * Input: s = "abcabc", k = 3 
	 * Output: ["abc", "bca", "cab"] 
	 * 
	 * Example 2:
	 * Input: s = "abacab", k = 3 
	 * Output: ["bac", "cab"] 
	 * 
	 * Example 3:
	 * Input: s = "awaglknagawunagwkwagl", k = 4 
	 * Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
	 * Explanation: Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag",
	 * "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl" 
	 * "wagl" is repeated twice, but is included in the output once. 
	 * 
	 * Constraints:
	 * The input string consists of only lowercase English letters [a-z] 0 ≤ k ≤ 26
	 * 
	 */
	public static void main(String[] args) {
		String input = "abcabc";
		int k = 3;
		System.out.println("Input : " + input);
		System.out.println("Output : " + kSubstring(input, k));
		
		input = "abacab";
		k = 3;
		System.out.println("Input : " + input);
		System.out.println("Output : " + kSubstring(input, k));
		
		input = "awaglknagawunagwkwagl";
		k = 4;
		System.out.println("Input : " + input);
		System.out.println("Output : " + kSubstring(input, k));
		
		input = "abcabc";
		k = 3;
		System.out.println("Input : " + input);
		System.out.println("Output : " + kSubstring1(input, k));
		
		input = "abacab";
		k = 3;
		System.out.println("Input : " + input);
		System.out.println("Output : " + kSubstring1(input, k));
		
		input = "awaglknagawunagwkwagl";
		k = 4;
		System.out.println("Input : " + input);
		System.out.println("Output : " + kSubstring1(input, k));
		
		input = "abcabc";
		k = 3;
		System.out.println("Input : " + input);
		System.out.println("Output : " + kSubstring2(input, k));
		
		input = "abacab";
		k = 3;
		System.out.println("Input : " + input);
		System.out.println("Output : " + kSubstring2(input, k));
		
		input = "awaglknagawunagwkwagl";
		k = 4;
		System.out.println("Input : " + input);
		System.out.println("Output : " + kSubstring2(input, k));
		
	}

	public static Set<String> kSubstring2(String input, int k) {
		return null;
	}

	public static Set<String> kSubstring1(String input, int k) {
		return null;
	}

	public static List<String> kSubstring(String s, int k) {
		return null;
	}
}
