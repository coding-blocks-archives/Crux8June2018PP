package L16_July19.Adapters;

import L9_June28.DynamicQueue;
import L9_June28.Queue;

/**
 * @author Garima Chhikara
 * @date Jul 19, 2018
 */

public class StackUQueuePushE {

	private DynamicQueue primaryQueue = new DynamicQueue();

	public void push(int item) throws Exception {

		try {
			primaryQueue.enqueue(item);
		} catch (Exception e) {
			throw new Exception("Stack is Full.");
		}

	}

	public int pop() throws Exception {

		DynamicQueue helper = new DynamicQueue();

		try {

			while (this.primaryQueue.size() != 1) {
				int temp = this.primaryQueue.dequeue();
				helper.enqueue(temp);
			}

			int rv = this.primaryQueue.dequeue();

			this.primaryQueue = helper;
			return rv;

		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public int top() throws Exception {

		DynamicQueue helper = new DynamicQueue();

		try {

			while (this.primaryQueue.size() != 1) {
				int temp = this.primaryQueue.dequeue();
				helper.enqueue(temp);
			}

			int rv = this.primaryQueue.dequeue();

			helper.enqueue(rv);
			this.primaryQueue = helper;
			return rv;

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
		System.out.println("---------");
		display(0);
		System.out.println("---------");
	}

	private void display(int count) throws Exception {

		if (count == primaryQueue.size()) {
			return;
		}

		int temp = primaryQueue.dequeue();
		primaryQueue.enqueue(temp);

		display(count + 1);

		System.out.println(temp);
	}

}
