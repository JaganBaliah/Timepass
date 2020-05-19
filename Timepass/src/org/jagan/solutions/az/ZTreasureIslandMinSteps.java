package org.jagan.solutions.az;

import java.util.Arrays;

public class ZTreasureIslandMinSteps {

	/*
	 * ou have a map that marks the location of a treasure island. Some of the map
	 * area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
	 * There are other explorers trying to find the treasure. So you must figure out
	 * a shortest route to the treasure island.
	 * 
	 * Assume the map area is a two dimensional grid, represented by a matrix of
	 * characters. You must start from the top-left corner of the map and can move
	 * one block up, down, left or right at a time. The treasure island is marked as
	 * X in a block of the matrix. X will not be at the top-left corner. Any block
	 * with dangerous rocks or reefs will be marked as D. You must not enter
	 * dangerous blocks. You cannot leave the map area. Other areas O are safe to
	 * sail in. The top-left corner is always safe. Output the minimum number of
	 * steps to get to the treasure.
	 * 
	 * Example:
	 * 
	 * Input: [['O', 'O', 'O', 'O'], ['D', 'O', 'D', 'O'], ['O', 'O', 'O', 'O'],
	 * ['X', 'D', 'D', 'O']]
	 * 
	 * Output: 5 Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3,
	 * 0) The minimum route takes 5 steps.
	 * 
	 */
	public static void main(String[] args) {
		char[][] input = {
				{'O', 'O', 'O', 'O'},
				{'D', 'O', 'D', 'O'},
				{'O', 'O', 'O', 'O'},
				{'X', 'D', 'D', 'O'}
		};
		System.out.println("Input : " + Arrays.deepToString(input));
		System.out.println("Min Steps : " + minSteps(input));
	}
	
	public static int minSteps(char[][] grid) {
		return 0;
	}
	
	
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
