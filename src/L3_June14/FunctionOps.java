package L3_June14;

public class FunctionOps {

	public static void main(String[] args) {

		printAllArmstrong(1, 1000);
	}

	public static int numberOfDigits(int num) {

		int count = 0;
		while (num != 0) {
			num = num / 10;
			count++;
		}

		return count;
	}

	public static void printAllArmstrong(int ll, int ul) {

		for (int i = ll; i <= ul; i++) {
			int nod = numberOfDigits(i);
			if (isArmstrong(i, nod)) {
				System.out.println(i);
			}
		}
	}

	public static boolean isArmstrong(int num, int nod) {

		int onum = num;
		int ans = 0;

		while (num != 0) {

			int rem = num % 10;
			ans = ans + (int) Math.pow(rem, nod);
			num = num / 10;
		}

		if (ans == onum) {
			return true;
		} else {
			return false;
		}

	}

}
