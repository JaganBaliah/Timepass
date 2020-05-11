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
	
	private static void print(int[] sequence) {
		System.out.print("Missing number in sequence : [" + Arrays.toString(sequence) + "] is ");
	}
	
	private static int findMissingNumberInSequence(int[] sequence) {
		print(sequence);
		int xor = sequence.length;
		for(int i = 0; i < sequence.length; i++) xor = xor ^ i ^ sequence[i];
		return xor >= 0 ? xor : -1;
	}
	
	private static int findMissingNumberInSequenceUsingSum(int[] sequence) {
		print(sequence);
		int sum = 0;
		for(int val : sequence) {
			sum += val;
		}
		int len = sequence.length;
		int actualSum = len * (len + 1) / 2;
		return actualSum - sum;
	}
	
	
}
