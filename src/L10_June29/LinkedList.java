package L10_June29;

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.head.data;

	}

	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.tail.data;

	}

	public int getAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;

	}

	private Node getNodeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;

	}

	public void addLast(int item) {

		// create
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0)
			this.tail.next = nn;

		// dm update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size += 1;
		} else {
			this.tail = nn;
			this.size += 1;
		}

	}

	public void addFirst(int item) {

		// create
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		nn.next = this.head;

		// dm update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}

	}

	public void addAt(int item, int idx) throws Exception {

		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		} else {

			// create
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// attach
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			nm1.next = nn;
			nn.next = np1;

			// dm
			this.size++;
		}

	}

	public int removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		Node temp = this.head;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}
		return temp.data;
	}

	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		Node temp = this.tail;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node sm2 = getNodeAt(this.size - 2);
			sm2.next = null;
			this.tail = sm2;
			this.size--;
		}
		return temp.data;
	}

	public int removeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();

		} else {

			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			this.size--;

			return n.data;

		}

	}

	public void display() {

		System.out.println("----------------------");
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println(".");
		System.out.println("----------------------");

	}

	public void reverseDataIteratively() throws Exception {

		int left = 0;
		int right = this.size - 1;

		while (left < right) {
			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;

		}

	}

	public void reversePointerIteratively() {

		Node prev = this.head;
		Node curr = this.head.next;

		while (curr != null) {

			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;

		}

		// swap head and tail
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;

	}

	public void reversePointerRecursively() {
		reversePointerRecursively(this.head, this.head.next);

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;
	}

	private void reversePointerRecursively(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		reversePointerRecursively(curr, curr.next);
		curr.next = prev;

	}

	public void reverseDataRecursivelyR() {
		reverseDataRecursivelyR(this.head, this.head, 0);
	}

	private Node reverseDataRecursivelyR(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		left = reverseDataRecursivelyR(left, right.next, count + 1);

		if (count >= this.size / 2) {
			int temp = left.data;
			left.data = right.data;
			right.data = temp;

		}

		return left.next;

	}

	public void reverseDataRecursively() {
		HeapMover mover = new HeapMover();
		mover.left = head;
		reverseDataRecursively(mover, this.head, 0);
	}

	private class HeapMover {
		Node left;
	}

	private void reverseDataRecursively(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		reverseDataRecursively(mover, right.next, count + 1);

		if (count >= this.size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;

		}

		mover.left = mover.left.next;

	}

	public void fold() {
		HeapMover mover = new HeapMover();
		mover.left = this.head;
		fold(mover, this.head, 0);
	}

	private void fold(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		fold(mover, right.next, count + 1);

		if (count > size / 2) {
			Node temp = mover.left.next;
			mover.left.next = right;
			right.next = temp;

			mover.left = temp;
		}
		if (count == size / 2) {
			this.tail = right;
			this.tail.next = null;
		}

	}

	public int mid() {

		Node slow = this.head;
		Node fast = this.head;

		while ( fast.next != null && fast.next.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public int kthFromLast(int k) {

	}

}








