package org.jagan.solutions.az;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZRottingOranges {
	
	/*
	 * In a given grid, each cell can have one of three values:
	 * 
	 * the value 0 representing an empty cell; the value 1 representing a fresh
	 * orange; the value 2 representing a rotten orange. Every minute, any fresh
	 * orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
	 * 
	 * Return the minimum number of minutes that must elapse until no cell has a
	 * fresh orange. If this is impossible, return -1 instead.
	 * 
	 * Example 1:
	 * Input: 
	 * [
	 * 	[2,1,1],
	 * 	[1,1,0],
	 * 	[0,1,1]
	 * ] 
	 * Output: 4 
	 * 
	 * 
	 * Example 2:
	 * Input: 
	 * [
	 * 	[2,1,1],
	 * 	[0,1,1],
	 * 	[1,0,1]
	 * ] 
	 * Output: -1 
	 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten,
	 * because rotting only happens 4-directionally.
	 * 
	 * 
	 * Example 3:
	 * 
	 * Input: 
	 * [
	 * 	[0,2]
	 * ] 
	 * Output: 0 
	 * 
	 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		int[][] grid = {
				{2, 1, 1},
				{1, 1, 0},
				{0, 1, 1}
		};
		System.out.println("Time taken in minutes : " + orangesRotting(grid));
		
		grid = new int[][] {
			{2, 1 ,1},
			{0, 1, 1},
			{1, 0, 1}
		};
		System.out.println("Time taken in minutes : " + orangesRotting(grid));
		
		grid = new int[][] {
			{0, 2}
		};
		System.out.println("Time taken in minutes : " + orangesRotting(grid));
	}
	
	public static int orangesRotting(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int minCount = 0;
		int freshCount = 0;
		List<Integer[]> rotten = new ArrayList<Integer[]>();
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(grid[i][j] == 2) {
					rotten.add(new Integer[] {i, j});
				}
				else if(grid[i][j] == 1) {
					freshCount++;				
				}
			}
		}
		if(freshCount == 0) return 0;
		while(!rotten.isEmpty()) {
			minCount++;
			List<Integer[]> temp = new ArrayList<Integer[]>();
			for(Integer[] xy : rotten) {
				int x = xy[0], y = xy[1];
				if(x - 1 >= 0 && grid[x - 1][y] == 1) {
					grid[x - 1][y] = 2;
					temp.add(new Integer[] {x - 1, y});
					freshCount--;
				}
				if(x + 1 < rows && grid[x + 1][y] == 1) {
					grid[x + 1][y] = 2;
					temp.add(new Integer[] {x + 1, y});
					freshCount--;
				}
				if(y - 1 >= 0 && grid[x][y - 1] == 1) {
					grid[x][y - 1] = 2;
					temp.add(new Integer[] {x, y - 1});
					freshCount--;
				}
				if(y + 1 < cols && grid[x][y + 1] == 1) {
					grid[x][y + 1] = 2;
					temp.add(new Integer[] {x, y + 1});
					freshCount--;
				}
			}
			if(freshCount == 0) return minCount;
			rotten = new ArrayList<>(temp);
		}
		return -1;
	}

	public static int orangesRotting1(int[][] grid) {
		int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		Queue<Point> queue = new LinkedList<>();
		int rows = grid.length;
		int cols = grid[0].length;
		int freshCount = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(grid[i][j] == 2) {
					queue.add(new Point(i, j));
				} else if(grid[i][j] == 1) {
					freshCount++;	
				}
			}
		}
		if(freshCount == 0) return 0;
		for(int minCount = 1; !queue.isEmpty(); minCount++) {
			int size = queue.size();
			while(size-- > 0) {
				Point p = queue.poll();
				for(int[] dir : dirs) {
					int adjX = p.x + dir[0];
					int adjY = p.y + dir[1];
					boolean isFresh = isFresh(grid, adjX, adjY);
					if(isFresh) {
						freshCount--;
						grid[adjX][adjY] = 2;
						queue.add(new Point(adjX, adjY));
					}
					if(freshCount == 0) return minCount;
				}
			}
		}
		return -1;
	}

	static boolean isFresh(int[][] grid, int x, int y) {
		if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) return true;
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
