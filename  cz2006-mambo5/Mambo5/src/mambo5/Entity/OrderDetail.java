package mambo5.Entity;

import mambo5.Controller.DBController;

public class OrderDetail {
	private int detailID;
	private int menuItemID;
	private int orderID;
	private double actualPrice;
	DBController dbc;
	
	public OrderDetail() {}
	
	public OrderDetail(int menuItemID, double actualPrice) 
	{
		this.detailID = -1;
		this.menuItemID = menuItemID;
		this.orderID = -1;
		this.actualPrice = actualPrice;
	}
	
	public OrderDetail(int detailID, int menuItemID, int orderID, double actualPrice) 
	{
		this.detailID = detailID;
		this.menuItemID = menuItemID;
		this.orderID = orderID;
		this.actualPrice = actualPrice;
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

	public int createOrderDetail(int orderID, int menuItemID, double actualPrice) 
	{
		dbc = new DBController();
		int result = 0;
		String sql = "INSERT INTO orderdetails (orderID, menuItemID, actualPrice)"
					+ "VALUES ( '"+ orderID +"', '" + menuItemID + "' , '" + actualPrice + "');";
		
		result = dbc.executeNonQuery(sql);
		return result;
	}
	
	public int deleteOrderDetail(int detailID)
	{	
		dbc = new DBController();
		int result = 0;
		
		String sql = "DELETE FROM orderDetails WHERE detailID = " + detailID + ";";
				
		result = dbc.executeNonQuery(sql);
		return result;
	}
	
	//Qn: How to consolidate all the price together?
	public int calculateTotalPrice(int orderID){
		dbc = new DBController();
		int result = 0;
		
		String sql = "SELECT actualPrice FROM OrderDetails WHERE orderID = " + orderID + ";";
		
		result = dbc.executeNonQuery(sql);
		return result;
	}
	
	
}
