package L20_July29;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Jul-2018
 */

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] in) {

		this.root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int ilo, int ihi) {

		if (ilo > ihi) {
			return null;
		}

		int mid = (ilo + ihi) / 2;

		Node nn = new Node();
		nn.data = in[mid];

		nn.left = construct(in, ilo, mid - 1);
		nn.right = construct(in, mid + 1, ihi);

		return nn;

	}

	public void display() {
		System.out.println("--------------------");
		display(this.root);
		System.out.println("--------------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		// if (node.right != null) {
		// return max(node.right);
		// } else {
		// return node.data;
		// }

		if (node.right == null) {
			return node.data;
		}

		return max(node.right);
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (item > node.data) {
			return find(node.right, item);
		} else if (item < node.data) {
			return find(node.left, item);
		} else {
			return true;
		}

	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	public void printInRange(int lo, int hi) {
		printInRange(this.root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {

		if (node == null) {
			return;
		}

		if (node.data < lo) {
			printInRange(node.right, lo, hi);
		} else if (node.data > hi) {
			printInRange(node.left, lo, hi);
		} else {
			printInRange(node.left, lo, hi);
			System.out.println(node.data);
			printInRange(node.right, lo, hi);
		}
	}

	public void printDec() {
		printDec(this.root);
	}

	private void printDec(Node node) {

		if (node == null) {
			return;
		}

		printDec(node.right);
		System.out.println(node.data);
		printDec(node.left);
	}

	private class HeapMover {
		int sum = 0;
	}

	public void replaceWithSumOfLarger() {
		HeapMover mover = new HeapMover();

		// replaceWithSumOfLarger(this.root, mover);
		replaceWithSumOfLarger(root, 0);
	}

	private void replaceWithSumOfLarger(Node node, HeapMover mover) {

		if (node == null) {
			return;
		}

		replaceWithSumOfLarger(node.right, mover);

		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;

		replaceWithSumOfLarger(node.left, mover);
	}

	private int replaceWithSumOfLarger(Node node, int sum) {

		if (node == null) {
			return sum;
		}

		int val = replaceWithSumOfLarger(node.right, sum);

		int temp = node.data;
		node.data = val;

		int res = replaceWithSumOfLarger(node.left, val + temp);

		return res;

	}

	public void add(int item) {
		add(this.root, item);
	}

	private void add(Node node, int item) {

		if (node.data >= item) {

			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			} else {
				add(node.left, item);
			}
		} else {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			} else {
				add(node.right, item);
			}
		}

	}

	public void remove(int item) {
		remove(this.root, null, item);
	}

	private void remove(Node node, Node parent, int item) {

		if (item < node.data) {
			remove(node.left, node, item);
		} else if (item > node.data) {
			remove(node.right, node, item);
		} else {

			if (node.left == null && node.right == null) {

				if (node.data < parent.data) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}

			else if (node.left == null && node.right != null) {

				if (node.data < parent.data) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			}

			else if (node.left != null && node.right == null) {

				if (node.data < parent.data) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			} else {

				int temp = max(node.left);
				remove(node.left, node, temp);
				node.data = temp;

			}

		}

	}

}
