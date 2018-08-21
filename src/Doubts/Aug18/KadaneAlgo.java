package Doubts.Aug18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Aug-2018
 */

public class KadaneAlgo {

	public static void main(String[] args) {

		int[] arr = { -5, 6, 7, -1, 4, -18, 15, 5 };

		int[] strg = new int[arr.length];

		if (arr[0] < 0) {
			strg[0] = 0;
		} else {
			strg[0] = arr[0];
		}

		for (int i = 1; i < arr.length; i++) {

			if (strg[i - 1] + arr[i] > arr[i]) {
				strg[i] = strg[i - 1] + arr[i];
			} else {
				strg[i] = arr[i];
			}
		}

		int max = Integer.MIN_VALUE;

		for (int val : strg) {
			if (val > max) {
				max = val;
			}
		}

		System.out.println(max);

	}

}
