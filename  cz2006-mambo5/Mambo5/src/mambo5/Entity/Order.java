package mambo5.Entity;

import java.util.Date;

public class Order {
	
	private int orderID;
	private int custID;
	private String orderStatus;
	private Date purchaseDate;
	private int stallID;
	
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
}
