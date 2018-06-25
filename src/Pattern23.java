public class Pattern23 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;
		int nsp = n - 1;
		int row = 1;

		int val = 1;

		while (row <= n) {

			val = 1;

			// spaces
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);
				if (cst <= nst / 2) {
					val++;
				} else {
					val--;
				}

			}

			val++;
			// prep

			nst += 2;
			nsp--;

			row++;
			System.out.println();
		}

	}

}
