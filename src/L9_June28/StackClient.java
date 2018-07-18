package L9_June28;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 28, 2018
 */

public class StackClient {

	public static void main(String[] args) throws Exception {

		Stack stack = new DynamicStack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);

		stack.display();

		displayReverse(stack);
		// actualReverse(stack, new DynamicStack());
		// stack.display();
		int[] arr = { 10, 23, 4, 1, 7, 8, 90 };

		nextGreaterElement(arr);
		int[] ans = stockSpan(arr);

		int[] prices = { 90, 40, 50, 30, 80, 100 };

		for (int val : prices) {
			System.out.print(val + " ");
		}

	}

	public static void displayReverse(Stack s) throws Exception {

		if (s.isEmpty()) {
			return;
		}

		int temp = s.pop();

		displayReverse(s);
		System.out.println(temp);
		s.push(temp);

	}

	public static void actualReverse(Stack s, Stack helper) throws Exception {

		if (s.isEmpty()) {

			// if (helper.isEmpty()) {
			// return;
			// }
			//
			// int temp1 = helper.pop();
			// actualReverse(s, helper);
			// s.push(temp1);

			actualReverseH(s, helper);
			return;

		}

		int temp = s.pop();
		helper.push(temp);

		actualReverse(s, helper);

	}

	public static void actualReverseH(Stack s, Stack helper) throws Exception {

		if (helper.isEmpty()) {
			return;
		}

		int temp1 = helper.pop();
		actualReverseH(s, helper);
		s.push(temp1);
	}

	public static void nextGreaterElement(int[] arr) throws Exception {

		Stack s = new DynamicStack();

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && arr[i] > s.peek()) {
				System.out.println(s.pop() + " -> " + arr[i]);
			}

			s.push(arr[i]);

		}

		while (!s.isEmpty()) {
			System.out.println(s.pop() + " -> -1");
		}

	}

	public static int[] stockSpan(int[] prices) throws Exception {

		Stack s = new DynamicStack();

		int[] span = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {

			while (!s.isEmpty() && prices[i] > prices[s.peek()]) {
				s.pop();
			}

			if (s.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - s.peek();
			}

			s.push(i);
		}

		return span;

	}

}
