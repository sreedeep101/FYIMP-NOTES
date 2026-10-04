interface Printable {
	void print();
}

class Student implements Printable {
	public void print() {
		System.out.println("Student Details : ");
		System.out.println("Name    : Raju ");
		System.out.println("Age     : 14 ");
		System.out.println("Roll No : 22 ");
	}
}

class Teacher implements Printable {
	public void print(){
		System.out.println("Teacher Details : ");
		System.out.println("Name  : Anitha ");
		System.out.println("Age   : 45 ");
		System.out.println("Subject : malayalam ");
	}
}

class InterfaceDemo{
	public static void main(String args[]){
		Student s = new Student();
		Teacher t = new Teacher();

		s.print();
		t.print();

	}
}
