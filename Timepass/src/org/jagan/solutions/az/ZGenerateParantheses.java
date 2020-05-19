package org.jagan.solutions.az;

import java.util.List;

public class ZGenerateParantheses {

	/*
	 * 
	 * Given n pairs of parentheses, write a function to generate all combinations
	 * of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * 
	 * [ "((()))", 
	 *   "(()())", 
	 *   "(())()", 
	 *   "()(())", 
	 *   "()()()" 
	 * ]
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Pairs of parantheses for n = 3 : " + generateParenthesis(3));
	}
	
	public static List<String> generateParenthesis(int n) {
		return null;
	}
    
    public static void backtrack(List<String> list, String str, int open, int close, int max){
    	
    }

}
