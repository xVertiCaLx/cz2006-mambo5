package mambo5.Controller;

import java.sql.*; // Use classes in java.sql package


//JDK 7 and above
public class DBController { // Save as "JdbcSelectTest.java"
	static Statement stmt;

	public static void getCon() throws SQLException, ClassNotFoundException {
		//Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://mysql1100.shared-servers.com:1091/MamboJumbo",
				"mambo5", "anything");
		System.out.println("Connection established");
		stmt = conn.createStatement();
	}

	public static void main(String[] args) {

		try

		// Step 1: Allocate a database "Connection" object
		// Connection conn = DriverManager.getConnection(
		// "jdbc:mysql://mysql1100.shared-servers.com:1091/MamboJumbo",
		// "mambo5", "anything"); // MySQL
		// Connection conn = DriverManager.getConnection(
		// "jdbc:odbc:ebookshopODBC"); // Access

		// getCon();

		// Step 2: Allocate a "Statement" object in the Connection
		// Statement stmt = conn.createStatement();
		{
			getCon();
			String syntax = "CREATE TABLE books (id int, title varchar(255), price double, qty int, primary key (id));";
			System.out.println("CREATE TABLE");
			stmt.executeQuery(syntax);

			System.out.println("TABLE CREATED");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
	}
}