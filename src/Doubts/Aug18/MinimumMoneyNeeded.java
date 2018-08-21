package Doubts.Aug18;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Aug-2018
 */

public class MinimumMoneyNeeded {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int w = scn.nextInt();

		int[] arr = new int[w + 1];

		// arr[0] will contain 0 i.e. the price for purchasing 0 weight packet is 0
		for (int i = 1; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		// int[] arr = { 0, 2, 5, 7, -1, 12 };

		System.out.println(minMoneyBU(arr, arr.length - 1));
	}

	public static int minMoneyBU(int[] prices, int n) {

		int[] strg = new int[prices.length];

		for (int i = 1; i < strg.length; i++) {

			int min = prices[i];

			if (prices[i] == -1) {
				min = Integer.MAX_VALUE;
			}

			int left = 1;
			int right = i - 1;

			while (left <= right) {

				int fp = strg[left];
				int sp = strg[right];

				// we cannot add two max values, answer will overflow, so put a condition before
				// adding
				if (fp != Integer.MAX_VALUE && sp != Integer.MAX_VALUE) {
					int ans = fp + sp;

					if (ans < min) {
						min = ans;
					}
				}
				left++;
				right--;

			}

			strg[i] = min;

		}

		return strg[n];
	}

}
