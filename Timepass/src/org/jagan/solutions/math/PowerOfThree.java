package org.jagan.solutions.math;

public class PowerOfThree {

	public static void main(String[] args) {
		System.out.println("Is 81 Power of Three : " + Integer.toString(81, 3).matches("^10*$"));
		System.out.println("Is 81 Power of Three : " + isPowerOfThree(81));
	}
	
	public static boolean isPowerOfThree(int n) {
		if(n < 1) return false;
		while(n % 3 == 0) n = n/3;
		if(n == 1) return true;
		return false;
	}

}
