package L6_June21;

import java.util.Scanner;

public class StringOps {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		String str = scn.nextLine();
		// System.out.println(reverse(str));

		String[] arr = str.split("\\s+");
		for (String val : arr) {
			System.out.println(val);
		}
	}

	public static void printChars(String str) {

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}

	}

	public static void substrings(String str) {

		for (int si = 0; si < str.length(); si++) {

			for (int ei = si + 1; ei <= str.length(); ei++) {

				String ss = str.substring(si, ei);
				System.out.println(ss);
			}

		}
	}

	public static boolean isPalindrome(String str) {

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;

		}

		return true;

	}

	public static void palindromicSS(String str) {

		for (int si = 0; si < str.length(); si++) {

			for (int ei = si + 1; ei <= str.length(); ei++) {

				String ss = str.substring(si, ei);
				if (isPalindrome(ss))
					System.out.println(ss);
			}

		}
	}

	public static String reverse(String str) {

		String subans = "";
		String ans = "";

		for (int i = str.length() - 1; i >= 0; i--) {

			char ch = str.charAt(i);

			if (ch == '+' || ch == '-' || ch == '*') {

				ans = ans + subans;
				ans = ans + ch;
				subans = "";

			} else {
				subans = ch + subans;
			}

		}

		ans = ans + subans;

		return ans;

	}

}
