package L17_July20;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jul-2018
 */

public class GTClient {

	public static void main(String[] args) {

		// 10 3 20 2 50 0 60 0 30 0 55 1 70 0
		// 10 3 20 3 50 0 60 3 100 0 110 2 170 0 180 0 120 0 70 2 130 0 140 0 30 0 40 2
		// 80 2 150 0 160 3 190 0 200 0 201 0 90 0
		GenericTree gt = new GenericTree();
		gt.display();

		// System.out.println(gt.max());
		// System.out.println(gt.find(70));
		// System.out.println(gt.size());
		// System.out.println(gt.height());

		// gt.mirror();
		//
		// gt.display();

		gt.preorder();
		gt.preOrderI();
		// gt.postorder();
		// gt.levelorder();
		//
		// gt.levelorderlw();
		//
		// gt.levelorderzz();
		//
		// gt.levelOrderR();
		//
		// gt.multiSolver(70);

	}

}
