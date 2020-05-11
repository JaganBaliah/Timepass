package org.jagan.solutions.az;

public class NumberOfIslands {

	/*
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
	 * islands. An island is surrounded by water and is formed by connecting
	 * adjacent lands horizontally or vertically. You may assume all four edges of
	 * the grid are all surrounded by water.
	 * 
	 * Example 1:
	 * Input: 
	 * 11110 
	 * 11010 
	 * 11000 
	 * 00000
	 * 
	 * Output: 1 
	 * 
	 * Example 2:
	 * Input: 
	 * 11000 
	 * 11000 
	 * 00100 
	 * 00011
	 * 
	 * Output: 3
	 * 
	 */
	public static void main(String[] args) {
		char[][] grid = {
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0',	'1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}
		};
		System.out.println("Number Of Islands : " + numIslands(grid));
		
		grid = new char[][]{
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0',	'0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		System.out.println("Number Of Islands : " + numIslands(grid));
		
	}
	
	public static int numIslands(char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		
		int count = 0;
		for(int i = 0 ; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(grid[i][j] == '1') {
					dfsGrid(grid, i, j);
					count++;
				}
			}
		}
        return count;
    }

	public static void dfsGrid(char[][] grid, int i, int j) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '0';
		dfsGrid(grid, i + 1, j);
		dfsGrid(grid, i - 1, j);
		dfsGrid(grid, i, j + 1);
		dfsGrid(grid, i, j - 1);
	}
}
