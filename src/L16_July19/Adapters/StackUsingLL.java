package L16_July19.Adapters;

import L10_June29.LinkedList;
import L9_June28.DynamicQueue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Jul-2018
 */

public class StackUsingLL {

	private LinkedList list = new LinkedList();

	public void push(int item) throws Exception {

		try {
			list.addFirst(item);
		} catch (Exception e) {
			throw new Exception("Stack is Full.");
		}

	}

	public int pop() throws Exception {

		try {
			return this.list.removeFirst();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public int top() throws Exception {

		try {
			return this.list.getFirst();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public int size() {
		return this.list.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() throws Exception {
		this.list.display();
	}

}
