package org.jagan.solutions.az;

public class LongestPanlindrome {

	/*
	 * 
	 * Given a string s, find the longest palindromic substring in s. You may assume
	 * that the maximum length of s is 1000.
	 * 
	 * Example 1:
	 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer. 
	 * 
	 * Example 2:
	 * Input: "cbbd" Output: "bb"
	 * 
	 */
	public static void main(String[] args) {
		String input1 = "babad";
		System.out.println("Longest palindrome for \"" + input1 + "\" : " + findLongestPalindrome(input1));
		String input2 = "cbbd";
		System.out.println("Longest palindrome for \"" + input2 + "\" : " + findLongestPalindrome(input2));
		String input3 = "abededeba";
		System.out.println("Longest palindrome for \"" + input3 + "\" : " + findLongestPalindrome(input3));
	}
	
	public static String findLongestPalindrome(String input) {
		if(input.isEmpty()) return "";
		if(input.length() == 1) return input;
		
		String longest = input.substring(0, 1);
		for(int i = 0; i < input.length(); i++) {
			String tmp = getPalindrome(input, i, i);
			if(tmp.length() > longest.length()) longest = tmp;
			tmp = getPalindrome(input, i, i+1);
			if(tmp.length() > longest.length()) longest = tmp;				
		}
		return longest;
	}
	
	public static String getPalindrome(String s, int begin, int end) {
		while(begin >= 0 && end <= s.length() -1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
		
	}

}
