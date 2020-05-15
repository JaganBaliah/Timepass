package org.jagan.solutions;

import java.util.Arrays;

public class ZMissingNumber {

	public static void main(String[] args) {
		System.out.print(findMissingNumberInSequence(new int[] {0, 1, 2, 4}) + "\n");
		System.out.print(findMissingNumberInSequence(new int[] {1, 0, 2, 4}) + "\n");
		System.out.print(findMissingNumberInSequence(new int[] {1, 2, 3, 4}) + "\n");
		System.out.print(findMissingNumberInSequence(new int[] {0, 1, 2, 3}) + "\n");
		System.out.print(findMissingNumberInSequence(new int[] {4, 0, 2, 1}) + "\n");
		System.out.print(findMissingNumberInSequence(new int[] {4, 2, 1, 0}) + "\n");
		
		System.out.println();
		
		System.out.print(findMissingNumberInSequenceUsingSum(new int[] {0, 1, 2, 4}) + "\n");
		System.out.print(findMissingNumberInSequenceUsingSum(new int[] {1, 0, 2, 4}) + "\n");
		System.out.print(findMissingNumberInSequenceUsingSum(new int[] {1, 2, 3, 4}) + "\n");
		System.out.print(findMissingNumberInSequenceUsingSum(new int[] {0, 1, 2, 3}) + "\n");
		System.out.print(findMissingNumberInSequenceUsingSum(new int[] {4, 0, 2, 1}) + "\n");
		System.out.print(findMissingNumberInSequenceUsingSum(new int[] {4, 2, 1, 0}) + "\n");
		
		System.out.println();
		
	}
	
	public static void print(int[] sequence) {
		System.out.print("Missing number in sequence : [" + Arrays.toString(sequence) + "] is ");
	}
	
	private static int findMissingNumberInSequence(int[] sequence) {
		return 0;
	}
	
	private static int findMissingNumberInSequenceUsingSum(int[] sequence) {
		return 0;
	}
	
	
}
