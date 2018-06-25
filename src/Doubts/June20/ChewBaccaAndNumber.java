package Doubts.June20;

import java.util.Scanner;

public class ChewBaccaAndNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		long n = scn.nextLong();

		ChewBacca(n);

	}

	public static void ChewBacca(long n) {
		long sum = 0;
		long m = 1;

		while (n != 0) {
			long rem = n % 10;

			if (n / 10 == 0) {
				if (rem == 9) {
					rem = 9;
				} else if ((9 - rem) < rem) {
					rem = 9 - rem;
				}
			} else {

				if ((9 - rem) < rem)
					rem = 9 - rem;
			}

			sum = sum + rem * m;
			n = n / 10;
			m = m * 10;
		}
		System.out.println(sum);
	}

}
