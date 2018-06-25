public class Pattern32 {

	public static void main(String[] args) {

		int n = 5;

		int nr = 2 * n - 1;
		int nst = 1;

		int row = 1;

		int val;

		while (row <= nr) {

			if (row <= n) {
				val = row;
			} else {
				val = nr - row + 1;
			}
			
			// stars
			for (int cst = 1; cst <= nst; cst++) {
				if (cst % 2 == 0)
					System.out.print("*");
				else
					System.out.print(val);
			}

			if (row <= nr / 2)
				nst += 2;
			else
				nst -= 2;
			row++;
			System.out.println();
		}

	}

}
