package Doubts.July28;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Jul-2018
 */

public class Painters {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int nop = scn.nextInt();

		int nob = scn.nextInt();

		int[] arr = new int[nob];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Arrays.sort(arr);

		pp(arr, nop, nob);
	}

	public static void pp(int[] arr, int nop, int nob) {

		int sum = 0;

		for (int val : arr) {
			sum += val;
		}

		int lo = 0;
		int hi = sum;

		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(arr, nop, nob, mid)) {
				hi = mid - 1;
				finalAns = mid;
			} else {
				lo = mid + 1;
			}

		}

		System.out.println(finalAns);

	}

	private static boolean isPossible(int[] arr, int nop, int nob, int mid) {

		int timeRemaining = mid;
		int painters = 1;

		// i denotes the no. of board painted
		int i = 0;

		while (i < arr.length && painters <= nop) {

			if (arr[i] <= timeRemaining) {
				timeRemaining = timeRemaining - arr[i];
				i++;
			} else {

				painters++;
				timeRemaining = mid;

			}
		}

		if (i == arr.length) {
			return true;
		}
		return false;
	}

}
