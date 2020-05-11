package org.jagan.solutions.arrays;

import java.util.Arrays;

import org.jagan.sorting.SortUtil;

public class ZRotateArray {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5};
		System.out.println("Input Array : " + Arrays.toString(arr));
		rotateArray(arr, 2);
		System.out.println("Output Array : " + Arrays.toString(arr));
		arr = new int[] {1, 2, 3, 4, 5, 6};
		System.out.println("Input Array : " + Arrays.toString(arr));
		rotate(arr, 3);
		System.out.println("Output Array : " + Arrays.toString(arr));
	}
	
	
	public static void rotateArray(int[] arr, int k) {
		int len = arr.length;
		k = k % len;
		reverse(arr, 0, len - 1);
		reverse(arr, 0, k - 1);
		reverse(arr, k, len - 1);
	}
	
	public static void reverse(int[] arr, int start, int end) {
		while(start < end) {
			SortUtil.swap(arr, start++, end--);
		}
	}
	
	public static void rotate(int[] nums, int k) {
		int len = nums.length;
		k = k % len;
		int count = 0;
		for(int startIndex = 0; count < len; startIndex++) {
			int currIndex = startIndex;
			int prevVal = nums[currIndex];
			do {
				int nextIndex = (currIndex + k) % len;
				int temp = nums[nextIndex];
				nums[nextIndex] = prevVal;
				prevVal = temp;
				currIndex = nextIndex;
				count++;
			} while(startIndex != currIndex);
		}
	}
		
}
