package org.jagan.solutions.az;

import java.util.Arrays;

public class ZTreasureIslandShortestRoute {

	/*
	 * 
	 * You have a map that marks the locations of treasure islands. Some of the map
	 * area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
	 * There are other explorers trying to find the treasure. So you must figure out
	 * a shortest route to one of the treasure islands.
	 * 
	 * Assume the map area is a two dimensional grid, represented by a matrix of
	 * characters. You must start from one of the starting point (marked as S) of
	 * the map and can move one block up, down, left or right at a time. The
	 * treasure island is marked as X. Any block with dangerous rocks or reefs will
	 * be marked as D. You must not enter dangerous blocks. You cannot leave the map
	 * area. Other areas O are safe to sail in. Output the minimum number of steps
	 * to get to any of the treasure islands.
	 * 
	 * Example:
	 * 
	 * Input: {{'S', 'O', 'O', 'S', 'S'}, {'D', 'O', 'D', 'O', 'D'}, {'O', 'O', 'O',
	 * 'O', 'X'}, {'X', 'D', 'D', 'O', 'O'}, {'X', 'D', 'D', 'D', 'O'}}
	 * 
	 * Output: 3 Explanation: You can start from (0,0), (0, 3) or (0, 4). The
	 * treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest route is
	 * (0, 3), (1, 3), (2, 3), (2, 4).
	 * 
	 */
	public static void main(String[] args) {
		char[][] input = {
				{'S', 'O', 'O', 'S', 'S'},
				{'D', 'O', 'D', 'O', 'D'},
		        {'O', 'O', 'O', 'O', 'X'},
		        {'X', 'D', 'D', 'O', 'O'},
		        {'X', 'D', 'D', 'D', 'O'}
		};
		System.out.println("Input : " + Arrays.deepToString(input));
		int output = shortestRoute(input);
		System.out.println("Shorted Route : " + output);
	}

	public static int shortestRoute(char[][] grid) {
		return 0;
	}
	
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return "[" + x + " / " + y + "]";
		}
	}
}
