public class StudentController {
	private Student model;
	private StudentView view;
	
	public StudentController(Student model, StudentView view) {
		this.model = model;
		this.view  = view;
	}
	
	public void updateStudentDetails(int id , String name , String department){
		model  = new Student(id, name , department);
	}
	
	public void displayStudent(){
		view.displayStudentDetails(model);
	}
}
