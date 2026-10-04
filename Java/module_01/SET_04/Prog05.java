interface Sports{
	void sportsInfo();
}

interface Academics {
	void academicsInfo();
}

class Student implements Sports, Academics {
	public void sportsInfo(){
		System.out.println("Sports information :");
		System.out.println("sports : weight lifting ");
		System.out.println("sports achivements : collage champion");
	}

	public void academicsInfo(){
		System.out.println("Academics information : ");
		System.out.println("course : Computer Science ");
		System.out.println("CGPA   : 8.4 ");
	}
}

class multipleInterfaceDemo{
	public static void main(String args[]){
		Student s = new Student();

		s.sportsInfo();
		s.academicsInfo();
	}
}
