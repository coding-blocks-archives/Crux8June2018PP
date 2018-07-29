package Doubts.July28;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Jul-2018
 */

public class SnakeAndLadders {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int m = scn.nextInt();

		int[] dices = new int[m];

		for (int i = 0; i < m; i++) {
			dices[i] = scn.nextInt();
		}

		int[] arr = makeLadders(SOE(n));
		System.out.println(snl(arr, dices, 0, 0, n));

	}

	public static boolean snl(int[] ladders, int[] dices, int vidx, int curr, int end) {

		if (curr == end) {
			return true;
		}

		if (vidx == dices.length) {
			return false;
		}

		if (curr > end) {
			return false;
		}

		if (ladders[curr] != 0) {
			return snl(ladders, dices, vidx, ladders[curr], end);
		} else {

			while (vidx < dices.length - 1 && curr + dices[vidx] > end) {
				vidx++;
			}

			return snl(ladders, dices, vidx + 1, curr + dices[vidx], end);

		}

	}

	public static int[] makeLadders(boolean[] primes) {

		int[] ladders = new int[primes.length];

		int left = 0;
		int right = primes.length - 1;

		int count = 0;

		while (left < right) {

			while (primes[left] == false) {
				left++;
			}

			while (primes[right] == false) {
				right--;
			}

			if (left < right) {

				if (count % 2 == 0)
					ladders[left] = right;
				else
					ladders[right] = left;

				count++;

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
