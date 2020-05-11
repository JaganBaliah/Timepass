package org.jagan.solutions.az;

import java.util.ArrayList;
import java.util.List;

public class RottingOranges {
	
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
		 int freshCount = 0;
		 List<int[]> rottenList = new ArrayList<int[]>();
		 
		 for(int i = 0; i < rows; i++) {
			 for(int j = 0 ; j < cols; j++) {
				 if(grid[i][j] == 1) freshCount++;
				 if(grid[i][j] == 2) {
					 rottenList.add(new int[] {i, j});
				 }
			 }
		 }
		 if(freshCount == 0) return 0;
		 int minCount = 0;
		 while(!rottenList.isEmpty()) {
			 minCount++;
			 List<int[]> temp = new ArrayList<int[]>();
			 for(int i = 0; i < rottenList.size(); i++) {
				 int[] coor = rottenList.get(i);
				 int x = coor[0];
				 int y = coor[1];
				 if((x + 1) < rows && grid[x + 1][y] == 1) {
					 grid[x + 1][y] = 2;
					 temp.add(new int[] {x + 1, y});
					 freshCount--;
				 }
				 if((x - 1) >= 0 && grid[x - 1][y] == 1) {
					 grid[x - 1][y] = 2;
					 temp.add(new int[] {x - 1, y});
					 freshCount--;
				 }
				 if((y + 1) < cols && grid[x][y + 1] == 1) {
					 grid[x][y + 1] = 2;
					 temp.add(new int[] {x, y + 1});
					 freshCount--;
				 }
				 if((y - 1) >= 0 && grid[x][y - 1] == 1) {
					 grid[x][y - 1] = 2;
					 temp.add(new int[] {x, y - 1});
					 freshCount--;
				 }
			 }
			 if(freshCount == 0) return minCount;
			 rottenList = new ArrayList<int[]>(temp);
		 }
		 return -1;
	 }
}
