package org.jagan.solutions.az;

import java.util.Arrays;

public class SearchA2DMatrix {

	/*
	 * 
	 * Write an efficient algorithm that searches for a value in an m x n matrix.
	 * This matrix has the following properties:
	 * 
	 * Integers in each row are sorted in ascending from left to right. Integers in
	 * each column are sorted in ascending from top to bottom. Example:
	 * 
	 * Consider the following matrix:
	 * 
	 * [[1,   4,  7, 11, 15], 
	 * 	[2,   5,  8, 12, 19], 
	 * 	[3,   6,  9, 16, 22], 
	 * 	[10, 13, 14, 17, 24], 
	 * 	[18, 21, 23, 26, 30] 
	 * ] 
	 * 
	 * Given target = 5, return true.
	 * 
	 * Given target = 20, return false.
	 * 
	 */
	public static void main(String[] args) {
		int[][] input = {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		System.out.println("Input : " + Arrays.deepToString(input));
		System.out.println("Output : " + searchMatrix(input, 5));
		System.out.println("Output : " + searchMatrix(input, 20));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int rowIndex = 0;
		int colIndex = cols - 1;
		while(rowIndex < rows && colIndex >= 0) {
			int val = matrix[rowIndex][colIndex];
			if(target == val) return true;
			if(target < val) colIndex--;
			if(target > val) rowIndex++;
		}
		return false;
	}
}