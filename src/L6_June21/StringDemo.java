package L6_June21;

public class StringDemo {

	public static void main(String[] args) {

		String s = "hello";

		// String s1 = "hello";
		//
		// String s2 = new String("hello") ;
		//
		// System.out.println(s + " " + s1 + " " + s2);

		System.out.println(s.charAt(0));
		System.out.println(s.charAt(s.length() - 1));

		System.out.println(s.substring(0, 5)); // hello
		System.out.println(s.substring(2, 2)); // blank
		// System.out.println(s.substring(3, 1)); // error

		System.out.println(s.substring(2)); //
		// String s1 = "abhelloc";
		// System.out.println(s1.substring(2, 7));

		String s1 = "hello";
		String s2 = "bye";
		String s3 = s1 + s2;

		System.out.println(s3);
		String s4 = s1.concat(s2);

		System.out.println(s.indexOf("llo"));
		System.out.println(s.indexOf("Llo"));

		System.out.println(s.startsWith("He"));
		System.out.println(s.startsWith("he"));

		s1 = "Hello";
		s2 = s1;
		s3 = "Hello";
		s4 = new String("Hello");

		System.out.println((s1 == s2) + ", " + s1.equals(s2)); // true true
		System.out.println((s1 == s3) + ", " + s1.equals(s3)); // true true
		System.out.println((s1 == s4) + ", " + s1.equals(s4)); // false true

		int i = 2;
		System.out.println(i == 2);

		s = s.replace('l', 'z');

		System.out.println(s);

		appendString();
	}

	public static void appendString() {

		String str = "";
		int n = 100000 ;
		for (int i = 1; i < n; i++) {

			str += i;
		}

	}

}
