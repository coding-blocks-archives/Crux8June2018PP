package L16_July19.Adapters;

/**
 * @author Garima Chhikara
 * @date Jul 19, 2018
 */

public class SuQClient {

	public static void main(String[] args) throws Exception {

		StackUQueuePopE stack = new StackUQueuePopE();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.display();

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
//		System.out.println(stack.pop());
		stack.display();
	}

}
