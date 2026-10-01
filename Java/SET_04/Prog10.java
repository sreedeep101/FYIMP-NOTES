import java.util.Scanner;

class ArrayExceptionDemo {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int arr[] = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter array index: ");
            int index = sc.nextInt();

            System.out.println("Value: " + arr[index]);

            System.out.println("Result: " + (100 / index));
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: Array index is out of bounds.");
        }

        catch (ArithmeticException e) {
            System.out.println("Exception: Cannot divide by zero.");
        }

        finally {
            System.out.println("Exception handling completed.");
        }
    }
}
