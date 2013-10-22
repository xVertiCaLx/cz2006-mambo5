package mambo5.Entity;

import mambo5.Controller.DBController;

import java.sql.*;

public class Customer  {
	
	private int custID;
	private double cardBalance;
	private String fullName;
	private int accessID;
	private Customer cust;
	DBController dbc;
	
	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public double getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAccessID() {
		return accessID;
	}

	public void setAccessID(int accessID) {
		this.accessID = accessID;
	}
	
	public Customer() {}
	
	public Customer(int custID, double cardBalance, String fullName, int accessID){
		this.custID = custID;
		this.cardBalance = cardBalance;
		this.fullName = fullName;
		this.accessID = accessID;
	}
	
	public int createCustomer(double cardBalance, String fullName, int accessID) {
		dbc = new DBController();
		int result = 0;
		
		String sql = "INSERT INTO customer (fullName, cardBalance, accessID) "
					+ "VALUES ( '" + fullName + "' , '" + cardBalance + "' , " + accessID + ");";
		
		result = dbc.executeNonQuery(sql);
				
		return result;
	}
	
	public Customer retrieveCustomerDetail(int custID) {
		
		dbc = new DBController();
		cust = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Customer WHERE custID = " + custID + ";";
		System.out.println(sql);
		rs = dbc.executeQuery(sql);
		
		if(rs != null) {
	        try {
	        	if(rs.next()) {   // Move the cursor to the next row
	        		cust = new Customer(rs.getInt("custID"),rs.getDouble("cardBalance"),rs.getString("fullName"),rs.getInt("accessID"));
				    System.out.println(cust.custID + ", " + cust.cardBalance + ", " + cust.fullName);
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cust;
	}
	
	public int updateCustomerCardValue(int custID)
	{
		dbc = new DBController();
		int result = 0;
		
		String sql = "UPDATE customer SET cardBalance = '" + cardBalance + "' WHERE custID = " + custID + ";";
				
		result = dbc.executeNonQuery(sql);
				
		return result;
		}	
	
	public int refundCustomerCard(int custID)
	{	
		dbc = new DBController();
		int result = 0;
		
		String sql = "DELETE FROM customer WHERE custID = " + custID + ";";
				
		result = dbc.executeNonQuery(sql);
		return result;
	}
}
	
	

