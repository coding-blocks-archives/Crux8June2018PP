package L16_July19.Adapters;

import L9_June28.DynamicQueue;
import L9_June28.Queue;

/**
 * @author Garima Chhikara
 * @date Jul 19, 2018
 */

public class StackUQueuePopE {

	private DynamicQueue primaryQueue = new DynamicQueue();

	public void push(int item) throws Exception {

		DynamicQueue helper = new DynamicQueue();

		try {

			helper.enqueue(item);
			while (!primaryQueue.isEmpty()) {
				// for (int i = 0; i < primaryQueue.size(); i++) {
				int temp = primaryQueue.dequeue();
				helper.enqueue(temp);
			}

			primaryQueue = helper;

		} catch (Exception e) {
			throw new Exception("Stack is Full.");
		}

	}

	public int pop() throws Exception {

		try {
			return this.primaryQueue.dequeue();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public int top() throws Exception {

		try {
			return this.primaryQueue.getFront();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public int size() {
		return this.primaryQueue.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() throws Exception {
		this.primaryQueue.display();
	}

}
