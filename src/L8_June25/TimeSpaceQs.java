package L8_June25;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 25, 2018
 */

public class TimeSpaceQs {

	public static void main(String[] args) {

		// SOE(25);
		// System.out.println(power(2, 10));
		System.out.println(polynomial(3, 7));

		System.out.println(countPalindromicSS("nitin"));
	}

	// O(nloglogn)
	public static void SOE(int n) {

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

		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}

	}

	// O(logn)
	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int sp = power(x, n / 2);
		int res;
		if (n % 2 == 0) {
			res = sp * sp;
		} else {
			res = sp * sp * x;
		}

		return res;

	}

	// O(n)
	public static int polynomial(int x, int n) {

		int mult = x;
		int sum = 0;
		for (int coeff = n; coeff >= 1; coeff--) {

			sum = sum + (coeff * mult);
			mult = mult * x;
		}

		return sum;

	}

	// O(n^2)
	public static int countPalindromicSS(String str) {

		int count = 0;

		// odd length pss
		for (int axis = 0; axis < str.length(); axis++) {

			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else {
					break;
				}
			}

		}

		// even length pss
		for (double axis = 0.5; axis < str.length(); axis++) {

			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else {
					break;
				}
			}

		}

		return count;

	}

}
