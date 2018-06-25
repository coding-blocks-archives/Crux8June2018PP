package L7_June22;

public class RecursionDemo {

	public static void main(String[] args) {
		// printIncDec(5, 1);
		// System.out.println(fibonacci(8));

		int[] arr = { 10, 200, 20, 20, 50, 20 };

		// displayRev(arr, 0);
		System.out.println(max(arr, 0));
		System.out.println(findFirstIndex(arr, 0, 20));
		System.out.println(findLastIndex(arr, 0, 20));
		int[] rr = findAllIndex(arr, 0, 20, 0);
		for (int val : rr) {
			System.out.println(val);
		}
		System.out.println();

	}

	public static void printDec(int n) {

		if (n == 0) {
			return;
		}

		// self work
		System.out.println(n);

		// assumption
		printDec(n - 1);

	}

	public static void printInc(int n) {

		if (n == 0) {
			return;
		}

		// assumption
		printInc(n - 1);

		// self work
		System.out.println(n);

	}

	public static void printDecInc(int n) {

		if (n == 0) {
			return;
		}

		System.out.println(n);
		printDecInc(n - 1);
		System.out.println(n);

	}

	public static void printIncDec(int n, int c) {

		if (n < c) {
			return;
		}

		System.out.println(c);
		printIncDec(n, c + 1);
		System.out.println(c);

	}

	public static int factorial(int n) {

		if (n == 1) {
			return 1;
		}

		// assumption
		int fnm1 = factorial(n - 1);

		// self work
		int fn = fnm1 * n;

		return fn;

	}

	// calculates x^n
	// O(n)
	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int pnm1 = power(x, n - 1);
		int pn = x * pnm1;

		return pn;

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

	public static void display(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}
		System.out.print(arr[vidx] + " ");
		display(arr, vidx + 1);

	}

	public static void displayRev(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		displayRev(arr, vidx + 1);
		System.out.print(arr[vidx] + " ");

	}

	public static int max(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}

		int rr = max(arr, vidx + 1);

		if (arr[vidx] > rr) {
			return arr[vidx];
		} else {
			return rr;
		}

	}

	public static int findFirstIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}
		int rr = findFirstIndex(arr, vidx + 1, item);

		if (arr[vidx] == item) {
			return vidx;
		}

		return rr;
	}

	public static int findLastIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}
		int rr = findLastIndex(arr, vidx + 1, item);

		if (arr[vidx] == item && rr == -1) {
			return vidx;
		}

		return rr;
	}

	public static int[] findAllIndex(int[] arr, int vidx, int item, int count) {

		if (vidx == arr.length) {
			int[] br = new int[count];
			return br;
		}

		if (arr[vidx] == item) {
			int[] rr = findAllIndex(arr, vidx + 1, item, count + 1);
			rr[count] = vidx;
			return rr;
		} else {
			int[] rr = findAllIndex(arr, vidx + 1, item, count);
			return rr;
		}

	}
}
