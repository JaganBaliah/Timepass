package org.jagan.solutions.az;

public class CountSubstringsWithKDistinctChars {

	/*
	 * 
	 * Given a string s and an int k, return an int representing the number of
	 * substrings (not unique) of s with exactly k distinct characters. If the given
	 * string doesn't have k distinct characters, return 0.
	 * 
	 * Example 1:
	 * Input: s = "pqpqs", k = 2
	 * Output: 7 
	 * Explanation: ["pq", "pqp", "pqpq", "qp", "qpq", "pq", "qs"] 
	 * 
	 * Example 2:
	 * Input: s = "aabab", k = 3 
	 * Output: 0 
	 * 
	 * Constraints:
	 * The input string consists of only lowercase English letters [a-z] 0 ≤ k ≤ 26
	 * 
	 */

	public static void main(String[] args) 
	{ 
		String str = "abcbaa"; 
		int k = 3; 
		System.out.println("Total substrings with exactly " +  
				k + " distinct characters in " + str + " : "
				+ countkDist(str, k)); 
		
		str = "pqpqs"; 
		k = 2; 
		System.out.println("Total substrings with exactly " +  
				k + " distinct characters in " + str + " : "
				+ countkDist(str, k)); 
		
		str = "aabab"; 
		k = 3; 
		System.out.println("Total substrings with exactly " +  
				k + " distinct characters in " + str + " : "
				+ countkDist(str, k)); 
		
	} 

	public static int countkDist(String str, int k) {
		int rtnVal = 0;
		int len = str.length(); 
		for (int i = 0; i < len; i++) {
			int distinctCount = 0;
			boolean occured[] = new boolean[26];
			for (int j=i; j<len; j++) {
				char ch = str.charAt(j);
				if (!occured[ch - 'a']) {
					occured[ch - 'a'] = true;
					distinctCount++;
				}
				if (distinctCount == k) rtnVal++;
			}
		}
		return rtnVal;
	}
}
