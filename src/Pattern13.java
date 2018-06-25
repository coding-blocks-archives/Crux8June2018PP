
public class Pattern13 {

	public static void main(String[] args) {

		int n = 4;

		int nr = 2 * n - 1;

		int nst = 1;
		int row = 1;

		while (row <= nr) {

			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			// prep
			if (row <= nr / 2) {
				nst++;
			} else {
				nst--;
			}

			row++;
			System.out.println();
		}

	}

}
