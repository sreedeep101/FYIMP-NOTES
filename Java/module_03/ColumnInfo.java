import java.sql.*;

public class ColumnInfo{
	public static void main(String args[]){
		String url = "jdbc:mysql://localhost:3306/college";
		String username = "Root";
		String password = "Root@2026";

		String tableName = args.length > 0 ? args[0] : "student";

		if(!tableName.matches("[A-Za-z0-9_]+")) {
			System.out.println("Invalid table Name.");
			return;
		}


		try (
			Connection con = DriverManager.getConnection(url, username , password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM `" + tableName + "` LIMIT 0")){

			ResultSetMetaData md = rs.getMetaData();

			int count = md.getColumnCount();

			System.out.println("Table Name : " + tableName);
			System.out.println("Total Columns : " + count);
			
			System.out.println("==== Column Information ====");
			for (int i = 1; i<=count; i++){
				System.out.println("\nColumn" + i);
				System.out.println("Column Name: " + md.getColumnName(i));
				System.out.println("Data Types: " + md.getColumnTypeName(i));
				System.out.println("Column Size: " + md.getColumnDisplaySize(i));
				System.out.println("Precision: " + md.getPrecision(i));
				System.out.println("Scale: " + (md.isNullable(i) != ResultSetMetaData.columnNoNulls));

				System.out.println("Auto Increment: " + md.isAutoIncrement(i));
				System.out.println("Signed: " + md.isSigned(i));

                		System.out.println("Read Only: " + md.isReadOnly(i));
           		 }

       		 } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
