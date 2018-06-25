package L3_June14;

import java.util.Scanner;

public class LowerUpper {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		//
		// String s = scn.nextLine();
		// System.out.println(s);
		char ch = scn.nextLine().charAt(0);
		System.out.println(ch);

		if (ch >= 'a' && ch <= 'z') {
			System.out.println("lower");
		} else if (ch >= 'A' && ch <= 'Z') {
			System.out.println("upper");
		} else {
			System.out.println("invalid");
		}

	}

}
