package Doubts.June20;

import java.util.Scanner;

public class Sorting {

	public static void main(String[] args) {


		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int[] result = Sorting(arr);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	private static int[] Sorting(int[] arr) {

		int low = 0;
		int high = arr.length - 1;
		int mid = 0;

		while (mid <= high) {

			int val = arr[mid];

			if (val == 0) {

				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				low++;
				mid++;

			} else if (val == 1) {
				mid++;
			} else {
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
			}
		}

		return arr;
	}

}
