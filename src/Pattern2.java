
public class Pattern2 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;
		int nst = 1;

		// no of rows
		while (row <= n) {

			// work
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			row = row + 1;
			nst = nst + 1;
			System.out.println();

		}
	}
}
