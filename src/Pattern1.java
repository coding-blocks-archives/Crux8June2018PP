
public class Pattern1 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		// no of rows
		while (row <= n) {

			// work
			int col = 1;
			while (col <= n) {
				System.out.print("*");
				col = col + 1;
			}

			// prep
			row = row + 1;
			System.out.println();

		}
	}
}
