package L20_July29;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Jul-2018
 */

public class BSTClient {

	public static void main(String[] args) {

		int[] in = { 5, 10, 15, 20, 25, 30, 35 };

		BST bst = new BST(in);

		bst.display();

		System.out.println(bst.ht());
		System.out.println(bst.max());
		System.out.println(bst.find(10));
		System.out.println(bst.size());

		// bst.printInRange(12, 40);
		bst.printDec();

		// bst.replaceWithSumOfLarger();
		// bst.display();

		bst.add(32);
		bst.display();

		bst.remove(10);
		
		bst.display();

	}

}
