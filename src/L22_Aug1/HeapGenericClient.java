package L22_Aug1;

import java.util.ArrayList;

import L21_July30.GenericFxn.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Aug-2018
 */

public class HeapGenericClient {

	public static void main(String[] args) {

		HeapGeneric<Car> heap = new HeapGeneric<>();

		Car[] cars = new Car[5];
		cars[0] = new Car(1000, 20, "Black");
		cars[1] = new Car(50, 200, "Red");
		cars[2] = new Car(300, 10, "Yellow");
		cars[3] = new Car(600, 250, "White");
		cars[4] = new Car(700, 300, "Grey");

		heap.add(cars[0]);
		heap.add(cars[1]);
		heap.add(cars[2]);
		heap.add(cars[3]);
		heap.add(cars[4]);

		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(2);
		list1.add(3);
		list1.add(5);
		list1.add(10);
		list1.add(15);
		list1.add(1500);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(15);
		list2.add(100);
		list2.add(200);
		list2.add(300);
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(6);
		list3.add(8);
		list3.add(9);
		list3.add(10);

		lists.add(list1);
		lists.add(list2);
		lists.add(list3);

		System.out.println(mergeKSortedLists(lists));

		list1.add(200);
		list1.add(80);
		list1.add(0);
		list1.add(10);

		System.out.println(list1);
		System.out.println(kLargestElements(list1, 3));
	}

	private static class Pair implements Comparable<Pair> {

		int data;
		int listNo;
		int indexNo;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}

	}

	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> ans = new ArrayList<>();

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < lists.size(); i++) {
			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.indexNo = 0;
			np.listNo = i;

			heap.add(np);
		}

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();
			ans.add(rp.data);

			rp.indexNo++;

			if (rp.indexNo < lists.get(rp.listNo).size()) {
				rp.data = lists.get(rp.listNo).get(rp.indexNo);
				heap.add(rp);
			}

		}
		return ans;
	}

	public static ArrayList<Integer> kLargestElements(ArrayList<Integer> list, int k) {

		ArrayList<Integer> ans = new ArrayList<>();

		Heap heap = new Heap();

		for (int i = 0; i < k; i++) {
			heap.add(list.get(i));
		}

		for (int i = k; i < list.size(); i++) {

			int minElement = heap.get();

			if (list.get(i) > minElement) {
				heap.remove();
				heap.add(list.get(i));
			}

		}

		while (!heap.isEmpty()) {
			ans.add(heap.remove());
		}

		return ans;
	}

}
