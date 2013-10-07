package mambo5.Controller;

import java.sql.*;


public class DBController {
	private Statement stmt;
	
	//Server: mysql1100.shared-servers.com
	//Port:   1091
	//User:	  mambo5
	//Password: anything
	//Schema: MamboJumbo
	
	private void getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://mysql1100.shared-servers.com:1091/MamboJumbo",
				"mambo5", "anything");
		println("Connection to MamboJumbo established.");
		stmt = conn.createStatement();
	}
	
	public void executeNonQuery(String sql){
		try {
			getConnection();
			println("Attempting to: " + sql);
			stmt.execute(sql);
			println(sql + "\nSuccessfully queried MamboJumbo.");
		} catch (Exception e) {
			println(sql + "\nFailed to query MamboJumb. Printing Stacktrace...");
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String sql){
		ResultSet rset = null;
		
		try {
			getConnection();
			println("Attempting to: " + sql);
			rset = stmt.executeQuery(sql);
			println(sql + "\nSuccessfully queried MamboJumbo.");
		} catch (Exception e) {
			println(sql + "\nFailed to query MamboJumb. Printing Stacktrace...");
			e.printStackTrace();
		}
		
		return rset;
	}
	
	private void println(String string) {
		System.out.println(string);
	}
		
}