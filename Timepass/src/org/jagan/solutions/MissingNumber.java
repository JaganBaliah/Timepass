package org.jagan.solutions;

import java.util.Arrays;

public class MissingNumber {

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
		
		System.out.print(findMissingNumberInSequenceUsingArray(new int[] {0, 1, 2, 4}) + "\n");
		System.out.print(findMissingNumberInSequenceUsingArray(new int[] {1, 0, 2, 4}) + "\n");
		System.out.print(findMissingNumberInSequenceUsingArray(new int[] {1, 2, 3, 4}) + "\n");
		System.out.print(findMissingNumberInSequenceUsingArray(new int[] {0, 1, 2, 3}) + "\n");
		System.out.print(findMissingNumberInSequenceUsingArray(new int[] {4, 0, 2, 1}) + "\n");
		System.out.print(findMissingNumberInSequenceUsingArray(new int[] {4, 2, 1, 0}) + "\n");
	}
	
	private static void print(int[] sequence) {
		System.out.print("Missing number in sequence : [" + Arrays.toString(sequence) + "] is ");
	}
	
	private static int findMissingNumberInSequence(int[] sequence) {
		print(sequence);
		int rtnVal = -1;
		int xorValue = sequence.length;
		for(int index = 0; index < sequence.length; index++) {
			xorValue = xorValue ^ (index ^ sequence[index]);
		}
		rtnVal = xorValue >= 0 ? xorValue : rtnVal;
		return rtnVal;
	}
	
	private static int findMissingNumberInSequenceUsingSum(int[] sequence) {
		print(sequence);
		int rtnVal = -1;
		int actualSum = 0;
		for(int number : sequence) actualSum += number;
		int expectedSum = sequence.length * (sequence.length + 1) / 2;
		rtnVal = expectedSum - actualSum;
		return rtnVal;
	}
	
	private static int findMissingNumberInSequenceUsingArray(int[] sequence) {
		print(sequence);
		int rtnVal = -1;
		int[] numbers = new int[sequence.length + 1];
		for(int i = 0; i < sequence.length; i++) numbers[sequence[i]] = 1;
		for(int i = 0; i < sequence.length; i++) {
			if(numbers[i] == 0) {
				rtnVal = i;
				break;
			}
		}
		return rtnVal;
	}
}
