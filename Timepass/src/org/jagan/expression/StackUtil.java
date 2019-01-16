package org.jagan.expression;

import java.util.Stack;

public class StackUtil {

	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		//String input = scanner.nextLine();
		
		String inFixExpr = "a+b*c+d";
		System.out.println(transformToPostFixExpr(inFixExpr));
		
		String exprToEvaluate = "1+2*3+1";
		String postFixExpr = transformToPostFixExpr(exprToEvaluate);
		System.out.println(evaluate(postFixExpr));
		
	}

	private static String transformToPostFixExpr(String inFixExpr) {
		StringBuilder rtnVal = new StringBuilder("");
		Stack<Character> stack = new Stack<Character>();
		char[] chs = inFixExpr.toCharArray();
		for(char ch : chs) {
			if(Character.isLetterOrDigit(ch)) { 
				rtnVal.append(ch);
			} else if(ch == '(') { 
				stack.push(ch);
			} else if(ch == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					rtnVal.append(stack.pop());
				}
				if(!stack.isEmpty() && stack.peek() != '(') {
					//Error
				}
				stack.pop();
			} else {
				while(!stack.isEmpty() && getPrec(ch) <= getPrec(stack.peek())) {
					rtnVal.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		while(!stack.isEmpty()) {
			rtnVal.append(stack.pop());
		}
		return rtnVal.toString();
	}
	
	private static int getPrec(Character ch) {
		if(ch == '^') return 3;
		if(ch == '*' || ch == '/') return 2;
		if(ch == '+' || ch == '-') return 1;
		return 0;
	}
	
	private static int evaluate(String postFixExpr) {
		Stack<Integer> stack = new Stack<Integer>();
		char[] chs = postFixExpr.toCharArray();
		for(char ch : chs) {
			if(Character.isDigit(ch)) { 
				stack.push(ch - '0');				
			} else {
				int val1 = stack.pop();
				int val2 = stack.pop();
				int val = 0;
				if(ch == '+') val = val1 + val2;
				if(ch == '-') val = val1 - val2;
				if(ch == '*') val = val1 * val2;
				if(ch == '/') val = val1 / val2;
				stack.push(val);
			}
		}
		return stack.pop();
	}

	
}
