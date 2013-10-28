package mambo5.Entity;

import mambo5.Controller.DBController;

public class OrderDetail {
	private int detailID;
	private int menuItemID;
	private int orderID, quantity;
	private double actualPrice;
	DBController dbc;
	
	public OrderDetail() {}
	
	public OrderDetail(int menuItemID, int orderID, double actualPrice, int quantity) 
	{
		this.detailID = -1;
		this.menuItemID = menuItemID;
		this.orderID = orderID;
		this.actualPrice = actualPrice;
		this.quantity = quantity;
	}
	
	public OrderDetail(int menuItemID, double actualPrice, int quantity) 
	{
		this.detailID = -1;
		this.menuItemID = menuItemID;
		this.orderID = -1;
		this.actualPrice = actualPrice;
		this.quantity = quantity;
	}
	
	public int getDetailID() {
		return detailID;
	}

	public int getMenuItemID() {
		return menuItemID;
	}

	public int getOrderID() {
		return orderID;
	}

	public double getActualPrice() {
		return actualPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
/*
	public int createOrderDetail(int orderID, int menuItemID, double actualPrice, int quantity) 
	{
		dbc = new DBController();
		
	}
	*/
}
