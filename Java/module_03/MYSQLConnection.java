import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQLConnection {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "Root";
        String password = "Root@123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connection established successfully to the MYSQL database.");

            connection.close();

        }
        catch (SQLException e) {
            System.out.println("Error connecting to the MYSQL database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}