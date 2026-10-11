import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Student ID : ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter Student Name: ");
        	String name = sc.nextLine();

       		System.out.print("Enter Department: ");
        	String department = sc.nextLine();
        	
        	Student model = new Student(id, name , department);
        	StudentView view = new StudentView();
        	
        	StudentController controller = new StudentController(model, view);
        	
        	controller.displayStudent();
        	
        	sc.close();
        }
}

