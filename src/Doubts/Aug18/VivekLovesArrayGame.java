package Doubts.Aug18;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Aug-2018
 */

public class VivekLovesArrayGame {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		for (int i = 0; i < tc; i++) {

			int n = scn.nextInt();

			int[] arr = new int[n];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = scn.nextInt();
			}

			System.out.println(split(arr, 0, arr.length - 1));
		}
	}

	public static int split(int[] arr, int lo, int hi) {

		if (lo > hi) {
			return 0;
		}

		int ans = 0;
		for (int mid = lo; mid < hi; mid++) {

			int sum1 = 0;
			int sum2 = 0;

			for (int j = lo; j <= mid; j++) {
				sum1 += arr[j];
			}

			for (int j = mid + 1; j <= hi; j++) {
				sum2 += arr[j];
			}

			if (sum1 == sum2) {
				int a1 = split(arr, lo, mid);
				int a2 = split(arr, mid + 1, hi);

				return Math.max(a1, a2) + 1;
			}
		}

		return ans;

	}

}
