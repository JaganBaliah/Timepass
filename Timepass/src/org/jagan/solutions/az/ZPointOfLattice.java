package org.jagan.solutions.az;

import java.util.Arrays;

public class ZPointOfLattice {

	/*
	 * 
	 * Alice lives on a lattice. Tha lattice consists of points that have integer
	 * coordinates.
	 * 
	 * One day Alice decided she wants to go for a walk. She starts at lattice point A
	 * and goes straight to laticce point B. After reaching B, she turns 90 degrees 
	 * to the right and moves straight in that direction. What is the first lattice 
	 * point she will reach after the turn.
	 * 
	 * The points A & B have coordinates (Ax, Ay) and (Bx, By) respectively. You can
	 * assume that A & B are distinct.
	 * 
	 * Write a function, given four integers Ax, Ay, Bx and By, finds the coordinates 
	 * of the first lattice point that Alice will reach after turning right.
	 * It must return a string with two coordinates separated with a comma, without
	 * any spaces.
	 * 
	 * For example, given:
	 * 
	 * 		Ax = -1 
	 * 		Ay = 3 
	 * 		Bx = 3 
	 * 		By = 1
	 * 
	 * the function should return "2, -1"
	 * 
	 */
	public static void main(String[] args) {
		int[] output = lattice(-1, 3, 3, 1);
		System.out.println("Output : " + Arrays.toString(output));
	}

	public static int[] lattice(int ax, int ay, int bx, int by) {
		return null;
	}

    public static int gcd(int x, int y) {
    	return y == 0 ? x : gcd(y, x % y);
    }
}
