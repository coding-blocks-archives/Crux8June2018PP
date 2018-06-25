package L4_Jun15;

import java.util.Scanner;

public class ArrayOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[] array = { 10, 20, 30, 40, 50 };
		// int[] array = { 3, 2, 0, 4, 1 };
		// int[] array = takeInput();
		// bubbleSort(array);
		// display(rotate(array, -2));
		// display(inverse(array));
		// display(array);

		int n = 100000;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		long start = System.currentTimeMillis();

		bubbleSort(arr);

		long end = System.currentTimeMillis();

		System.out.println(end - start);
		// display(arr);
	}

	public static int[] takeInput() {

		System.out.println("Enter the size ?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static void display(int[] arr) {

		for (int val : arr) {
			System.out.print(val + " ");
		}

		System.out.println(".");

	}

	public static int max(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	public static int linearSearch(int[] arr, int item) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == item) {
				return i;
			}
		}

		return -1;
	}

	public static int binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (item > arr[mid]) {
				lo = mid + 1;
			} else if (item < arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}

		}

		return -1;

	}

	// in place sorting
	public static void bubbleSort(int[] arr) {

		boolean flag = true;

		for (int counter = 0; counter < arr.length - 1; counter++) {

			// 1 2 3 4 5
			for (int j = 0; j < arr.length - 1 - counter; j++) {

				if (arr[j] > arr[j + 1]) {
					flag = false;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

			if (flag) {
				break;
			}
		}

	}

	public static int[] rotate(int[] arr, int r) {

		r = r % arr.length;
		if (r < 0) {
			r = r + arr.length;
		}

		int[] na = new int[arr.length];

		for (int i = 0; i < na.length; i++) {

			if (i < r) {
				na[i] = arr[i + na.length - r];
			} else {
				na[i] = arr[i - r];
			}
		}

		return na;

	}

	public static int[] inverse(int[] arr) {

		int[] na = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			na[arr[i]] = i;
		}

		return na;

	}

	public static void selectionSort(int[] arr) {

		for (int counter = 0; counter < arr.length - 1; counter++) {

			int min = counter;

			for (int j = counter + 1; j <= arr.length - 1; j++) {

				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			int temp = arr[min];
			arr[min] = arr[counter];
			arr[counter] = temp;

		}
	}

	public static void insertionSort(int[] arr) {

		for (int counter = 1; counter <= arr.length - 1; counter++) {

			int item = arr[counter];

			int j = counter - 1;

			while (j >= 0 && arr[j] > item) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = item;
		}

	}

}
