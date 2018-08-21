package L18_July23;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Jul-2018
 */

public class BTClient {

	public static void main(String[] args) {

		// int[] pre = { 10, 20, 40, 70, 50, 60, 30, 80 };
		// int[] in = { 40, 70, 20, 60, 50, 10, 30, 80 };

		// 10 true 20 true 40 false false true 50 true 80 false false true 90 false
		// false true 30 true 60 false false true 70 false false

		int[] pre = { 1000, 50, 20, 60, 55, 65, 2000, 150, 120, 160, 170, 180, 190, 195, 250, 240, 260 };
		int[] in = { 20, 50, 55, 60, 65, 1000, 120, 150, 160, 170, 180, 190, 195, 2000, 240, 250, 260 };
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();

		// System.out.println(bt.size());
		// System.out.println(bt.ht());
		// System.out.println(bt.find(30));
		// System.out.println(bt.max());
		//
		// System.out.println(bt.diameter());
		// System.out.println(bt.diameter2());
		//
		// System.out.println(bt.isBalanced());
		//
		// bt.preorder();
		// bt.preorderI();

		// bt.isBST();

		// System.out.println(bt.path(160));
		bt.printTillK(50, 2);

	}

}
