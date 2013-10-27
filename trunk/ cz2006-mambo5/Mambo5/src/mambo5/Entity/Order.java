package mambo5.Entity;

import java.sql.ResultSet;
import java.util.Date;

import mambo5.Controller.DBController;

public class Order {
	
	private int orderID;
	private int custID;
	private String orderStatus;
	private Date purchaseDate;
	private int stallID;
	DBController dbc;
	private ResultSet rs;
	
	public Order() {};
	
	public Order(int orderID, int custID, Date purchaseDate, String orderStatus, int stallID){
		this.orderID = orderID;
		this.custID = custID;
		this.purchaseDate = purchaseDate;
		this.orderStatus = orderStatus;
		this.stallID = stallID;
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
	
	public int getStallID() {
		return stallID;
	}
	
	//New Order
	public int createOrder(int custID, Date purchaseDate, String orderStatus, int stallID) 
	{
		dbc = new DBController();
		int result = 0;
		String sql = "INSERT INTO mambojumbo.orders (custID, purchaseDate, orderStatus, stallID) "
					+ "VALUES ( '" + custID + "' , '" + purchaseDate + "' , '" + orderStatus +"', '" + stallID +"');";
		
		result = dbc.executeNonQuery(sql);
		
		if(result==1)
		{
			sql = "Select orderID from mambojumbo.orders order by orderID desc limit 1;";
			
			try {
				rs = dbc.execute(sql);
				rs.next();
				result = rs.getInt("orderID"); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
			result = -1;
		
		return result;
	}
	
	//Refund Order
	public int refundOrder(int orderID)
	{
		dbc = new DBController();
		int result = 0;
		String sql = "UPDATE mambojumbo.orders SET orderStatus = '" + "Refunded" + "' WHERE orderID = '" + orderID + "';";
				
		result = dbc.executeNonQuery(sql);
		System.out.println(result);
		return result;
	}	
	
	public int confirmOrder(int orderID)
	{
		dbc = new DBController();
		int result = 0;
		String sql = "UPDATE mambojumbo.orders SET orderStatus = '" + "Completed" + "' WHERE orderID = '" + orderID + "';";
				
		result = dbc.executeNonQuery(sql);
		System.out.println(result);
		return result;
	}	
}
