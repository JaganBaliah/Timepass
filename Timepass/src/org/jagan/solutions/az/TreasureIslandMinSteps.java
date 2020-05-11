package org.jagan.solutions.az;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreasureIslandMinSteps {

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
		int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		grid[0][0] = 'D';
		for(int steps = 1; !queue.isEmpty(); steps++) {
			int size = queue.size();
			while(size-- > 0) {
				Point p = queue.poll();
				for(int[] dir : dirs) {
					int adjX = p.x + dir[0];
					int adjY = p.y + dir[1];
					boolean safe = isSafe(grid, adjX, adjY);
					if(safe) {
						if(grid[adjX][adjY] == 'X') return steps;
						grid[adjX][adjY] = 'D';
						queue.add(new Point(adjX, adjY));
					}
				}
			}
		}
		return -1;
	}
	
	static boolean isSafe(char[][] grid, int x, int y) {
		if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 'D') return true;
		return false;
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
