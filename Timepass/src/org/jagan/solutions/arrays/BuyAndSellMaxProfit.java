package org.jagan.solutions.arrays;

import java.util.Arrays;

public class BuyAndSellMaxProfit {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5};
		System.out.println("Input Array : " + Arrays.toString(arr));
		int maxProfit = getMaxProfit(arr);
		System.out.println("New Length : " + maxProfit);
	}
	
	private static int getMaxProfit(int[] arr) {
		int maxProfit = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			int diff = arr[i+1] - arr[i];
			if(diff > 0) maxProfit += diff;
		}
		return maxProfit;
	}
}
