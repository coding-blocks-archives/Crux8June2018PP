package L5_June18;

public class Array2DDemo {

	public static void main(String[] args) {

		int[][] arr = new int[3][4];

		System.out.println(arr);

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		arr[0][2] = 10;
		System.out.println(arr[0][2]);

		// rows
		System.out.println(arr.length);
		// cols
		System.out.println(arr[0].length);

		// jagged array
		int[][] jarr = new int[3][];
		System.out.println(jarr);

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		jarr[0] = new int[3];
		jarr[1] = new int[5];
		jarr[2] = new int[2];

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		// enhanced loop in 2d array
		for (int[] val : jarr) {
			for (int val1 : val) {
				System.out.print(val1 + " ");
			}
			System.out.println();
		}

		System.out.println(jarr[1].length);

	}

}
