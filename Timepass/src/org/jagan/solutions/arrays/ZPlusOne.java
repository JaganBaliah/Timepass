package org.jagan.solutions.arrays;

import java.util.Arrays;

public class ZPlusOne {

	public static void main(String[] args) {
		int[] arr = new int[] {8, 1, 9, 8};
		System.out.println("Input Array : " + Arrays.toString(arr));
		int[] newArr = plusOne(arr);
		System.out.println("Output Array : " + Arrays.toString(newArr));
		arr = new int[] {9, 9, 9, 9};
		System.out.println("Input Array : " + Arrays.toString(arr));
		newArr = plusOne(arr);
		System.out.println("Output Array : " + Arrays.toString(newArr));
	}
	
	public static int[] plusOne(int[] digits) {
		for(int i = digits.length - 1; i >= 0; i--) {
			if(digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int[] rtnVal = new int[digits.length + 1];
		rtnVal[0] = 1;
		return rtnVal;
	}
}
