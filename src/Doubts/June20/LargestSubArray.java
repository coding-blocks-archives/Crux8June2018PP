package Doubts.June20;

import java.util.Scanner;

public class LargestSubArray {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int test = scn.nextInt();

		while (test > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			findSubArray(arr, arr.length);
			test--;

		}

	}

	public static void findSubArray(int[] arr, int length) {

		int sum = 0;
		int maxsize = -1;
		int startindex = 0;
		int endindex = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 0) {
				sum = -1;
			} else {
				sum = 1;
			}
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] == 0) {
					sum = sum - 1;
				} else {
					sum = sum + 1;
				}

				if (sum == 0 && maxsize < j - i + 1) {
					maxsize = j - i + 1;
					startindex = i;
				}
			}

		}
		endindex = startindex + maxsize - 1;
		if (maxsize == -1)
			System.out.println("None");
		else
			System.out.println(startindex + " " + endindex);

	}
}
