package org.jagan.expression;

import java.util.Scanner;
import java.util.Stack;

public class ZStackUtil {

	public static void main(String[] args) {
		System.out.println("Input an infix expression : ");
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(" ");
		String result = transformInfixToPostFix(scanner.nextLine());
		scanner.close();
		System.out.println("Transformed PostFix expr : " + result);
		int value = evaluatePostFixExpression(result);
		System.out.println("Evaluated value : " + value);
		
	}
	
	private static String transformInfixToPostFix(String nextLine) {
		StringBuilder rtnVal = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		for(char ch : nextLine.toCharArray()) {
			if(Character.isLetterOrDigit(ch)) {
				rtnVal.append(ch);
			} else if(ch == '(') {
				stack.push(ch);
			} else if(ch == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					rtnVal.append(stack.pop());
				}
				if(!stack.isEmpty() && stack.peek() != '(') {
					//error
				}				
				stack.pop();
			} else {
				while(!stack.isEmpty() && getPrec(ch) <= getPrec(stack.peek())) {
					rtnVal.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		while(!stack.isEmpty()) rtnVal.append(stack.pop());
		return rtnVal.toString();
	}

	private static int getPrec(char ch) {
		if(ch == '^') return 3;
		if(ch == '*' || ch == '/') return 2;
		if(ch == '+' || ch == '-') return 1;
		return 0;
	}

	private static int evaluatePostFixExpression(String result) {
		Stack<Integer> stack = new Stack<Integer>();
		for(Character ch : result.toCharArray()) {
			if(Character.isDigit(ch)) {
				stack.push(ch - '0');
			} else {
				int eval = 0;
				int val1 = stack.pop();
				int val2 = stack.pop();
				if(ch == '+') eval = val1 + val2;
				if(ch == '-') eval = val1 - val2;
				if(ch == '*') eval = val1 * val2;
				if(ch == '/') eval = val1 / val2;
				stack.push(eval);
			}
		}
		return stack.pop();
	}

	
}