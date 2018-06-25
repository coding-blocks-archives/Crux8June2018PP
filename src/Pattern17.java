
public class Pattern17 {

	public static void main(String[] args) {

		int n = 9;

		int nst = n / 2;
		int nsp = 1;
		int row = 1;

		while (row <= n) {

			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			// spaces
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			// prep
			if (row <= n / 2) {
				nst--;
				nsp += 2;
			} else {
				nst++;
				nsp -= 2;
			}

			row++;
			System.out.println();
		}

	}

}
