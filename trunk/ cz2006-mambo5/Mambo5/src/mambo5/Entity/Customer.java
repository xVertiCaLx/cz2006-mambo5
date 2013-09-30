package mambo5.Entity;

import mambo5.Controller.DBController;

import java.sql.*;

public class Customer {
	
	private int custID;
	private double cardBalance;
	private String fullName;
	private int accessID;
	private Customer cust;
	DBController dbc;
	
	public Customer() {}
	
	public Customer(int custID, double cardBalance, String fullName, int accessID){
		this.custID = custID;
		this.cardBalance = cardBalance;
		this.fullName = fullName;
		this.accessID = accessID;
	}
	
	public Customer retrieveCustomerDetail(int custID) {
		dbc = new DBController();
		cust = null;
		ResultSet rs = null;
		rs = dbc.executeQuery("Select * from Customer where custID = '" + custID + "';");
		if(rs != null) {
	        try {
	        	cust = new Customer();
	        	while(rs.next()) {   // Move the cursor to the next row
	        		this.custID = rs.getInt("custID");
				    this.cardBalance = rs.getDouble("cardBalance");
				    this.fullName= rs.getString("fullName");
				    this.accessID = rs.getInt("accessID");
				    System.out.println(custID + ", " + cardBalance + ", " + fullName);
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cust;
	}
}
