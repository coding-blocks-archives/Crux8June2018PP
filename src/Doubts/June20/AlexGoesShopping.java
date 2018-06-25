package Doubts.June20;

import java.util.Arrays;
import java.util.Scanner;

public class AlexGoesShopping {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = scn.nextInt();
		}
		Arrays.sort(arr);
		int queries = scn.nextInt();

		for (int i = 0; i < queries; i++) {
			int A = scn.nextInt();
			int k = scn.nextInt();
			AGS(A, k, arr);

		}

	}

	public static void AGS(int a, int k, int[] arr) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > a) {
				continue;
			} else if (arr[i] == a) {
				counter++;
			} else {
				int sum = 0;
				while (sum <= a) {
					sum = sum + arr[i];
					if (sum == a) {
						counter++;
						break;
					}
				}
			}
		}

		if (counter >= k) {
			System.out.println("Yes");

		} else {
			System.out.println("No");

		}

	}
}
