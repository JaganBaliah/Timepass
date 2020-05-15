package org.jagan.solutions.arrays;

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
		return false;
	}
}
