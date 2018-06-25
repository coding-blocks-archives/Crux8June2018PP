
public class Pattern16 {

	public static void main(String[] args) {

		int n = 4;

		int nr = 2 * n - 1;

		int nst = n;
		int nsp = n - 1;
		int row = 1;

		while (row <= nr) {

			// spaces
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			// prep
			if (row <= nr / 2) {
				nst--;
				nsp--;
			} else {
				nst++;
				nsp++;
			}

			row++;
			System.out.println();
		}

	}

}
