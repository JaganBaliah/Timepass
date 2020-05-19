package org.jagan.solutions.az;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {

	/*
	 * 
	 * You have an array of logs. Each log is a space delimited string of words.
	 * 
	 * For each log, the first word in each log is an alphanumeric identifier. Then,
	 * either:
	 * 
	 * Each word after the identifier will consist only of lowercase letters, or;
	 * Each word after the identifier will consist only of digits. We will call
	 * these two varieties of logs letter-logs and digit-logs. It is guaranteed that
	 * each log has at least one word after its identifier.
	 * 
	 * Reorder the logs so that all of the letter-logs come before any digit-log.
	 * The letter-logs are ordered lexicographically ignoring identifier, with the
	 * identifier used in case of ties. The digit-logs should be put in their
	 * original order.
	 * 
	 * Return the final order of the logs.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: logs =
	 * ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
	 * Output:
	 * ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
	 * 
	 * 
	 * Constraints:
	 * 
	 * 0 <= logs.length <= 100 3 <= logs[i].length <= 100 logs[i] is guaranteed to
	 * have an identifier, and a word after the identifier.
	 *
	 */
	public static void main(String[] args) {
		String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		System.out.println("Input : " + Arrays.toString(logs));
		solution(logs);
		System.out.println("Output : " + Arrays.deepToString(logs));

		logs = new String[]{"dig12 8 1 5 1","let11 art can","dig23 3 6","let2 own kit dig","let1 art can"};
		System.out.println("Input : " + Arrays.toString(logs));
		solution(logs);
		System.out.println("Output : " + Arrays.deepToString(logs));
		
		System.out.println();
		
		logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		System.out.println("Input : " + Arrays.toString(logs));
		solution1(logs);
		System.out.println("Output : " + Arrays.deepToString(logs));

		logs = new String[]{"dig12 8 1 5 1","let11 art can","dig23 3 6","let2 own kit dig","let1 art can"};
		System.out.println("Input : " + Arrays.toString(logs));
		solution1(logs);
		System.out.println("Output : " + Arrays.deepToString(logs));
		
	}

	public static void solution(String[] logs) {
		Arrays.sort(logs, (str1, str2) -> {
			if(str1.startsWith("dig") && str2.startsWith("dig")) return 0;
			if(str1.startsWith("dig")) return 1;
			if(str2.startsWith("dig")) return -1;
			if(str1.startsWith("let") && str2.startsWith("let")) {
				String[] split1 = str1.split(" ", 2);
				String identifier1 = split1[0];
				String postIdentifier1 = split1[1];
				String[] split2 = str2.split(" ", 2);
				String identifier2 = split2[0];
				String postIdentifier2 = split2[1];
				if(postIdentifier1.equals(postIdentifier2)) {
					return identifier1.compareTo(identifier2);
				} else {
					return postIdentifier1.compareTo(postIdentifier2);
				}
			}
			return 0;
		});	
	}
	
	public static String[] solution1(String[] logs) {
        
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
                char s1FirstCharacter = s1.charAt(s1SpaceIndex+1);
                char s2FirstCharacter = s2.charAt(s2SpaceIndex+1);
                
                if (s1FirstCharacter <= '9') {
                    if (s2FirstCharacter <= '9') return 0;
                    else return 1;
                }
                if (s2FirstCharacter <= '9') return -1;
                
                int preCompute = s1.substring(s1SpaceIndex+1).compareTo(s2.substring(s2SpaceIndex+1));
                if (preCompute == 0) return s1.substring(0,s1SpaceIndex).compareTo(s2.substring(0,s2SpaceIndex));
                return preCompute;
            }
        };
        
        Arrays.sort(logs, myComp);
        return logs;
    }

}
