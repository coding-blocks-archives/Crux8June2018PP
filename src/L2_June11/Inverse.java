package L2_June11;

import java.util.Scanner;

public class Inverse {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int ans = 0;
		int count = 1;

		while (n != 0) {

			int rem = n % 10;
			ans = ans + (count * (int) Math.pow(10, rem - 1));
			
			count++;
			n = n / 10;
		}

		System.out.println(ans);
	}

}
