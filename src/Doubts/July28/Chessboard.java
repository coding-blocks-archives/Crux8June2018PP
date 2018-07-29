package Doubts.July28;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Jul-2018
 */

public class Chessboard {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		c1(0, 0, n - 1, "");
	}

	public static void c1(int cr, int cc, int n, String asf) {

		if (cr == n && cc == n) {
			System.out.println(asf + "{" + n + "-" + n + "}");
			return;
		}

		if (cr > n || cc > n) {
			return;
		}

		// knight
		c1(cr + 2, cc + 1, n, asf + "{" + cr + "-" + cc + "}" + "K");
		c1(cr + 1, cc + 2, n, asf + "{" + cr + "-" + cc + "}" + "K");

		if (cr == 0 || cr == n || cc == 0 || cc == n) {

			// rook horizontal
			for (int col = 1; col <= n; col++) {
				c1(cr, cc + col, n, asf + "{" + cr + "-" + cc + "}" + "R");
			}

			// rook vertical
			for (int row = 1; row <= n; row++) {
				c1(cr + row, cc, n, asf + "{" + cr + "-" + cc + "}" + "R");
			}
		}

		if (cr == cc || cr + cc == n) {
			for (int d = 1; d <= n && d <= n; d++) {
				c1(cr + d, cc + d, n, asf + "{" + cr + "-" + cc + "}" + "B");
			}
		}
	}
	
}
