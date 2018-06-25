package Doubts.June20;

import java.util.Arrays;
import java.util.Scanner;

public class Pair {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();

		while (test != 0) {
			int m = scn.nextInt();
			int[] arr = new int[m];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			Arrays.sort(arr);
			int n = scn.nextInt();

			Pair(arr, n);
			System.out.println();
			test--;

		}
	}

	private static void Pair(int[] arr, int n) {

		int min = Integer.MAX_VALUE;

		int[] res = new int[2];

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == n) {

					if (min > arr[j] - arr[i]) {
						min = arr[j] - arr[i];
						res[0] = arr[i];
						res[1] = arr[j];
					}
				}
			}
		}

		System.out.println("Deepak should buy roses whose prices are " + res[0] + " and " + res[1]);
	}

}
