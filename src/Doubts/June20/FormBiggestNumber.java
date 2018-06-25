package Doubts.June20;

import java.util.Scanner;

public class FormBiggestNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {
			int n = scn.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			// int[] arr = { 2336, 2335, 233, 23 };

			bubbleSort(arr);

			display(arr);
			tc--;
		}
	}

	public static void display(int[] arr) {

		for (int val : arr) {
			System.out.print(val + "");
		}

		System.out.println();
	}

	public static void bubbleSort(int[] arr) {

		int n = arr.length;
		for (int counter = 0; counter < n - 1; counter++) {

			for (int j = 0; j < n - 1 - counter; j++) {

				if (compare(arr[j], arr[j + 1]) > 0) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}

	}

	// fxn returns 1 if we want to swap the values
	public static int compare(int a, int b) {

		String num1 = a + "" + b;
		String num2 = b + "" + a;

		int num1int = Integer.valueOf(num1);
		int num2int = Integer.valueOf(num2);

		if (num2int > num1int) {
			return 1;
		} else {
			return -1;
		}

	}
}