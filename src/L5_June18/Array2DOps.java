package L5_June18;

import java.util.Scanner;

public class Array2DOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		// int[][] arr = takeInput();
		display(arr);
		spiralDisplay(arr);
	}

	public static int[][] takeInput() {

		System.out.println("Rows ?");
		int rows = scn.nextInt();

		int[][] arr = new int[rows][];

		for (int row = 0; row < arr.length; row++) {

			System.out.println("Cols for " + row + " ?");
			int cols = scn.nextInt();

			arr[row] = new int[cols];

			// refill
			for (int col = 0; col < arr[row].length; col++) {

				System.out.println("[" + row + "-" + col + "] ?");
				arr[row][col] = scn.nextInt();
			}
		}

		return arr;

	}

	public static void display(int[][] arr) {

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}

			System.out.println();
		}
	}

	public static void verticalDisplay(int[][] arr) {

		for (int col = 0; col < arr[0].length; col++) {

			for (int row = 0; row < arr.length; row++) {

				System.out.print(arr[row][col] + " ");
			}
		}
	}

	public static void waveDisplay(int[][] arr) {

		for (int col = 0; col < arr[0].length; col++) {

			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					System.out.print(arr[row][col] + " ");
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.print(arr[row][col] + " ");
				}
			}
		}
	}

	public static void spiralDisplay(int[][] arr) {

		int minRow = 0;
		int maxRow = arr.length - 1;
		int minCol = 0;
		int maxCol = arr[0].length - 1;

		int counter = 0;
		int nel = arr.length * arr[0].length;

		while (counter < nel) {
			
			// first col
			for (int row = minRow; counter < nel && row <= maxRow; row++) {
				System.out.print(arr[row][minCol] + " ");
				counter++;
			}
			minCol++;

			// last row
			for (int col = minCol; counter < nel && col <= maxCol; col++) {
				System.out.print(arr[maxRow][col] + " ");
				counter++;
			}
			maxRow--;

			// last col
			for (int row = maxRow; counter < nel && row >= minRow; row--) {
				System.out.print(arr[row][maxCol] + " ");
				counter++;
			}
			maxCol--;

			// first row
			for (int col = maxCol; counter < nel && col >= minCol; col--) {
				System.out.print(arr[minRow][col] + " ");
				counter++;
			}
			minRow++;
		}
	}

}
