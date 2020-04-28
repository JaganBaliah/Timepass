package org.jagan.fundamentals;

import java.util.ArrayList;
import java.util.List;

public class PalindromeExercise {

	public static void main(String[] args) {
		PalindromeChecker pChecker = new PalindromeChecker();
		System.out.println("Is \"\" a palindrome? " + pChecker.isPalindrome(""));
		System.out.println("Is \"a\" a palindrome? " + pChecker.isPalindrome("a"));
		System.out.println("Is \"A\" a palindrome? " + pChecker.isPalindrome("A"));
		System.out.println("Is \"1\" a palindrome? " + pChecker.isPalindrome("1"));
		System.out.println("Is \"abc\" a palindrome? " + pChecker.isPalindrome("abc"));
		System.out.println("Is \"abbc\" a palindrome? " + pChecker.isPalindrome("abbc"));
		System.out.println("Is \"abcbc\" a palindrome? " + pChecker.isPalindrome("abcbc"));
		System.out.println("Is \"abccbc\" a palindrome? " + pChecker.isPalindrome("abccbc"));
		System.out.println("Is \"aba\" a palindrome? " + pChecker.isPalindrome("aba"));
		System.out.println("Is \"abba\" a palindrome? " + pChecker.isPalindrome("abba"));
		System.out.println("Is \"abcba\" a palindrome? " + pChecker.isPalindrome("abcba"));
		System.out.println("Is \"abccba\" a palindrome? " + pChecker.isPalindrome("abccba"));
		
		PalindromeFinder pFinder = new PalindromeFinder();
		String input1 = "abededeba";
		List<String> listOfPalindromes = pFinder.findPalindromes(input1);
		System.out.println("List of palindromes for \"" + input1 + "\" : " + listOfPalindromes);
		
		LongestPalindromeFinder lpFinder = new LongestPalindromeFinder();
		String input2 = "abededeba";
		System.out.println("Longest palindrome for \"" + input2 + "\" : " + lpFinder.findLongestPalindrome(input2));
		
		EfficientLongestPalindromeFinder elpFinder = new EfficientLongestPalindromeFinder();
		String input3 = "abededeba";
		System.out.println("Longest palindrome for \"" + input3 + "\" : " + elpFinder.findLongestPalindrome(input3));
	
	}
	
	private static class PalindromeChecker {
		public boolean isPalindrome(String input) {
			boolean rtnVal = true;
			int len = input.length();
			for(int i = 0, j = len - 1; i < len/2; i++, j--) {
				if(input.charAt(i) != input.charAt(j)) {
					rtnVal = false;
					break;
				}
			}
			return rtnVal;
		}	
	}
	
	private static class PalindromeFinder {
		public List<String> findPalindromes(String input) {
			List<String> rtnVal = new ArrayList<String>();
			int len = input.length();
			for(int i = 0; i < len; i++) {
				for(int j = i + 1; j <= len; j++) {
					String str = input.substring(i, j);
					if(check(str)) rtnVal.add(str);					
				}
			}
			return rtnVal;
		}
		
		private boolean check(String str) {
			boolean rtnVal = true;
			int len = str.length();
			for(int i = 0, j = len - 1; i < len/2; i++, j--) {
				if(str.charAt(i) != str.charAt(j)) {
					rtnVal = false;
					break;
				}
			}
			return rtnVal;
		}
	}
	
	private static class LongestPalindromeFinder {
		public String findLongestPalindrome(String input) {
			String rtnVal = "";
			int len = input.length();
			for(int i = 0; i < len; i++) {
				for(int j = i + 1; j <= len; j++) {
					String str = input.substring(i, j);
					if(check(str)) {
						if(str.length() == input.length()) {
							return str;							
						}
						if(rtnVal.length() < str.length()) rtnVal = str;							
					}
				}
			}
			return rtnVal;
		}
		
		private boolean check(String str) {
			boolean rtnVal = true;
			int len = str.length();
			for(int i = 0, j = len -1; i < len/2; i++, j--) {
				if(str.charAt(i) != str.charAt(j)) {
					rtnVal = false;
					break;
				}
			}
			return rtnVal;
		}
	}
	
	private static class EfficientLongestPalindromeFinder {
		public String findLongestPalindrome(String input) {
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
		
		public String getPalindrome(String s, int begin, int end) {
			while(begin >= 0 && end <= s.length() -1 && s.charAt(begin) == s.charAt(end)) {
				begin--;
				end++;
			}
			return s.substring(begin + 1, end);
			
		}
	} 
}