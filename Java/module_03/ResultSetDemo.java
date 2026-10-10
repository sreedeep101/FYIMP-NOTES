import java.sql.*;

public class ResultSetDemo {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/college";
        String username = "Root";
        String password = "Root@2026";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
            );   

            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            
            System.out.println("Using next():");
            if(rs.next()){
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("mark"));

            }

            System.out.println("Using previous():");
            if (rs.next() && rs.previous()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("mark"));
                
            }

            System.out.println("Using first():");
            if(rs.first()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("mark"));

            }

            System.out.println("Using last():");
            if(rs.last()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("mark"));

            }

            System.out.println("\nUsing absolute(3):");
            if (rs.absolute(3)) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("mark"));

            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
