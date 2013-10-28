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
