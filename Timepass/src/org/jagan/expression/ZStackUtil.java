package org.jagan.expression;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

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

	private static String transformInfixToPostFix(String expr) {
		StringBuilder bldr = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		Stream<Character> chStream = expr.replace(" ", "").chars().mapToObj(c -> (char)c);
		chStream.forEach(ch -> 
			{
				if(Character.isLetterOrDigit(ch)) bldr.append(ch);
				else if(ch == '(') stack.push(ch);
				else if(ch == ')') {
					while(!stack.isEmpty() && stack.peek() != '(') {
						bldr.append(ch);
					}
					stack.pop();
				} else {
					while(!stack.isEmpty() && getPrec(ch) <= getPrec(stack.peek())) {
						bldr.append(stack.pop());
					}
					stack.push(ch);
				}
		});
		while(!stack.isEmpty()) bldr.append(stack.pop());
		return bldr.toString();
	}
	
	private static int getPrec(Character ch) {
		if(ch == '^') return 3;
		if(ch == '*' || ch == '/') return 2;
		if(ch == '+' || ch == '-') return 1;
		return 0;
	}
	
	private static int evaluatePostFixExpression(String result) {
		Stack<Integer> stack = new Stack<Integer>();
		Stream<Character> chStream = result.chars().mapToObj(c -> (char)c);
		chStream.forEach(ch -> {
			if(Character.isDigit(ch)) stack.push(ch - '0');
			else {
				int val = 0;
				int val1 = stack.pop();
				int val2 = stack.pop();
				if(ch == '+') val = val2 + val1;
				if(ch == '-') val = val2 - val1;
				if(ch == '*') val = val2 * val1;
				if(ch == '/') val = val2 / val1;
				stack.push(val);
			}
		});
		return stack.pop();
	}
	
}