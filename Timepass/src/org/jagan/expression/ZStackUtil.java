package org.jagan.expression;

import java.util.Scanner;

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
	
	public static String transformInfixToPostFix(String nextLine) {
		return "";
	}

	public static int getPrec(char ch) {
		return 0;
	}

	public static int evaluatePostFixExpression(String result) {
		return 0;
	}

	
}