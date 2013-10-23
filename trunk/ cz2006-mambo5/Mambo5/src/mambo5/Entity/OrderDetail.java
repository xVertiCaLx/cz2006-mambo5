package mambo5.Entity;

import mambo5.Controller.DBController;

public class OrderDetail {
	private int detailID;
	private int menuItemID;
	private int orderID;
	private double actualPrice;
	private String instructions;
	DBController dbc;
	
	public OrderDetail() {}
	
	public OrderDetail(int detailID, int menuItemID, int orderID, double actualPrice, String instructions) 
	{
		this.detailID = detailID;
		this.menuItemID = menuItemID;
		this.orderID = orderID;
		this.actualPrice = actualPrice;
		this.instructions = instructions;
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

	public String getInstructions() {
		return instructions;
	}

	public int createOrderDetail(int menuItemID, double actualPrice, String instructions) 
	{
		dbc = new DBController();
		int result = 0;
		String sql = "INSERT INTO OrderDetail (menuItemID, actualPrice, instructions)"
					+ "VALUES ( '" + menuItemID + "' , '" + actualPrice + "' , '" + instructions +"');";
		
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
