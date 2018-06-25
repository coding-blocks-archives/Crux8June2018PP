package L3_June14;

public class FunctionDemo {

	static int abc = 100;

	public static void main(String[] args) {

		System.out.println("hii");
		// fxn call
		addition();
		System.out.println("bye");

		subtraction();
		System.out.println("after sub");

		additionParams(10, 20);

		int sum = additionParamsRV(20, 30);
		System.out.println(sum);

		System.out.println("----------- Part-4 -----------");
		System.out.println(abc);
		int abc = 200;
		System.out.println(abc);
		System.out.println(FunctionDemo.abc);
		System.out.println(DemoGlobalScopes(FunctionDemo.abc));
		System.out.println(FunctionDemo.abc);

		int one = 10;
		int two = 20;
		// Part 5 - Pass by value
		System.out.println("----------- Part-5 -----------");
		System.out.println(one + ", " + two);
		Swap(one, two);
		System.out.println(one + ", " + two);
	}

	public static void Swap(int one, int two) {
		System.out.println(one + ", " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + ", " + two);
	}

	public static int DemoGlobalScopes(int one) {
		int abc = 500;
		FunctionDemo.abc = 1000;

		int sum = one + FunctionDemo.abc;
		return sum;
	}

	public static int additionParamsRV(int a, int b) {

		int sum = a + b;
		return sum;

	}

	public static void additionParams(int a, int b) {

		int sum = a + b;
		System.out.println(sum);

	}

	// fxn def
	public static void addition() {

		int a = 2;
		int b = 5;
		int sum = a + b;

		subtraction();

		System.out.println(sum);

	}

	public static void subtraction() {

		int a = 2;
		int b = 5;
		int sub = a - b;

		System.out.println(sub);
	}

}
