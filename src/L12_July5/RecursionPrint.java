package L12_July5;

import L11_July1.RecursionGet;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Jul-2018
 */

public class RecursionPrint {

	public static void main(String[] args) {
		// printSS("abc", "");
		// printKPC("146", "");
		// System.out.println(printPermutation("abc", ""));
		lexicoCounting(0, 1000);
		System.out.println(printBoardPath(0, 10, ""));

	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans); // no
		printSS(roq, ans + ch); // yes

	}

	public static void printKPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String code = RecursionGet.getCode(ch);

		for (int i = 0; i < code.length(); i++) {
			printKPC(roq, ans + code.charAt(i));
		}

	}

	public static int printPermutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		int count = 0;

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			count += printPermutation(roq, ans + ch);
		}

		return count;
	}

	public static void printPermutation1(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		for (int i = 0; i <= ans.length(); i++) {

			String res = ans.substring(0, i) + ch + ans.substring(i);
			printPermutation1(roq, res);
		}

	}

	public static void lexicoCounting(int curr, int end) {

		if (curr > end) {
			System.out.println(curr);
			return;
		}

		// System.out.println(curr);
		int i;

		if (curr == 0) {
			i = 1;
		} else {
			i = 0;
		}

		for (; i <= 9; i++) {
			lexicoCounting(curr * 10 + i, end);
		}

	}

	public static int permutationNoDuplicates(String ques, String ans) {

	}

	public static int printCoinToss(int n, String ans) {

		if (n == 0) {
			System.out.println(ans);
			return 1;
		}

		int h = printCoinToss(n - 1, ans + "H");
		int t = printCoinToss(n - 1, ans + "T");

		return h + t;
	}

	public static int printBoardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += printBoardPath(curr + dice, end, ans + dice);
		}

		return count;
	}

	public static int printMazePath(int cr, int cc, int er, int ec, String ans) {

	}

}
