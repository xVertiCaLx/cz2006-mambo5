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
	
	public Order() {};
	
	public Order(int orderID, int custID, Date purchaseDate, String orderStatus){
		this.orderID = orderID;
		this.custID = custID;
		this.purchaseDate = purchaseDate;
		this.orderStatus = orderStatus;
	}
	
	public int getOrderID() {
		return orderID;
	}

	public int getCustID() {
		return custID;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	//New Order
	public int createOrder(int custID, Date purchaseDate, String orderStatus) 
	{
		dbc = new DBController();
		int result = 0;
		String sql = "INSERT INTO Order (custID, purchaseDate, orderStatus) "
					+ "VALUES ( '" + custID + "' , '" + purchaseDate +"' , '" + "Processing" +" ');";
		
		result = dbc.executeNonQuery(sql);
		return result;
	}
	
	//Delete Order - Doesnt delete, only update the orderStatus to Cancelled
	public int deleteOrder(int orderID)
	{
		dbc = new DBController();
		int result = 0;
		String sql = "UPDATE Order SET orderStatus = '" + "Cancelled" + "' WHERE orderID = '" + orderID + "';";
				
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
	
}
