package L13_July9;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Jul-2018
 */

public class BackTrackingDemo {

	public static void main(String[] args) {
		int n = 4;
		NQueens(new boolean[n][n], 0, "");

		// pattern(1, 1, 5);

		int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		// System.out.println(sudokuSolver(board, 0, 0));
	}

	public static void NQueens(boolean[][] board, int row, String asf) {

		if (row == board.length) {
			System.out.println(asf);
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				NQueens(board, row + 1, asf + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}

		}

	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {

		// vertically up
		int r = row - 1;
		int c = col;

		while (r >= 0) {

			if (board[r][c]) {
				return false;
			}

			r--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {

			if (board[r][c]) {
				return false;
			}

			r--;
			c--;
		}

		// diagonally right
		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {

			if (board[r][c]) {
				return false;
			}

			r--;
			c++;
		}

		return true;

	}

	public static void pattern(int row, int col, int n) {

		if (row == n + 1) {
			return;
		}

		if (col == n + 1) {
			System.out.println();
			pattern(row + 1, 1, n);
			return;
		}

		System.out.print("*");

		pattern(row, col + 1, n);
	}

	public static void display(int[][] board) {

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
	}

	public static boolean sudokuSolver(int[][] board, int row, int col) {

		if (row == board.length) {
			display(board);
			return true;
		}

		if (col == board[0].length) {
			return sudokuSolver(board, row + 1, 0);
		}

		if (board[row][col] != 0) {
			return sudokuSolver(board, row, col + 1);
		}

		for (int i = 1; i <= 9; i++) {

			if (isItSafeSS(board, row, col, i)) {
				board[row][col] = i;

				boolean res = sudokuSolver(board, row, col + 1);
				if (res)
					return true;

				board[row][col] = 0;
			}

		}

		return false;

	}

	public static boolean isItSafeSS(int[][] board, int row, int col, int num) {

		return isItSafeRow(board, row, num) && isItSafeCol(board, col, num) && isItSafeCell(board, row, col, num);
	}

	public static boolean isItSafeRow(int[][] board, int row, int num) {

		for (int col = 0; col < board[0].length; col++) {
			if (board[row][col] == num) {
				return false;
			}
		}

		return true;

	}

	public static boolean isItSafeCol(int[][] board, int col, int num) {

		for (int row = 0; row < board.length; row++) {
			if (board[row][col] == num) {
				return false;
			}
		}

		return true;

	}

	public static boolean isItSafeCell(int[][] board, int row, int col, int num) {

		int rsp = row - row % 3;
		int csp = col - col % 3;

		for (int r = rsp; r < rsp + 3; r++) {
			for (int c = csp; c < csp + 3; c++) {

				if (board[r][c] == num) {
					return false;
				}
			}
		}

		return true;

	}

}
