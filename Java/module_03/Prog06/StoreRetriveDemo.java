import java.sql.*;
import java.nio.file.*;

public class StoreRetriveDemo {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "Root";
        String password = "Root@2026";

        Path imagePath = Paths.get("cat.jpeg");
        Path documentPath = Paths.get("description.txt");

        String sql = "INSERT INTO documents (id, image_data, document_text) "
                + "VALUES (?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE "
                + "image_data = VALUES(image_data), "
                + "document_text = VALUES(document_text)";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, 1);
            pstmt.setBytes(2, Files.readAllBytes(imagePath));
            pstmt.setString(3, Files.readString(documentPath));

            pstmt.executeUpdate();

            System.out.println("Image and document stored successfully!");

            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT image_data, document_text "
                    + "FROM documents WHERE id = 1");

            if (rs.next()) {
                Files.write(
                        Paths.get("retrieved_image.jpeg"),
                        rs.getBytes("image_data"));

                Files.writeString(
                        Paths.get("retrieved_document.txt"),
                        rs.getString("document_text"));

                System.out.println(
                        "Image and document retrieved successfully!");
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}