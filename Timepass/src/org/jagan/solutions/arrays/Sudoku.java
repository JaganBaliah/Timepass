package org.jagan.solutions.arrays;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

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
        Set<String> set = new HashSet<>();
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                String val = board[row][col];
                if (val != ".") {
                    int block = (row / 3) * 3 + (col / 3);
                    if (set.contains("r" + row + val) || 
                        set.contains("c" + col + val) ||
                        set.contains("b" + block + val))
                        return false;
                    else {
                        set.add("r" + row + val);
                        set.add("c" + col + val);
                        set.add("b" + block + val);
                    }   
                }
            }
        }
        return true;
    }
}
