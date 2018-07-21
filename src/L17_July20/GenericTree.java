package L17_July20;

import java.util.ArrayList;
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

}
