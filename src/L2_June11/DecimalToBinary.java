package L2_June11;

public class DecimalToBinary {

	public static void main(String[] args) {

		int n = 19;

		int ans = 0;
		int multiplier = 1;

		while (n != 0) {

			int rem = n % 2;
			ans = ans + (rem * multiplier);

			n = n / 2;
			multiplier = multiplier * 10;
		}

		System.out.println(ans);
	}

}
