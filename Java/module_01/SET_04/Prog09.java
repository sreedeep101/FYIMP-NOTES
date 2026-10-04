import java.util.Scanner;

class ThrowThrowsDemo{
	public static void checkAge(int age)throws Exception {
		if (age < 18){
			throw new Exception("Your age is less than 18!, Not Eligible");
		}
		else {
			System.out.println("You are Eligible!");
		}
	}


	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("enter your age : ");
		int age = sc.nextInt();

		try{
			checkAge(age);
		}
		catch (Exception e){
			System.out.println("Exception caught : " + e.getMessage());
		}
	}
}


