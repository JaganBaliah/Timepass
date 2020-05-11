package org.jagan.solutions.arrays;

import java.util.HashSet;
import java.util.Set;

public class ZSudoku {

	public static void main(String[] args) {
		String[][] str = {{"5","3",".",".","7",".",".",".","."},
		                  {"6",".",".","1","9","5",".",".","."},
		                  {".","9","8",".",".",".",".","6","."},
		                  {"8",".",".",".","6",".",".",".","3"},
		                  {"4",".",".","8",".","3",".",".","1"},
		                  {"7",".",".",".","2",".",".",".","6"},
		                  {".","6",".",".",".",".","2","8","."},
		                  {".",".",".","4","1","9",".",".","5"},
		                  {".",".",".",".","8",".",".","7","9"}};
		System.out.println("Is Valid Sudoku : " + isValidSudoku(str));
	}
	
	public static boolean isValidSudoku(String[][] board) {
		Set<String> set = new HashSet<String>();
		int rows = board.length;
		int cols = board[0].length;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(board[i][j] != ".") {
					String val = board[i][j];
					String rowVal = val + "R" + i;
					String colVal = val + "C" + j;
					int b = (i/3 * 3) + j/3;
					String bVal = val + "B" + b;
					if(set.contains(rowVal) || set.contains(colVal) || set.contains(bVal)) {
						return false;
					}
					set.add(rowVal);
					set.add(colVal);
					set.add(bVal);
				}
			}
		}
		return true;
	}
}
