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
		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());
		list.display();
		list.addFirst(100);
		list.addFirst(200);
		list.display();
		

	}

}
