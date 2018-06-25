package Doubts.June20;

import java.util.Scanner;

public class ValidInvalid {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println(VI());

	}

	public static boolean VI() {

		int n = scn.nextInt();
		int prev = scn.nextInt();
		boolean flag = true;

		for (int i = 2; i <= n; i++) {

			int curr = scn.nextInt();

			if (flag == true) {
				if (curr < prev) {
				} else {
					flag = false;
				}
			} else {
				if (curr > prev) {
				} else {
					return false;
				}
			}
			prev = curr;
		}

		return true;
	}

}
