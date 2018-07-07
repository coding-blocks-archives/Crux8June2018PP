package L11_July1;

import java.util.ArrayList;

public class RecursionGet {

	public static void main(String[] args) {

		// System.out.println(getPermutations("abc"));
		// System.out.println(getCoinToss(3));
		// System.out.println(getBoardPath(0, 10));
		// System.out.println(getMazePath(0, 0, 2, 2));
		System.out.println(getMazePathDiag(0, 0, 2, 2));
	}

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSS(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			mr.add(rrs);
			mr.add(ch + rrs);
		}

		return mr;
	}

	public static ArrayList<String> getSSAscii(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSSAscii(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			mr.add(rrs);
			mr.add(ch + rrs);
			mr.add((int) ch + rrs);
		}

		return mr;
	}

	public static String getCode(char ch) {

		if (ch == '1') {
			return "abc";
		} else if (ch == '2') {
			return "def";
		} else if (ch == '3') {
			return "ghi";
		} else if (ch == '4') {
			return "jklm";
		} else if (ch == '5') {
			return "nop";
		} else if (ch == '6') {
			return "qr";
		} else if (ch == '7') {
			return "stu";
		} else if (ch == '8') {
			return "vw";
		} else if (ch == '9') {
			return "xyz";
		} else if (ch == '0') {
			return "#$";
		} else {
			return "";
		}
	}

	public static ArrayList<String> getKPC(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getKPC(ros);
		ArrayList<String> mr = new ArrayList<>();

		String code = getCode(ch);

		for (int i = 0; i < code.length(); i++) {

			// for (String rrs : rr) {
			// mr.add(code.charAt(i) + rrs);
			// }

			for (int j = 0; j < rr.size(); j++) {
				mr.add(code.charAt(i) + rr.get(j));
			}
		}

		return mr;

	}

	public static ArrayList<String> getPermutations(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getPermutations(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {

			// StringBuilder sb = new StringBuilder(rrs);
			for (int i = 0; i <= rrs.length(); i++) {

				mr.add(rrs.substring(0, i) + ch + rrs.substring(i));

				// sb.insert(i, ch);
				// mr.add(sb.toString());
				// sb.deleteCharAt(i);
			}
		}

		return mr;

	}

	public static ArrayList<String> getCoinToss(int n) {

		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> rr = getCoinToss(n - 1);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			mr.add("H" + rrs);
			mr.add("T" + rrs);

		}
		return mr;
	}

	public static ArrayList<String> getBoardPath(int curr, int end) {

		// +ve base case
		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		// -ve base case
		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = getBoardPath(curr + dice, end);
			for (String rrs : rr) {
				mr.add(dice + rrs);
			}

		}

		return mr;
	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = getMazePath(cr, cc + 1, er, ec);

		for (String rrs : rrh) {
			mr.add("H" + rrs);
		}

		ArrayList<String> rrv = getMazePath(cr + 1, cc, er, ec);

		for (String rrs : rrv) {
			mr.add("V" + rrs);
		}

		return mr;

	}

	public static ArrayList<String> getMazePathDiag(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = getMazePathDiag(cr, cc + 1, er, ec);

		for (String rrs : rrh) {
			mr.add("H" + rrs);
		}

		ArrayList<String> rrv = getMazePathDiag(cr + 1, cc, er, ec);

		for (String rrs : rrv) {
			mr.add("V" + rrs);
		}

		ArrayList<String> rrd = getMazePathDiag(cr + 1, cc + 1, er, ec);

		for (String rrs : rrd) {
			mr.add("D" + rrs);
		}

		return mr;

	}

}
