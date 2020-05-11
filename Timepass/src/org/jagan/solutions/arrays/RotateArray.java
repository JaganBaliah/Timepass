package org.jagan.solutions.arrays;

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5};
		System.out.println("Input Array : " + Arrays.toString(arr));
		rotateArray(arr, 2);
		System.out.println("Output Array : " + Arrays.toString(arr));
	}
	
	public static void rotateArrayBruteForce(int[] arr, int k) {
		for(int i = 0; i < k; i++) {
			int previous = arr[arr.length - 1];
			for(int j = 0; j < arr.length; j++) {
				int temp = arr[j];
				arr[j] = previous;
				previous = temp;
			}
		}
	}
	
	public static void rotateArray(int[] arr, int k) {
		int len = arr.length;
		k = k % len;
		reverse(arr, 0, len-1);
		reverse(arr, 0, k-1);
		reverse(arr, k, len-1);
	}
	
	public static void reverse(int[] arr, int start, int end) {
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		int count = 0;
		for (int startIdx = 0; count < nums.length; startIdx++) {
			int currentIdx = startIdx;
			int prevVal = nums[startIdx];
			do {
				int nextIdx = (currentIdx + k) % nums.length;
				int tempVal = nums[nextIdx];
				nums[nextIdx] = prevVal;
				prevVal = tempVal;
				currentIdx = nextIdx;
				count++;
			} while (startIdx != currentIdx);
		}
	}
		
}
