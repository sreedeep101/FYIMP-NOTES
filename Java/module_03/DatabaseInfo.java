import java.sql.*;

public class DatabaseInfo {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/college";
		String username = "Root";
		String password = "Root@2026";
		
		try {
			Connection con = DriverManager.getConnection(url, username , password);
			
			DatabaseMetaData md = con.getMetaData();
			
			System.out.println("---- DATABASE INFORMATION ----");
			System.out.println("Database Name : " + con.getCatalog());
			System.out.println("Database Product : " + md.getDatabaseProductName());
			System.out.println("Database Version : " + md.getDatabaseProductVersion());
			
			System.out.println("Driver Name: " + md.getDriverName());
			System.out.println("Driver Version: " + md.getDriverVersion());
			
			System.out.println("\n---- SUPPORTED FEATURES ----");
			System.out.println("Transaction Supported : " + md.supportsTransactions());
			System.out.println("Batch Updates Supported : " + md.supportsBatchUpdates());
			System.out.println("Stored Procedures Supported: "+ md.supportsStoredProcedures());

            		System.out.println("Savepoints Supported: "+ md.supportsSavepoints());
            		
            		
            		System.out.println("\n----AVAILABLE TABLES----");
            		
            		ResultSet rs = md.getTables(con.getCatalog(), null, "%" , new String[]{"TABLE"} );
            		
            		boolean found = false;
            		
            		while(rs.next()) {
            			System.out.println(rs.getString("TABLE_NAME"));
            			found = true;
            		}
            		
            		if (!found) {
            			System.out.println("No tables Found.");
            		}
            		
            		rs.close();
            		con.close();
			
		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		}
	}
}
