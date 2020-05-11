package org.jagan.solutions.az;

import java.util.Arrays;

public class SpiralMatrix {

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
		int[][] matrix = new int[n][n];
		int rowStart = 0;
		int rowEnd = n - 1;
		int colStart = 0;
		int colEnd = n - 1;
		int val = 1;
		while(rowStart <= rowEnd && colStart <= colEnd) {
			for(int i = colStart; i <= colEnd; i++) {
				matrix[rowStart][i] = val++;
			}
			rowStart++;
			for(int i = rowStart; i <= rowEnd; i++) {
				matrix[i][colEnd] = val++;
			}
			colEnd--;
			for(int i = colEnd; i >= colStart; i--) {
				if(rowStart <= rowEnd) matrix[rowEnd][i] = val++;
			}
			rowEnd--;
			for(int i = rowEnd; i >= rowStart; i--) {
				if(colStart <= colEnd) matrix[i][colStart] = val++;
			}
			colStart++;
		}
		return matrix;
	}

}
