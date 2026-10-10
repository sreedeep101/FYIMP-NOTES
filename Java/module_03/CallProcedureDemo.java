import java.sql.*;

public class CallProcedureDemo {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/college";
        String username = "Root";
        String password = "Root@2026";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			
			CallableStatement cs = con.prepareCall("{call displayMessage()}");
			ResultSet rs = cs.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("message"));
			}
			
			rs.close();
			cs.close();
			con.close();
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
