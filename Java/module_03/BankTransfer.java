import java.sql.*;
import java.util.Scanner;

public class BankTransfer{
	public static void main(String args[]){
		String url = "jdbc:mysql://localhost:3306/bankdb";
		String username = "Root";
		String password = "Root@2026";

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sender account number : ");
		int sender = sc.nextInt();

		System.out.println("Enter receiver account number: ");
		int reciever = sc.nextInt();

		System.out.print("Enter amount to transfer: ");
		Double amount = sc.nextDouble();

		Connection con = null;

		
		try {
			con = DriverManager.getConnection(url,username,password);
			con.setAutoCommit(false);

			PreparedStatement ps1 = con.prepareStatement("update bank_accounts set balance = balance - ? where account_no = ? and balance >= ?");
			ps1.setDouble(1,amount);
			ps1.setInt(2, sender);
			ps1.setDouble(3, amount);

			int a = ps1.executeUpdate();

			if(a == 0) {
				throw new SQLException("Invalid sender or insufficient balance");
			}

			PreparedStatement ps2 = con.prepareStatement("update bank_accounts SET balance = balance + ? where account_no = ?");

			ps2.setDouble(1,amount);
			ps2.setInt(2, reciever);

			int b = ps2.executeUpdate();

			if(b==0) {
				throw new SQLException("Receiver account not found");
			}

			con.commit();

			System.out.println("Money transferred successfully!");
			con.close();

		}
		catch (Exception e){

			System.out.println("ERROR : " + e.getMessage());

			try{
				if(con != null){
					con.rollback();
					System.out.println("Transaction Rolled back.");
				}
			} catch (SQLException ex){
				System.out.println("Rollback failed.");
			}
		}
	}
}


