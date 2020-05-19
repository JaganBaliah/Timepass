package org.jagan.solutions.az;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Battleship {

	/*
	 * Jack plays a game of battleships with his friend Stacy. The game is played on
	 * a square map of N rows, numbered from 1 to N. Each row contains N cells,
	 * labeled with consecutive English upper-case letters (A, B, C, etc.). Each
	 * cell is identified by a string composed of its row number followed by its
	 * column number: for example, "9C" denotes the third cell in the 9th row, and
	 * "15D" denotes the fourth cell in the 15th row.
	 * 
	 * Jack marks the positions of all his ships on the map (which is not shown to
	 * Stacy). Ships are defined by rectangles with a maximum area of 4 cells. Stacy
	 * picks map cells to hit some ships. A ship is considered to be hit if at least
	 * one of its constituent cells is hit. If all of a ship's cells are hit, the
	 * ship is sunk.
	 * 
	 * The goal is to count the number of sunk ships and the number of ships that
	 * have been hit but not sunk.
	 * 
	 * For example, the picture below shows a map of size N = 4 with two blue ships
	 * and five hits marked with the letter 'X':
	 * 
	 * 		  A	  B	  C	  D
	 * 	_____________________
	 * 	1	|	|	|	|	|
	 * 	________|___|___|___|
	 * 	2	|	| X	|	| X	|
	 * 	________|___|___|___|
	 * 	3	|	|	|	| X	|
	 * 	________________|___|
	 * 	4	| X	|	|	| X	|
	 * 	________________|___|
	 * 
	 * 1B-2C Will be in Red
	 * 2D-4D Will be in grey
	 * 4A
	 * 
	 * In this example, one ship has been sunk and the other has been hit but not sunk. 
	 * In the above picture, the sunken ship is shown in grey and the ship that has been hit 
	 * but not yet sunk appears in red.
	 * 
	 * 
	 * The positions of ships are given as a string S, containing pairs of positions describing 
	 * respectively the top-left and bottom-right corner cells of each ship. Ships' descriptions 
	 * are separated with commas. 
	 * The positions of hits are given as a string T, containing positions describing the map 
	 * cells that were hit: for the map in the example shown above, 
	 * S = "1B 2C,2D 4D" and T = "2B 2D 3D 4D 4A". Ships in S and hits in T may appear in any order.
	 * Write a function: 
	 * class Solution { public String solution(int N, String S, String T); }
	 * that, given the size of the map N and two strings S, T that describe the positions of 
	 * ships and hits respectively, returns a string with two numbers: the count of sunken ships 
	 * and the count of ships that have been hit but not sunk, separated with a comma.
	 * For instance, given N = 4, S = "1B 2C,2D 4D" and T = "2B 2D 3D 4D 4A", your function should 
	 * return "1,1", as explained above. 
	 * Given N = 3, S = "1A 1B,2C 2C" and T = "1B", your function should return "0,1", because 
	 * one ship was hit but not sunk.
	 * 
	 * 
	 * 		  A	  B	  C	 
	 * 	_________________
	 * 	1	|	| X	|	|
	 * 	____|___|___|___|
	 * 	2	|	| 	|	|
	 * 	________|___|___|
	 * 	3	|	|	|	|
	 * 	________________|
	 * 	
	 * 1A-1B - Will be in Red
	 * 2C Will be in Blue
	 * 
	 * Given N = 12, S = "1A 2A,12A 12A" and T = "12A", your function should return "1,0", 
	 * because one ship was hit and sunk.
	 * 
	 * Assume that:
	 * N is an integer within the range [1..26];
	 * string S contains the descriptions of rectangular ships of area not greater than 4 cells;
	 * there can be at most one ship located on any map cell (ships do not overlap);
	 * each map cell can appear in string T at most once;
	 * string S and string T contains only valid positions given in specified format.
	 * In your solution, focus on correctness. The performance of your solution will not be the 
	 * focus of the assessment.
	 * 
	 */
	public static void main(String[] args) {
		String ans = "";
		ans = solution(4,"1B 2C,2D 4D","2B 2D 3D 4D 4A");
		System.out.println(ans);
		
		ans = solution(4,"1A 1B,2C 2C","1B");
		System.out.println(ans);
		
		ans = solution(12, "1A 2A,12A 12A", "12A");
	    System.out.println(ans);
	}

	public static String solution(int n, String shipPositions, String hitPositions) {
		int sunkShips = 0;
		int hitShips = 0;
		List<String> targets = Arrays.asList(hitPositions.split(" "));
		List<String> ships = Arrays.asList(shipPositions.split(","));
		for(String ship : ships) {
			List<String> shipCells = new ArrayList<>();
			String[] cells = ship.split(" ");
			int len0 = cells[0].length();
			int len1 = cells[1].length();
			int top = Integer.parseInt(cells[0].substring(0, len0 - 1));
			char left = cells[0].charAt(len0 - 1);
			int bottom = Integer.parseInt(cells[1].substring(0, len1 - 1));
			char right = cells[1].charAt(len1 - 1);
			
			for(int i = top; i <= bottom; i++) {
				for(char j = left; j <= right; j++) {
					shipCells.add("" + i + j);
				}
			}
			if(targets.containsAll(shipCells)) {
				sunkShips++;
			} else {
				for(String cell : shipCells) {
					if(targets.contains(cell)) {
						hitShips++;
						break;
					}
				}
			}
		}
		return "" + sunkShips + "," + hitShips;
	}
}
