package Doubts.June20;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int c = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Arrays.sort(arr);

		Aggressive(arr, c);

	}

	public static void Aggressive(int[] arr, int c) {

		int low = 0;
		int high = arr[arr.length - 1];
		int max = 1;
		int mid;
		while (low < high) {
			mid = (low + high) / 2;

			if (Possible(arr, mid, c)) {
				if (max < mid) {
					max = mid;
				}
				low = mid + 1;
			} else {
				high = mid;
			}

		}

		System.out.println(max);
	}

	private static boolean Possible(int[] arr, int mid, int c) {

		int val = arr[0];
		int cows = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - val >= mid) {
				cows++;
				val = arr[i];
				if (c == cows) {
					return true;
				}
			}
		}

		return false;
	}

}
