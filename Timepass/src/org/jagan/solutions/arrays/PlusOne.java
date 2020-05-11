package org.jagan.solutions.arrays;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		int[] arr = new int[] {9, 9, 9, 9};
		System.out.println("Input Array : " + Arrays.toString(arr));
		int[] newArr = plusOne(arr);
		System.out.println("Output Array : " + Arrays.toString(newArr));
	}
	
	public static int[] plusOne(int[] digits) {   
	    int n = digits.length;
	    for(int i = n-1; i >= 0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }
	        digits[i] = 0;
	    }
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    return newNumber;
	}
}
