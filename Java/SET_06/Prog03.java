import java.io.*;
import java.util.Scanner;

class StudentData{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Roll Number : ");
		int rollNO = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Student Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Student mark: ");
		double marks = sc.nextDouble();

		try {
			FileOutputStream fos = new FileOutputStream("student.dat");
			DataOutputStream dos = new DataOutputStream(fos);

			System.out.println("Writing to the file...");

			dos.writeInt(rollNO);
			dos.writeUTF(name);
			dos.writeDouble(marks);

			fos.close();
			dos.close();
			System.out.println("Student details written succesfully.");
		}
		catch (IOException e){
			System.out.println("Error writing data: " + e.getMessage());
		}

		try {
			FileInputStream fis = new FileInputStream("student.dat");
			DataInputStream dis = new DataInputStream(fis);

			int rno = dis.readInt();
			String Sname = dis.readUTF();
			Double Smark = dis.readDouble();

			fis.close();
			dis.close();

			System.out.println("\nStudent Details");
			System.out.println("----------------");
			System.out.println("Roll Number : " + rno);
			System.out.println("Name        : " + Sname);
			System.out.println("Mark        : " + Smark);

		}
		catch (IOException e ) {
			System.out.println("Error in Reading data : "+ e.getMessage());
		}
	}
}
