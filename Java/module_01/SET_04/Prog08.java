import java.util.Scanner;

class ExceptionHandlingDemo {
	public static void main(String args []){
		Scanner sc = new Scanner(System.in);

		System.out.println("enter the first number :");
		int a = sc.nextInt();
		System.out.println("enter the second number:");
		int b = sc.nextInt();

		try {
			int c = a/b;
			System.out.println("Output : " + c);
		}
		catch (ArithmeticException e){
			System.out.println("Division by zero is not possible!");
		}

		System.out.println("Program ended!");
	}
}
