package org.jagan.solutions.az;

import java.util.Arrays;

public class PointOfLattice {

	public static void main(String[] args) {
		int[] output = lattice(-1, 3, 3, 1);
		System.out.println("Output : " + Arrays.toString(output));
	}

	
	public static int[] lattice(int ax, int ay, int bx, int by) {
		int dx = bx - ax;
		int dy = by - ay;
		
		int rx = dy;
		int ry = -dx;
		
		int gcd = Math.abs(gcd(rx, ry));
		rx /= gcd;
		ry /= gcd;
		
		return new int[] {bx + rx, by + ry};
	}

    public static int gcd(int x, int y) {
    	return y == 0 ? x : gcd(x, x % y);
    }
}
