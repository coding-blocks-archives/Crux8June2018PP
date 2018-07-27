package L18_July23;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Jul-2018
 */

public class BTClient {

	public static void main(String[] args) {

		int[] pre = { 10, 20, 40, 70, 50, 60, 30, 80 };
		int[] in =  { 40, 70, 20, 60, 50, 10, 30, 80 };

		// 10 true 20 true 40 false false true 50 true 80 false false true 90 false
		// false true 30 true 60 false false true 70 false false
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();

		System.out.println(bt.size());
		System.out.println(bt.ht());
		System.out.println(bt.find(30));
		System.out.println(bt.max());

		System.out.println(bt.diameter());
		System.out.println(bt.diameter2());

		System.out.println(bt.isBalanced());

		bt.preorder();
		bt.preorderI();
		
		
	}

}
