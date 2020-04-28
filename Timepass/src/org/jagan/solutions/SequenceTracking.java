package org.jagan.solutions;

import java.util.Arrays;

public class SequenceTracking {

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
	
	private static void print(String sequence) {
		System.out.print("Is Back to start in sequence : [" + Arrays.toString(sequence.toCharArray()) + "] is ");
	}
	
	private static boolean isBackToStartingPoint(String sequence) {
		print(sequence);
		int xorVal = 0;
		for(char ch : sequence.toCharArray()) {
			if (ch == 'D') ch = 'U';
			if (ch == 'R') ch = 'L';
			xorVal = xorVal ^ ch;
		}
		return xorVal == 0;
	}
}
