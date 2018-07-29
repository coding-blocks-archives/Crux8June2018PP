package Doubts.July28;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Jul-2018
 */

public class CBScholarship {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int m = scn.nextInt();
		int x = scn.nextInt();
		int y = scn.nextInt();

		cbs(n, m, x, y);
	}

	public static void cbs(int n, int m, int x, int y) {

		int lo = 0;
		int hi = n;

		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			// mid -> no of students who are given scholarship
			if (isPossible(n, m, x, y, mid)) {
				lo = mid + 1;

				finalAns = mid;
			} else {
				hi = mid - 1;
			}

		}

		System.out.println(finalAns);

	}

	private static boolean isPossible(int n, int m, int x, int y, int mid) {

		int couponsNeeded = mid * x;
		int coupounsCB = m + (n - mid) * y;

		if (couponsNeeded <= coupounsCB) {
			return true;
		} else {
			return false;
		}

	}

}
