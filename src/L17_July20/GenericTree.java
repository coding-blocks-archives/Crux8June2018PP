package L17_July20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jul-2018
 */

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		this.root = construct(null, -1);
	}

	// create parent ith child, return the root node of subtree
	private Node construct(Node parent, int ith) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data);
		}

		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();
		nn.data = item;

		System.out.println("Enter the no of children for " + nn.data);
		int noc = scn.nextInt();

		for (int i = 0; i < noc; i++) {

			Node child = construct(nn, i);
			nn.children.add(child);
		}

		return nn;

	}

	public void display() {
		System.out.println("--------------");
		display(this.root);
		System.out.println("--------------");
	}

	private void display(Node node) {

		// self work of printing
		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + ", ";
		}

		str += ".";
		System.out.println(str);

		// smaller prob
		for (Node child : node.children) {
			display(child);
		}

	}

	private void display1(Node node) {

		System.out.println("hii " + node.data);

		// smaller prob
		for (Node child : node.children) {
			System.out.println("going towards " + child.data);
			display1(child);
			System.out.println("coming back from " + child.data);
		}

		System.out.println("bye " + node.data);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		int count = 0;

		for (Node child : node.children) {
			count += size(child);
		}

		return count + 1;

	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		int tm = node.data;
		for (Node child : node.children) {
			int cm = max(child);

			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (item == node.data) {
			return true;
		}

		for (Node child : node.children) {
			boolean cf = find(child, item);

			if (cf)
				return true;

		}

		return false;
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = height(child);

			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;

	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);
		}

		int left = 0;
		int right = node.children.size() - 1;

		while (left < right) {

			Node ln = node.children.get(left);
			Node rn = node.children.get(right);

			node.children.set(left, rn);
			node.children.set(right, ln);

			left++;
			right--;
		}
	}

	public void preorder() {
		preorder(this.root);
		System.out.println();
	}

	private void preorder(Node node) {

		System.out.print(node.data + " ");

		for (Node child : node.children) {
			preorder(child);
		}
	}

	public void postorder() {
		postorder(this.root);
		System.out.println();
	}

	private void postorder(Node node) {

		for (Node child : node.children) {
			postorder(child);
		}

		System.out.print(node.data + " ");

	}

	public void levelorder() {

		LinkedList<Node> queue = new LinkedList<>();
		// put the root node in queue
		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			// remove the node
			Node rn = queue.removeFirst();

			// syso
			System.out.print(rn.data + " ");

			// put the children at back
			for (Node child : rn.children) {
				queue.addLast(child);
			}

		}
		System.out.println();

	}

	public void levelorderlw() {
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		// put the root node in queue
		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			// remove the node
			Node rn = queue.removeFirst();

			// syso
			System.out.print(rn.data + " ");

			// put the children at back
			for (Node child : rn.children) {
				helper.addLast(child);
			}

			if (queue.isEmpty()) {
				System.out.println();
				queue = helper;
				helper = new LinkedList<>();
			}
		}
		System.out.println();

	}

	public void levelorderzz() {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();

		int count = 0;

		// put the root node in queue
		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			// remove the node
			Node rn = queue.removeFirst();

			// syso
			System.out.print(rn.data + " ");

			// put the children at back
			if (count % 2 == 0) {
				for (Node child : rn.children) {
					stack.addFirst(child);
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}

			}

			if (queue.isEmpty()) {
				System.out.println();
				queue = stack;
				stack = new LinkedList<>();
				count++;
			}
		}
		System.out.println();

	}

	public void levelOrderR() {

		int s = this.height();
		for (int i = 0; i <= s; i++) {
			printAtLevel(i);
			System.out.println();
		}
	}

	public void printAtLevel(int level) {
		printAtLevel(this.root, level, 0);
	}

	private void printAtLevel(Node node, int level, int count) {

		if (level == count) {
			System.out.print(node.data + " ");
			return;
		}

		for (Node child : node.children) {
			printAtLevel(child, level, count + 1);
		}

	}

	private class HeapMover {
		int size;
		int max = Integer.MIN_VALUE;
		int ht;
		boolean find;

		Node pred;
		Node succ;

		Node jl;

	}

	public void multiSolver(int item) {

		HeapMover mover = new HeapMover();
		multiSolver(this.root, mover, 0, item);

		System.out.println("Max : " + mover.max);
		System.out.println("Find : " + mover.find);
		System.out.println("Ht : " + mover.ht);
		System.out.println("Size : " + mover.size);
		System.out.println("Pred : " + (mover.pred == null ? null : mover.pred.data));
		System.out.println("Succ : " + (mover.succ == null ? null : mover.succ.data));
		System.out.println("JL : " + (mover.jl == null ? null : mover.jl.data));
	}

	private void multiSolver(Node node, HeapMover mover, int count, int item) {

		mover.size++;

		// height
		if (count > mover.ht) {
			mover.ht = count;
		}

		// succ
		if (mover.find == true && mover.succ == null) {
			mover.succ = node;
		}

		// find
		if (node.data == item) {
			mover.find = true;
		}

		// pred
		if (mover.find == false) {
			mover.pred = node;
		}

		// max
		if (node.data > mover.max) {
			mover.max = node.data;
		}

		// jl
		if (node.data > item) {

			if (mover.jl == null || node.data < mover.jl.data)
				mover.jl = node;
		}

		for (Node child : node.children) {
			multiSolver(child, mover, count + 1, item);
		}

	}

	private class OrderPair {
		Node node;
		boolean selfDone;
		boolean childDone;
	}

	public void preOrderI() {
		preOrderI(this.root);
	}

	private void preOrderI(Node node) {

		LinkedList<OrderPair> stack = new LinkedList<>();

		OrderPair sp = new OrderPair();
		sp.node = this.root;

		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			OrderPair tp = stack.getFirst();

			if (tp.selfDone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfDone = true;
			} else if (tp.childDone == false) {

				for (int i = tp.node.children.size() - 1; i >= 0; i--) {
					OrderPair np = new OrderPair();
					np.node = tp.node.children.get(i);
					stack.addFirst(np);
				}

				tp.childDone = true;
			} else {
				stack.removeFirst();
			}

		}

	}

}
