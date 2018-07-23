package L10_June29;

public class LinkedListClient {

	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);

		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(3));
		list.display();
		// System.out.println(list.removeFirst());
		// System.out.println(list.removeLast());
		list.display();
		list.addFirst(100);
		list.addFirst(200);
		list.addFirst(300);
		list.addFirst(400);
		list.addFirst(500);
		list.display();

		list.reverseDataIteratively();
		list.display();
		list.reversePointerIteratively();
		list.display();
		list.reversePointerRecursively();
		list.display();

		list.reverseDataRecursively();
		list.display();

		list.fold();
		list.display();

		// System.out.println(list.mid());
		//
		// System.out.println(list.kthFromLast(4));

		list.kReverse(3);
		list.display();

		list.mergeSort();
		list.display();

		list.createDummyList();
		list.cycleDetectRemove();
		list.display();

	}

}
