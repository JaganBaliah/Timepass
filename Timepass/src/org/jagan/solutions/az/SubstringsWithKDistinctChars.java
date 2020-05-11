package org.jagan.solutions.az;

public class SubstringsWithKDistinctChars {

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
