package mambo5.Entity;

import java.sql.Timestamp;
import java.util.*;

import javax.print.attribute.DateTimeSyntax;

import mambo5.Controller.DBController;

public class Order {
	
	private int orderID;
	private int custID;
	private String orderStatus;
	private Date purchaseDate;
	DBController dbc;
	
	public Order(int orderID, int custID, Date purchaseDate, String orderStatus){
		this.orderID = orderID;
		this.custID = custID;
		this.purchaseDate = purchaseDate;
		this.orderStatus = orderStatus;
	}
	
	//New Order
	public int createOrder() 
	{
		dbc = new DBController();
		int result = 0;
		String sql = "INSERT INTO Order (custID, purchaseDate, orderStatus) "
					+ "VALUES ( '" + custID + "' , '" + purchaseDate +"' , '" + "Processing" +"');";
		
		result = dbc.executeNonQuery(sql);
		return result;
	}
	
	//Delete Order
	public int deleteOrder(int orderID)
	{
		dbc = new DBController();
		int result = 0;
		String sql = "UPDATE Order SET orderStatus = '" + "Deleted" + "' WHERE orderID = '" + orderID + "';";
				
		result = dbc.executeNonQuery(sql);
		return result;
	}
	
	//Refund Order
	public int refundOrder(int orderID)
	{
		dbc = new DBController();
		int result = 0;
		String sql = "UPDATE Order SET orderStatus = '" + "Refunded" + "' WHERE orderID = '" + orderID + "';";
				
		result = dbc.executeNonQuery(sql);
		return result;
	}

/*	private Timestamp GetDate() {
		long time = System.currentTimeMillis();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
		
		return timestamp;
	}*/
	
}
