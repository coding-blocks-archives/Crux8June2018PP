package L9_June28.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date Jun 28, 2018
 */

public class PersonClient {

	public static void main(String[] args) throws Exception {

		Person p = new Person();
		// System.out.println(p.name);
		// System.out.println(p.age);
		// p.name = "abc";
		// p.age = -10;
		// System.out.println(p.name);
		// System.out.println(p.age);
		//
		Person p1 = p;
		p1.name = "Rahul";
		p1.age = 20;

		// System.out.println(p.name);
		// System.out.println(p.age);
		//
		// p1.introduceYourself();
		// p1.sayHi("Aman");

		Person p3 = new Person("Rohit", 10);

		System.out.println(p3);
		
		
		System.out.println("hello");

	}

}
