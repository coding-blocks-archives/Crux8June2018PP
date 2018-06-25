package L2_June11;

import java.util.Scanner;

public class Rotate {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int r = scn.nextInt();

		int nod = 0;

		int temp = n;

		// no of digits
		while (temp != 0) {
			temp = temp / 10;
			nod++;
		}

		r = r % nod;

		if (r < 0)
			r = r + nod;

		int divisor = (int) Math.pow(10, r);
		int rem = n % divisor; // 3456
		int quotient = n / divisor; // 12

		int multiplier = (int) Math.pow(10, nod - r);
		int ans = rem * multiplier + quotient;

		System.out.println(ans);

	}

}
