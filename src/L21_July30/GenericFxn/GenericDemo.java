package L21_July30.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Jul-2018
 */

public class GenericDemo {

	public static void main(String[] args) {

		Integer[] arr = { 10, 20, 30, 40, 50 };

		display(arr);

		String[] arrs = { "hello", "hi", "bye", "cb" };

		// display(arrs);

		Car[] cars = new Car[5];
		//
		// for (Car val : cars) {
		// System.out.println(val);
		// }

		cars[0] = new Car(1000, 20, "Black");
		cars[1] = new Car(50, 200, "Red");
		cars[2] = new Car(300, 10, "Yellow");
		cars[3] = new Car(600, 250, "White");
		cars[4] = new Car(700, 300, "Grey");

		// display(cars);

		// bubbleSort(cars);

		bubbleSort(cars, new CarPriceComparator());

		display(cars);

		bubbleSort(cars, new CarSpeedComparator());
		display(cars);
	}

	public static void display(Integer[] arr) {

		System.out.println("hi");
		for (Integer val : arr) {
			System.out.println(val);
		}

	}

	public static void display(String[] arr) {

		for (String val : arr) {
			System.out.println(val);
		}

	}

	public static <T> void display(T[] arr) {

		System.out.println("-----------");
		for (T val : arr) {
			System.out.println(val);
		}
		System.out.println("-----------");

	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		for (int counter = 0; counter < arr.length - 1; counter++) {

			for (int j = 0; j < arr.length - 1 - counter; j++) {

				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}

	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {

		for (int counter = 0; counter < arr.length - 1; counter++) {

			for (int j = 0; j < arr.length - 1 - counter; j++) {

				if (comparator.compare(arr[j], arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}

	}

}
