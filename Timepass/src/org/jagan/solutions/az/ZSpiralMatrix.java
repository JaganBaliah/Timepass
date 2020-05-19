package org.jagan.solutions.az;

import java.util.Arrays;

public class ZSpiralMatrix {

	/*
	 * 
	 * Given a positive integer n, generate a square matrix filled with elements
	 * from 1 to n * n in spiral order.
	 * 
	 * Example:
	 * 
	 * Input: 3 
	 * Output: 
	 * 	[ 
	 * 		[ 1, 2, 3 ], 
	 * 		[ 8, 9, 4 ], 
	 * 		[ 7, 6, 5 ] 
	 * 	]
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Input : " + 3);
		int[][] matrix = spiralMatrix(3);
		System.out.println("Output  : " + Arrays.deepToString(matrix));
		
		System.out.println("Input : " + 4);
		matrix = spiralMatrix(4);
		System.out.println("Output  : " + Arrays.deepToString(matrix));
	}

	public static int[][] spiralMatrix(int n) {
		return null;
	}

}
