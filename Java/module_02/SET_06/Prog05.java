import java.io.*;
import java.util.Scanner;

class EmployeeData{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		try{
			FileOutputStream fos = new FileOutputStream("./FileData/Employee.dat");
			DataOutputStream dos = new DataOutputStream(fos);

			System.out.print("Enter total number of employee : ");
			int n = sc.nextInt();
			sc.nextLine();

			dos.writeInt(n);

			for (int i = 1; i<=n ;i++){
				System.out.println("\nEnter details of Employee " + i);
				System.out.println("Enter Employee Id: ");
				int EmpId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Employee Name : ");
				String name = sc.nextLine();
				System.out.println("Enter Employee Salary : ");
				Double salary = sc.nextDouble();
				sc.nextLine();
				
				dos.writeInt(EmpId);
				dos.writeUTF(name);
				dos.writeDouble(salary);
			}

			fos.close();
			dos.close();
			
			System.out.println("\nEmployee details stored successfully!\n");
		}
		catch (IOException e){
			System.out.println("ERROR : " + e.getMessage());
		}

		try {
			FileInputStream fis = new FileInputStream("./FileData/Employee.dat");
			DataInputStream dis = new DataInputStream(fis);

			int n = dis.readInt();

			System.out.println("Employee details");
			System.out.println("----------------");
			
			for(int i=1;i<=n;i++){
				int id = dis.readInt();
				String name = dis.readUTF();
				Double salary = dis.readDouble();

				System.out.println("\nEmployee "+ i);
				System.out.println("ID     : " + id);
				System.out.println("Name   : " + name);
				System.out.println("Salary : " + salary);
				System.out.println("--------------------");

			}

			fis.close();
			dis.close();

		} catch (IOException e){
			System.out.println("ERROR : " + e.getMessage());
		}
	}
}
