package L14_July12;

/**
 * @author Garima Chhikara
 * @date Jul 12, 2018
 */

public class DPDemos {

	public static void main(String[] args) {

		int n = 100;

		long start = System.currentTimeMillis();
		// System.out.println(fibonacciTD(n, new int[n + 1]));
		// System.out.println(fibonacciBU(n));
		// System.out.println(fibonacciBUSE(n));

		System.out.println(boardPathTD(0, n, new int[n + 1]));
		System.out.println(boardPathBU(n));
		System.out.println(boardPathBUSE(n));
		long end = System.currentTimeMillis();

		System.out.println("Time : " + (end - start));

	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	public static int fibonacciTD(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = fibonacciTD(n - 1, strg);
		int fnm2 = fibonacciTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		strg[n] = fn;
		return fn;

	}

	public static int fibonacciBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];

	}

	public static int fibonacciBUSE(int n) {

		int[] strg = new int[2];
		strg[0] = 0;
		strg[1] = 1;

		for (int slide = 1; slide <= n - 1; slide++) {

			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;

		}

		return strg[1];

	}

	public static int boardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += boardPathTD(curr + dice, end, strg);
		}

		strg[curr] = count;

		return count;
	}

	public static int boardPathBU(int n) {

		int[] strg = new int[n + 6];

		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}
		return strg[0];

	}

	public static int boardPathBUSE(int n) {

		int[] strg = new int[6];
		strg[0] = 1;
		for (int slide = 1; slide <= n; slide++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];

			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = sum;
		}
		return strg[0];

	}

}
