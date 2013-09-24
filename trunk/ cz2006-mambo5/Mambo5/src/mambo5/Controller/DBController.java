package mambo5.Controller;

import java.sql.*;


public class DBController {
	private Statement stmt;
	private String sql;
	
	private void getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://mysql1100.shared-servers.com:1091/MamboJumbo",
				"mambo5", "anything");
		println("Connection to MamboJumbo established.");
		stmt = conn.createStatement();
	}

	public void createTable(String tableName, String columns, String primaryKey) {
		try {
			getConnection();
			
			sql = "CREATE " + tableName + "(" + columns + ", primary key (" + primaryKey + "));";
			println("Attempting to: " + sql);
			
			stmt.execute(sql);
			
			println(tableName + " created successfully.");
			
		} catch (Exception e) {
			println(tableName + " was not created. Attempting to print stack trace.");
			e.printStackTrace();
		}
	}
	
	public ResultSet selectTable(String sqlSyntax) {
		ResultSet rset = null;
		
		try {
			getConnection();
			
			sql = "SELECT " + sqlSyntax + ";";
			println("Attempting to: " + sql);
			
			rset = stmt.executeQuery(sql);
			
			println(sql + " executed successfully.");
			
		} catch (Exception e) {
			println("SELECT failed. Attempting to print stack trace.");
			e.printStackTrace();
		}
		return rset;
	}
	
	public void insertData(String tableName, String columns, String values) {
		try {
			getConnection();
			
			sql = "INSERT INTO " + tableName + "(" + columns + ") VALUES (" + values + ");";
			println("Attempting to: " + sql);
			
			stmt.execute(sql);
			
			println("Data successfully added into " + tableName);
			
		} catch (Exception e) {
			println(tableName + " failed to add data. Attempting to print stack trace.");
			e.printStackTrace();
		}
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