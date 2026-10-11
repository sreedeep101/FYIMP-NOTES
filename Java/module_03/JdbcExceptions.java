import java.sql.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class JdbcExceptions {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
           
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter student age: ");
            int age = sc.nextInt();

            
            if (id <= 0 || age <= 0 || name.trim().isEmpty()) {
                throw new IllegalArgumentException(
                    "ID and age must be positive, and name cannot be empty.");
            }

            // 
            String url = "jdbc:mysql://localhost:3306/college";
            String user = "Root";
            String password = "Root@2026";
	    

            Connection con = DriverManager.getConnection(url, user, password);

           
            String sql = "INSERT INTO student VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            ps.executeUpdate();

            System.out.println("Student record inserted successfully!");

            ps.close();
            con.close();

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Enter numbers for ID and age.");

        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: Duplicate student ID or constraint violation.");

        } catch (SQLSyntaxErrorException e) {
            System.out.println("Error: Invalid SQL query or database name.");

        } catch (SQLException e) {
            if (e.getSQLState() != null && e.getSQLState().startsWith("08")) {
                System.out.println("Error: Database connection failed.");
            } else {
                System.out.println("Database Error: " + e.getMessage());
            }

        } finally {
            sc.close();
        }
    }
}
