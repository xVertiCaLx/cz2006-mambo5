package mambo5.Controller;

import java.sql.*;


public class DBController {
	private Statement stmt;
	private Connection conn;
	private ResultSet rset;
	private String dbpassword;
	private String dbuser;
	private String database;
	//http://172.21.147.164/Mambo5/uploads/c/ce/MAMBO5.png
	//*********************ORIGINAL****************************//
	//Server: mysql1100.shared-servers.com
	//Port:   1091
	//User:	  mambo5
	//Password: anything
	//Schema: MamboJumbo
	

	
	//actual implementation
	public DBController(String database, String dbuser, String dbpassword) {
		this.database = database;
		this.dbuser = dbuser;
		this.dbpassword = dbpassword;
	}
	
	private void getConnection() throws SQLException, ClassNotFoundException {
		conn = DriverManager.getConnection(database, dbuser, dbpassword);
		System.out.println("Connection to MamboJumbo established.");
		stmt = conn.createStatement();
	}
	
	public int executeNonQuery(String sql){
		int count =0;
		try {
			System.out.println("DB Connection Connecting!");
			getConnection();
			System.out.println("Attempting to: " + sql);
			stmt.execute(sql);
			System.out.println("Successfully queried MamboJumbo.");
			count = 1;
			
		} catch (Exception e) {
			System.out.println("Failed to query MamboJumb. Printing Stacktrace...");
			e.printStackTrace();
		} finally {
			terminate();
		}
		return count;
	}
	
	public ResultSet execute(String sql){
		rset = null;
		try {
			getConnection();
			System.out.println("Attempting to: " + sql);
			rset = stmt.executeQuery(sql);
			System.out.println("Successfully queried MamboJumbo.");
		} catch (Exception e) {
			System.out.println("Failed to query MamboJumbo. Printing Stacktrace...");
			e.printStackTrace();
		}
		return rset;
	}
	
	public void terminate() {
		// close connection
		try {
			conn.close();
			System.out.println("Connection is closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}