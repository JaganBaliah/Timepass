package org.jagan.solutions.az;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Battleship {

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
