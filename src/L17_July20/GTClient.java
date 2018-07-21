package L17_July20;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jul-2018
 */

public class GTClient {

	public static void main(String[] args) {

		// 10 3 20 2 50 0 60 0 30 0 40 1 70 0
		GenericTree gt = new GenericTree();
		gt.display();

		// System.out.println(gt.max());
		// System.out.println(gt.find(70));
		// System.out.println(gt.size());
		// System.out.println(gt.height());

		gt.mirror();

		gt.display();

	}

}
