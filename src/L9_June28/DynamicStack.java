package L9_June28;

/**
 * @author Garima Chhikara
 * @date Jul 16, 2018
 */

public class DynamicStack extends Stack {

	@Override
	public void push(int item) throws Exception {

		// twice
		if (this.size() == this.data.length) {

			int[] oa = this.data;
			int[] na = new int[2 * oa.length];

			for (int i = 0; i < oa.length; i++) {
				na[i] = oa[i];
			}

			this.data = na;

		}

		super.push(item);

	}

}
