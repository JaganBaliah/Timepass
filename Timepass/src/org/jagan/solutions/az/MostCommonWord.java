package org.jagan.solutions.az;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	public static void main(String[] args) {
		String input = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		System.out.println("Most Command Word : " + mostCommonWord(input, banned));
	}

	public static String mostCommonWord(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        //String temp = p.replaceAll("\\W+" , " ");
      	//String[] words = temp.toLowerCase().split("\\s+");
        String[] words = p.toLowerCase().split("\\W+");
        for (String w : words) {
        	if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        }
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
