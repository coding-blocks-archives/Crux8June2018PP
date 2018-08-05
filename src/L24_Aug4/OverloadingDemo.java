package L24_Aug4;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Aug-2018
 */

public class OverloadingDemo {

	public static void main(String[] args) {

		System.out.println(sum(2, 3));
		int a = sum(4, 5);
		sum(2, 3, 4, 5);
		// sum(2.3, 4.5);

		int[] arr = { 10, 20, 30, 40, 50 };

		System.out.println(sum(arr));

		System.out.println();

	}

	// overloading cannot be done on return type
	// public static void sum(int a, int b) {
	// System.out.println(a + b);
	// }

	public static int sum(int a, int b) {
		return a + b;
	}

	public static void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}

	public static int sum(int... args) {

		int s = 0;
		for (int val : args) {
			s += val;
		}

		return s;

	}

}
