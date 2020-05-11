package org.jagan.solutions.arrays;

import java.util.Arrays;

public class ZBuyAndSellMaxProfit {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5};
		System.out.println("Input Array : " + Arrays.toString(arr));
		int maxProfit = getMaxProfit(arr);
		System.out.println("New Length : " + maxProfit);
	}
	
	private static int getMaxProfit(int[] arr) {
		int profit = 0;
		for(int i = 1; i < arr.length; i++) {
			int diff = arr[i] - arr[i - 1];
			if(diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}
}
