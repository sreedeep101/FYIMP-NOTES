import java.sql.*;
import java.util.Scanner;

public class StudentRegistration {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "Root";
        String password = "Root@123";

        Scanner sc = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connection established successfully to the MYSQL database.");
            Statement stmt = connection.createStatement();

            String createTableQuery = "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), age INT)";
            stmt.executeUpdate(createTableQuery);
            System.out.println("Table 'students' created successfully in the database.");

            System.out.println("==== Student Registration ====");
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Student Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            String insertQuery = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(insertQuery);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student registered successfully.");
            }
            

            System.out.println("\n==== Search Student ====");
            System.out.print("Enter Student ID to search: ");
            int searchId = sc.nextInt();
            String selectQuery = "SELECT * FROM students WHERE id = ?";
            PreparedStatement searchStmt = connection.prepareStatement(selectQuery);
            searchStmt.setInt(1, searchId);
            ResultSet resultSet = searchStmt.executeQuery();
            if (resultSet.next()) {
                String studentName = resultSet.getString("name");
                int studentAge = resultSet.getInt("age");
                System.out.println("Student Found: ID: " + searchId + ", Name: " + studentName + ", Age: " + studentAge);
            } else {
                System.out.println("Student with ID " + searchId + " not found.");
            }

            resultSet.close();
            searchStmt.close();
            pstmt.close();
            stmt.close();
            connection.close();
            sc.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the MYSQL database: " );
            e.printStackTrace();
        }
    } 
}
