package org.jagan.solutions.az;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TopKFrequentlyMentionedWords {

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
		
	}
	
	public static List<String> solve(int k, String[] keywords, String[] reviews) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		List<String> keywordList = Arrays.asList(keywords);
		for(String rev : reviews) {
			Set<String> added = new HashSet<String>();
			String[] split = rev.toLowerCase().split("\\W");
			for(String word : split) {
				if(keywordList.contains(word) && !added.contains(word)) {
					count.put(word, count.getOrDefault(word, 0) + 1);
					added.add(word);
				}
			}
		}
		List<String> keyList = new ArrayList<String>(count.keySet());
		Collections.sort(keyList, (s1, s2) -> {
			return count.get(s1) == count.get(s2) ? (s1.compareTo(s2)) : (count.get(s2) - count.get(s1));
		});
		return keyList.subList(0, k);
	}

	public static List<String> solve1(int k, String[] keywords, String[] reviews) {
		List<String> keywordsList = Arrays.asList(keywords) ;
	    HashMap<String,Integer> map = new HashMap<>() ;	    
	    for( String words : reviews){
	        Set<String> added = new HashSet<String>() ;
	        for(String str :words.split("\\s+")){
	            str = str.toLowerCase() ;
	            if(keywordsList.contains(str) && !added.contains(str)){
	                map.put(str,map.getOrDefault(str,0)+1) ;
	                added.add(str);
	            }
	        }
	     }
	     List<String> ls = new ArrayList<>(map.keySet()) ;
	     Collections.sort(ls,(a,b)->(map.get(a)).equals(map.get(b))?a.compareTo(b):map.get(b)-map.get(a));
	     return ls.subList(0,k) ;
	}
	
	public static List<String> solve2(int k, String[] keywords, String[] reviews) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		List<String> keywordList = Arrays.asList(keywords);
		for(String rev : reviews) {
			Set<String> added = new HashSet<String>();
			String[] split = rev.toLowerCase().split("\\W");
			for(String word : split) {
				if(keywordList.contains(word) && !added.contains(word)) {
					count.put(word, count.getOrDefault(word, 0) + 1);
					added.add(word);
				}
			}
		}
		Queue<String> queue = new PriorityQueue<>((s1, s2) -> count.get(s1) == count.get(s2) ? s1.compareTo(s2) : count.get(s2) - count.get(s1));;
		queue.addAll(count.keySet());
		List<String> rtnVal = new ArrayList<String>();
		while(!queue.isEmpty() && k > 0) {
			rtnVal.add(queue.poll());
			k--;
		}
		return rtnVal;
	}
}
