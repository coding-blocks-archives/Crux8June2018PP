package L6_June21;

import java.util.Scanner;

public class StringBuilderDemo {

	public static void main(String[] args) {

		System.out.println(Character.isDigit('@'));
		System.out.println(Character.toUpperCase('a'));
		System.out.println(Character.isUpperCase('A'));

		Scanner scn = new Scanner(System.in);

		// string -> sb
		String s = scn.nextLine();
		StringBuilder sb = new StringBuilder(s);

		// length
		System.out.println(sb.length());

		// append
		sb.append("abc");
		System.out.println(sb);
		sb.append('d');
		System.out.println(sb);

		// insert
		sb.insert(3, "qwer");
		System.out.println(sb);
		sb.insert(2, 'u');
		System.out.println(sb);

		// update
		sb.setCharAt(2, 's');
		System.out.println(sb);

		// remove
		sb.deleteCharAt(2);
		System.out.println(sb);

		sb.delete(0, 2);
		System.out.println(sb);

		// sb -> string
		String str = sb.toString();

		System.out.println(str);

		System.out.println(toggleCase(s));

	}

	public static String toggleCase(String str) {

		StringBuilder sb = new StringBuilder();

		int diff = 'a' - 'A';

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (ch >= 'a' && ch <= 'z') {

				sb.append((char) (ch - diff));
			} else {
				sb.append((char) (ch + diff));
			}
		}

		return sb.toString();

	}

}
