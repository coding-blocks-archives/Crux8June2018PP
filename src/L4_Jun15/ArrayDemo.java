package L4_Jun15;

public class ArrayDemo {

	public static void main(String[] args) {

		int[] arr = new int[5];

		System.out.println(arr);
		System.out.println(arr.length);

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		// System.out.println(arr[5]);

		// set
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);

		for (int i = 0; i <= arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
//			arr[i] = 100;
		}

		System.out.println();

		// enhanced for loop
		// read only, forward only
		for (int abc : arr) {
			System.out.println(abc);
//			abc = 100;
		}

		int i = 0, j = 2;

		System.out.println(arr[i] + ", " + arr[j]);
		Swap(arr[i], arr[j]);
		System.out.println(arr[i] + ", " + arr[j]);

		System.out.println(arr[i] + ", " + arr[j]);
		Swap(arr, i, j);
		System.out.println(arr[i] + ", " + arr[j]);

		int[] other = { 100, 200, 300 };
		System.out.println(arr[0] + ", " + other[0]);
		Swap(arr, other);
		System.out.println(arr[0] + ", " + other[0]);

	}

	public static void Swap(int[] arr, int[] other) {
		
		System.out.println("hii" + other[3]);
		int[] temp = arr;
		arr = other;
		other = temp;
		
	}

	public static void Swap(int[] arr, int i, int j) {
		System.out.println(arr[i] + ", " + arr[j]);

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

		System.out.println(arr[i] + ", " + arr[j]);
	}

	public static void Swap(int one, int two) {
		int temp = one;
		one = two;
		two = temp;
	}

}
