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
		// lexicoCounting(0, 1000);
		// System.out.println(printBoardPath(0, 10, ""));
		// System.out.println(printMazePathDMM(0, 0, 2, 2, ""));
		// System.out.println(permutationNoDuplicates("abca", ""));
		System.out.println(permutationLexicoLarger("bcad", "", false));

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

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		int count = 0;

		boolean[] processed = new boolean[256];

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);

			if (processed[ch] == true) {
				continue;
			}

			String roq = ques.substring(0, i) + ques.substring(i + 1);
			count += permutationNoDuplicates(roq, ans + ch);
			processed[ch] = true;
		}

		return count;

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

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int hc = printMazePath(cr, cc + 1, er, ec, ans + "H");
		int vc = printMazePath(cr + 1, cc, er, ec, ans + "V");

		return hc + vc;
	}

	public static int printMazePathD(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int hc = printMazePathD(cr, cc + 1, er, ec, ans + "H");
		int vc = printMazePathD(cr + 1, cc, er, ec, ans + "V");
		int dc = printMazePathD(cr + 1, cc + 1, er, ec, ans + "D");

		return hc + vc + dc;
	}

	public static int printMazePathDMM(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		for (int i = 1; i <= ec; i++) {
			count += printMazePathDMM(cr, cc + i, er, ec, ans + "H" + i);
		}

		for (int i = 1; i <= er; i++) {
			count += printMazePathDMM(cr + i, cc, er, ec, ans + "V" + i);
		}

		for (int i = 1; i <= er && i <= ec; i++) {
			count += printMazePathDMM(cr + i, cc + i, er, ec, ans + "D" + i);
		}

		return count;
	}

	public static int permutationLexicoLarger(String ques, String ans, boolean isLarger) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		int count = 0;

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (isLarger) {
				count += permutationLexicoLarger(roq, ans + ch, true);
			} else {

				if (ch > ques.charAt(0)) {
					count += permutationLexicoLarger(roq, ans + ch, true);
				} else if (ch < ques.charAt(0)) {
					// no call
				} else {
					count += permutationLexicoLarger(roq, ans + ch, false);
				}
			}
		}

		return count;

	}

}
