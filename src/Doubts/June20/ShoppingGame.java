package Doubts.June20;

import java.util.Scanner;

public class ShoppingGame {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int testc = scn.nextInt();

		for (int i = 0; i < testc; i++) {

			int m = scn.nextInt();
			int n = scn.nextInt();

			int k = 1;
			int j = 2;

			int sumk = 0;

			while (sumk <= m) {
				k = k + 2;
				sumk = sumk + k;
			}

			int sumj = 0;
			while (sumj <= n) {
				j = j + 2;
				sumj = sumj + j;
			}

			if (sumk > sumj) {
				System.out.println("Aayush");
			} else {
				System.out.println("Harshit");
			}
		}
	}
}
