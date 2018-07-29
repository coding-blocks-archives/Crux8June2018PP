package Doubts.July28;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Jul-2018
 */

public class OnlyLadders {

	public static void main(String[] args) {

		int n = 3;
		int[] arr = makeLadders(SOE(n));

		// for (int val : arr)
		//	System.out.println(val);

		ol(arr, 0, n, "");

	}

	public static void ol(int[] ladders, int curr, int end, String asf) {

		if (curr == end) {
			System.out.print(asf + " END , ");
			return;
		}

		if (curr > end) {
			return;
		}

		if (ladders[curr] != 0) {
			ol(ladders, ladders[curr], end, asf + " " + curr);
		} else {

			for (int dice = 1; dice <= 6; dice++) {
				ol(ladders, curr + dice, end, asf + " " + curr);
			}
		}

	}

	public static int[] makeLadders(boolean[] primes) {

		int[] ladders = new int[primes.length];

		int left = 0;
		int right = primes.length - 1;

		while (left < right) {

			while (primes[left] == false) {
				left++;
			}

			while (primes[right] == false) {
				right--;
			}

			if (left < right) {
				ladders[left] = right;
				left++;
				right--;
			}

		}

		return ladders;

	}

	public static boolean[] SOE(int n) {

		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table] == true) {

				for (int mult = 2; mult * table <= n; mult++) {
					primes[mult * table] = false;
				}
			}

		}

		return primes;

	}

}
