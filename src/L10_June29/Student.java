package L10_June29;

public class Student {

	String name;
	int age;
	final int rollNo = 10;
	static int noOfStudents;

	public Student(String name, int age) {
		noOfStudents++;
		// this.rollNo = noOfStudents;
		this.name = name;
		this.age = age;
	}

	public void sayHi() {
		// this.rollNo = 90;
		System.out.println(this.name + " says hi");
	}

	// static cannot access this, static cannot access non static data members
	public static int getNoOfStudents() {
		return noOfStudents;

	}

}
