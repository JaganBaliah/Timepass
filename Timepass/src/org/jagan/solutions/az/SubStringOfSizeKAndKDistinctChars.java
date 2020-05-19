package org.jagan.solutions.az;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStringOfSizeKAndKDistinctChars {

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
		Set<String> rtnVal = new HashSet<>();
		Set<Character> window = new HashSet<Character>();
		int start = 0, end = 0;
		while(end < input.length()) {
			Character endChar = input.charAt(end);
			while(window.contains(endChar)) {
				Character startChar = input.charAt(start);
				window.remove(startChar);
				start++;
			}
			window.add(endChar);
			end++;
			if(window.size() == k) {
				rtnVal.add(input.substring(start, end));
				Character startChar = input.charAt(start);
				window.remove(startChar);
				start++;
			}
		}
		
		return rtnVal;
	}

	public static Set<String> kSubstring1(String input, int k) {
		Set<String> rtnVal = new HashSet<>();
		for(int i = 0; i < input.length(); i++) {
			int distinctCount = 0;
			boolean[] chArr = new boolean[26];
			for(int j = i; j < input.length(); j++) {
				int ch = input.charAt(j) - 'a';
				if(!chArr[ch]) {
					chArr[ch] = true;
					distinctCount++;
					if(distinctCount > k) break;
				}
				if(j - i > k - 1) break;
				if(distinctCount == k) rtnVal.add(input.substring(i, j + 1));
			}
		}
		return rtnVal;
	}

	public static List<String> kSubstring(String s, int k) {
        Set<Character> window = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            for (; window.contains(s.charAt(end)); start++) {
                window.remove(s.charAt(start));
            }

            window.add(s.charAt(end));

            if (window.size() == k) {
                result.add(s.substring(start, end + 1));
                window.remove(s.charAt(start++));
            }
        }
        return new ArrayList<>(result);
    }
}
