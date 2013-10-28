package mambo5.Entity;

import mambo5.Controller.DBController;

import java.sql.*;
import java.util.ArrayList;

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
	
	public Customer retrieveCustomerDetail(int custID) {
		
		dbc = new DBController();
		cust = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Customer WHERE custID = " + custID + ";";
		System.out.println(sql);
		rs = dbc.execute(sql);
		
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

	public ArrayList<String> retrieveCustomerPurchaseDate(int custID) {
		dbc = new DBController();
		ArrayList<String> customerPurchaseDate = new ArrayList<String>();
		ResultSet rs = null;
		
		String sql = "SELECT purchaseDate FROM orders where custID =" + custID + " Order By purchaseDate DESC LIMIT 5;";
		
		rs = dbc.execute(sql);
		try {
			while(rs.next()) {
				String purchaseDate = rs.getTimestamp("purchaseDate").toString();
				customerPurchaseDate.add(purchaseDate);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return customerPurchaseDate;
	}
	
	public ArrayList<MenuItem> retrieveSpecificPurchaseDate(String purchaseDate, int custID) {
		dbc = new DBController();
		ArrayList<MenuItem> itemList = new ArrayList<MenuItem>();
		ResultSet rs = null;
		
		String sql = "SELECT customer.custID, orders.orderID, menuitem.menuItemName, menuitem.menuItemPrice" +
					" FROM customer" + 
					" INNER JOIN ((menuitem INNER JOIN orderdetails ON menuitem.menuItemID = orderdetails.menuitemID)" + 
					" INNER JOIN orders ON orderdetails.orderID = orders.orderID) ON customer.custID = orders.custID" +
					" WHERE orders.purchaseDate = '" +purchaseDate+ "' and customer.custID = "+custID+ ";";
		rs = dbc.execute(sql);
		try {
			while(rs.next()) {
				MenuItem mi = new MenuItem(rs.getString("menuItemName"), rs.getDouble("menuItemPrice"));
				itemList.add(mi);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.terminate();
		}
		return itemList;	
	}
}