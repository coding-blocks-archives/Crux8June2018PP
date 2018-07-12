package L14_July12;

/**
 * @author Garima Chhikara
 * @date Jul 12, 2018
 */

public class RecursionSorting {

	public static void main(String[] args) {

		// int[] arr = { 10, 3, 5, 1, 8, 9, 200 };

		int[] arr = { 1,3 };
		// int[] merged = mergeSort(arr, 0, arr.length - 1);

		quickSort(arr, 0, arr.length - 1);
		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

		int[] sorted = new int[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				sorted[k] = one[i];
				k++;
				i++;
			} else {
				sorted[k] = two[j];
				k++;
				j++;
			}
		}

		if (i == one.length) {

			while (j < two.length) {
				sorted[k] = two[j];
				k++;
				j++;
			}
		}

		if (j == two.length) {

			while (i < one.length) {
				sorted[k] = one[i];
				k++;
				i++;
			}
		}

		return sorted;

	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];

			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);

		int[] merged = mergeTwoSortedArrays(fh, sh);

		return merged;
	}

	public static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		// partitioning
		int mid = (lo + hi) / 2;

		int pivot = arr[mid];
		int left = lo;
		int right = hi;

		while (left < right) {

			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}

		}

		quickSort(arr, lo, right);
		quickSort(arr, left, hi);

	}

}
