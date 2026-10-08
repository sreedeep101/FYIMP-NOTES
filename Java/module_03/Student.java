import java.sql.*;

public class Student {
   public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "Root";
        String password = "Root@123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connection established successfully to the MYSQL database.");

            Statement stmt = connection.createStatement();
            //crerate table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name VARCHAR(50), age INT)";
            stmt.executeUpdate(createTableQuery);
            System.out.println("Table 'students' created successfully in the database.");

            // insert
            String insertQuery = "INSERT INTO students (id, name, age) VALUES (1, 'John Doe', 20)";
            stmt.executeUpdate(insertQuery);
            stmt.execute("INSERT INTO students (id, name, age) VALUES (2, 'Jane Smith', 22)");
            stmt.execute("INSERT INTO students (id, name, age) VALUES (3, 'Bob Johnson', 23)");

            System.out.println("Record inserted successfully into the students table.");

            // update
            String updateQuery = "UPDATE students SET age = 21 WHERE id = 1";
            stmt.executeUpdate(updateQuery);

            System.out.println("Record updated successfully in the students table.");

            // delete
            String deleteQuery = "DELETE FROM students WHERE id = 1";
            stmt.executeUpdate(deleteQuery);
            System.out.println("Record deleted successfully from the students table.");

            // select
            String selectQuery = "SELECT * FROM students";
            ResultSet resultSet = stmt.executeQuery(selectQuery);

            System.out.println("Records in the students table:");
            System.out.println("ID\tName\t\tAge");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println(id + "\t" + name + "\t" + age);
            }

            resultSet.close();
            stmt.close();
            connection.close();
        }
        catch (SQLException e) {
            System.out.println("Error connecting to the MYSQL database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}