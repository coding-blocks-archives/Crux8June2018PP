package L21_July30.GenericClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import L21_July30.GenericFxn.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Jul-2018
 */

public class GenericDemo {

	public static void main(String[] args) {

		// Pair<String> pair = new Pair<>() ;
		//
		// Pair2<Integer, String> pair2 ;
		//
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		System.out.println(list.size());
		System.out.println(list.get(0).size());
		list.get(0).add(10);
		list.get(0).add(20);
		list.get(1).add(20);
		System.out.println(list);

		Pair2<Pair2<String, Integer>, Pair2<Double, Character>> pair3 = new Pair2<>();
		pair3.a = new Pair2<>();
		pair3.b = new Pair2<>();
		System.out.println(pair3.a.a);
		System.out.println(pair3.a.b);

		LinkedListGeneric<Car> ll = new LinkedListGeneric<>();
		ll.addLast(new Car(1000, 20, "Black"));
		ll.addLast(new Car(50, 200, "Red"));
		ll.addLast(new Car(300, 10, "Yellow"));
		ll.addLast(new Car(600, 250, "White"));
		ll.addFirst(new Car(700, 300, "Grey"));

		ll.display();

		Stack<Integer> s = new Stack<>();

		Queue<Integer> q = new LinkedList<>();

	}

}
