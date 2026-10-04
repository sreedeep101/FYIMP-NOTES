import java.io.FileInputStream;
import java.io.IOException;

class ReadFileDemo {
	public static void main(String args[]){
		FileInputStream fis = null;	


		try {
			fis = new FileInputStream("./FileData/input.txt");
			System.out.println("File Opened\n");
			int data;
			
			System.out.println("file contents :");
			System.out.print("\"");
			while ((data = fis.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.print("\"");
		}
		catch (IOException e){
			System.out.println("Error in reading the file : " + e.getMessage());
		}
		finally {
			try {
				if(fis != null){
					fis.close();
					System.out.println("\nFile closed successfully.");
				}
			}
			catch (IOException e){
				System.out.println("Error in closing the file : " + e.getMessage());
			}
		}
			
	}
}
