public class StudentView {
	public void displayStudentDetails(Student student) {
		System.out.println("\n---- Student Details ----");
		System.out.println("ID         : " + student.getId());
        	System.out.println("Name       : " + student.getName());
        	System.out.println("Department : " + student.getDepartment());
        }
}
