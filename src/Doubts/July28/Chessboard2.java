package Doubts.July28;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Jul-2018
 */

public class Chessboard2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arr = makeMNP(SOE(n * n));

		c2(0, 0, n - 1, "", arr);
	}

	public static void c2(int cr, int cc, int n, String asf, int[] mnp) {

		if (cr == n && cc == n) {
			System.out.println(asf + "{" + n + "-" + n + "}");
			return;
		}

		if (cr > n || cc > n) {
			return;
		}

		int val = (cr * (n + 1)) + (cc + 1);

		// mine
		if (mnp[val] == 1) {
			return;
		} else if (mnp[val] == 2) {
			c2(n, n, n, asf + "{" + cr + "-" + cc + "}" + "P", mnp);
		}

		// knight
		c2(cr + 2, cc + 1, n, asf + "{" + cr + "-" + cc + "}" + "K", mnp);
		c2(cr + 1, cc + 2, n, asf + "{" + cr + "-" + cc + "}" + "K", mnp);

		if (cr == 0 || cr == n || cc == 0 || cc == n) {

			// rook horizontal
			for (int col = 1; col <= n; col++) {
				c2(cr, cc + col, n, asf + "{" + cr + "-" + cc + "}" + "R", mnp);
			}

			// rook vertical
			for (int row = 1; row <= n; row++) {
				c2(cr + row, cc, n, asf + "{" + cr + "-" + cc + "}" + "R", mnp);
			}
		}

		if (cr == cc || cr + cc == n) {
			for (int d = 1; d <= n && d <= n; d++) {
				c2(cr + d, cc + d, n, asf + "{" + cr + "-" + cc + "}" + "B", mnp);
			}
		}
	}

	public static int[] makeMNP(boolean[] primes) {

		int count = 1;

		int[] mnp = new int[primes.length];

		for (int i = 0; i < primes.length; i++) {

			if (primes[i]) {

				if (count % 2 == 1) {
					mnp[i] = 1;
				} else {
					mnp[i] = 2;
				}

				count++;

			}
		}

		return mnp;

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
