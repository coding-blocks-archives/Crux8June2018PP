import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int a = 0;
		int b = 1;

		System.out.println(0);
		System.out.println(1);
		
		int i = 1;

		while (i <= n - 1) {

			int sum = a + b;
			a = b;
			b = sum;

			System.out.println(sum);

			i = i + 1;
		}

	}
}
