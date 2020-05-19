package org.jagan.solutions.az;

import java.util.List;

public class ZTopKFrequentlyMentionedWords {

	/*
	 * Given a list of reviews, a list of keywords and an integer k. Find the most
	 * popular k keywords in order of most to least frequently mentioned.
	 * 
	 * The comparison of strings is case-insensitive. Multiple occurances of a
	 * keyword in a review should be considred as a single mention. If keywords are
	 * mentioned an equal number of times in reviews, sort alphabetically.
	 * 
	 * Example 1:
	 * 
	 * Input: k = 2 
	 * keywords = [
	 * 		"anacell", 
	 * 		"cetracular", 
	 * 		"betacellular"
	 * 	]
	 * reviews = 
	 * 	[
	 * 		"Anacell provides the best services in the city",
	 * 		"betacellular has awesome services",
	 * 		"Best services provided by anacell, everyone should use anacell"
	 * 	]
	 * 
	 * Output: [
	 * 		"anacell", 
	 * 		"betacellular"
	 * 	]
	 * 
	 * Explanation: "anacell" is occuring in 2 different reviews and "betacellular"
	 * is only occuring in 1 review. 
	 * 
	 * Example 2:
	 * 
	 * Input: k = 2 
	 * keywords = [
	 * 		"anacell", 
	 * 		"betacellular", 
	 * 		"cetracular", 
	 * 		"deltacellular", 
	 * 		"eurocell"
	 * 	] 
	 * reviews = [
	 * 		"I love anacell Best services; Best services provided by anacell",
	 * 		"betacellular has great services",
	 * 		"deltacellular provides much better services than betacellular",
	 * 		"cetracular is worse than anacell",
	 * 		"Betacellular is better than deltacellular."
	 * 	]
	 * 
	 * Output: [
	 * 		"betacellular", 
	 * 		"anacell"
	 * 	]
	 * 
	 * Explanation: "betacellular" is occuring in 3 different reviews. "anacell" and
	 * "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.
	 * 
	 */
	public static void main(String[] args) {
		int k1 = 2;
		String[] keywords1 = { "anacell", "cetracular", "betacellular" };
		String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
				"Best services provided by anacell, everyone should use anacell", };
		int k2 = 2;
		String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
				"betacellular has great services", "deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
		System.out.println(solve(k1, keywords1, reviews1));
		System.out.println(solve(k2, keywords2, reviews2));
		
		System.out.println(solve1(k1, keywords1, reviews1));
		System.out.println(solve1(k2, keywords2, reviews2));
		
		System.out.println(solve2(k1, keywords1, reviews1));
		System.out.println(solve2(k2, keywords2, reviews2));
		
		System.out.println(solve3(k1, keywords1, reviews1));
		System.out.println(solve3(k2, keywords2, reviews2));
		
	}
	
	public static List<String> solve3(int k, String[] keywords, String[] reviews) {
		return null;
	}

	public static List<String> solve(int k, String[] keywords, String[] reviews) {
		return null;
	}

	public static List<String> solve1(int k, String[] keywords, String[] reviews) {
		return null;
	}
	
	public static List<String> solve2(int k, String[] keywords, String[] reviews) {
		return null;
	}
}
