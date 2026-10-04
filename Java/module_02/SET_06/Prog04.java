import java.io.*;

class FileCopyDemo{
	public static void main(String args[]){
		try {
			FileInputStream fis = new FileInputStream("./FileData/input.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);

			FileOutputStream fos = new FileOutputStream("./FileData/copy_input.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			int data;

			while((data = bis.read()) != -1){
				bos.write(data);
			}

			bis.close();
			bos.close();

			System.out.println("File copied successfully!");
		}
		catch (IOException e){
			System.out.println("Error message : " + e.getMessage());
		}
	}
}
