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

		try		{
			getCon();
			String strSelect = "select title, price, qty from books";
	         System.out.println("The SQL query is: " + strSelect); // Echo For debugging
	         System.out.println();
	 
	         ResultSet rset = stmt.executeQuery(strSelect);
	 
	         // Step 4: Process the ResultSet by scrolling the cursor forward via next().
	         //  For each row, retrieve the contents of the cells with getXxx(columnName).
	         System.out.println("The records selected are:");
	         int rowCount = 0;
	         while(rset.next()) {   // Move the cursor to the next row
	            String title = rset.getString("title");
	            double price = rset.getDouble("price");
	            int    qty   = rset.getInt("qty");
	            System.out.println(title + ", " + price + ", " + qty);
	            ++rowCount;
	         }
	         System.out.println("Total number of records = " + rowCount);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
	}
}