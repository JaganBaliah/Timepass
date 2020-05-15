package org.jagan.solutions;

import java.util.Arrays;

public class ZSequenceTracking {

	public static void main(String[] args) {
		System.out.print(isBackToStartingPoint("UDL") + "\n");
		System.out.print(isBackToStartingPoint("ULR") + "\n");
		System.out.print(isBackToStartingPoint("UL") + "\n");
		System.out.print(isBackToStartingPoint("U") + "\n");
		System.out.print(isBackToStartingPoint("UDLR") + "\n");
		System.out.print(isBackToStartingPoint("UDLRRLDU") + "\n");
		System.out.print(isBackToStartingPoint("UDLRUDLR") + "\n");
		System.out.print(isBackToStartingPoint("ULDRULDR") + "\n");
	}
	
	public static void print(String sequence) {
		System.out.print("Is Back to start in sequence : [" + Arrays.toString(sequence.toCharArray()) + "] is ");
	}
	
	private static boolean isBackToStartingPoint(String sequence) {
		return false;
	}
}
