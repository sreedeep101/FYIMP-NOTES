import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

class WriteFileDemo{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String text = sc.nextLine();
		
		try {
			FileOutputStream fos = new FileOutputStream("./FileData/output.txt", true);
			
			byte data[] = text.getBytes();
			
			fos.write(data);
			
			fos.write('\n');

			fos.close();
			System.out.println("content written successfully");

		}
		catch (IOException e) {
			System.out.println("Error in writing the file: " + e.getMessage());
		}

	}
}
