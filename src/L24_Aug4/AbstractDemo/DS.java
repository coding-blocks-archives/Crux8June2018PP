package L24_Aug4.AbstractDemo;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Aug-2018
 */

public abstract class DS {

	int size = 0;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public abstract void display();

	public abstract void display1();
}
