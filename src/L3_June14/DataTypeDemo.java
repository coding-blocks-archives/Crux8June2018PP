package L3_June14;

public class DataTypeDemo {

	public static void main(String[] args) {

		// byte b = (byte) 130;
		// System.out.println(b);

		byte by = 10;
		short sh = 10;
		int in = 10;
		long lo = 10;

		// part 1
		// by = sh ;
		// by= in ;
		// by = lo;

		sh = by;
		// sh = in;
		// sh = lo;

		in = by;
		in = sh;
		// in = lo;

		lo = by;
		lo = sh;
		lo = in;

		// part 2
		by = 10;
		by = (byte) 278;
		System.out.println(by);

		// for (byte i = 0; i <= 127; i++) {
		//
		// System.out.println(i);
		// }

		// part 3
		in = (int) 10000000000L;
		System.out.println(in);

		// Part 4
		// float fl = 5.5f;
		float fl = (float) 5.5;
		double db = 5.5;

		// fl = db;
		db = fl;

		// Part 5
		// in = fl;
		in = (int) fl;
		System.out.println(in);
		fl = in;
		System.out.println(fl);

		// Part 6
		boolean bl = true;
		bl = false;
		// bl = 0;
		// bl = 1;

		// if (in) {
		// System.out.println("hi");
		// } else {
		// System.out.println("bye");
		// }

		if (in > 0) {
			System.out.println("hi");
		} else {
			System.out.println("bye");
		}

		if (bl) {
			System.out.println("hi");
		} else {
			System.out.println("bye");
		}

		// Part 7
		char ch;
		ch = 97;
		System.out.println(ch);

		in = ch;
		// ch = in;

		in = (char) (ch + 2);
		System.out.println(in);
		System.out.println((char)in);
		// ch = (char) (ch + 2);

		// Part 8
		System.out.println(10 + 20 + "Hello" + (10 + 20));
		System.out.println(2 + ' ' + 5); // 39
		System.out.println(2 + " " + 5); // 2 5
		System.out.println("Hello" + '\t' + "World");
		System.out.println("Hello" + "\t" + "World");
		//
		// System.out.println("\t");
	}

}
