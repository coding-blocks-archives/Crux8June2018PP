package Doubts.July28;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Jul-2018
 */

public class ReadThePages {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int nob = scn.nextInt();

		int nos = scn.nextInt();

		int[] arr = new int[nob];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Arrays.sort(arr);

		rtp(arr, nob, nos);
	}

	public static void rtp(int[] arr, int nob, int nos) {

		int sum = 0;

		for (int val : arr) {
			sum += val;
		}

		int lo = 0;
		int hi = sum;

		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(arr, nob, nos, mid)) {
				hi = mid - 1;
				finalAns = mid;
			} else {
				lo = mid + 1;
			}

		}

		System.out.println(finalAns);

	}

	private static boolean isPossible(int[] arr, int nob, int nos, int mid) {

		int students = 1;
		int pagesRead = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > mid) {
				return false;
			}

			if (pagesRead + arr[i] <= mid) {
				pagesRead += arr[i];
			} else {
				students++;
				pagesRead = arr[i];

				if (students > nos) {
					return false;
				}
			}
		}

		return true;
	}

}
