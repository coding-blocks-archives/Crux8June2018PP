package L5_June18;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

		list.add(10);
		list.add(20);
		list.add(30);

		System.out.println(list);

		list.add(2, 40);
		System.out.println(list);

		System.out.println(list.get(3)); // arr[3]
		System.out.println(list.size());

		System.out.println(list.get(list.size() - 1));
		System.out.println(list.remove(3));
		System.out.println(list);

		list.set(2, 300); // arr[2] = 300
		System.out.println(list);

		while (true) {
			list.add(100);
		}

	}

}
