package mambo5.Entity;

import mambo5.Controller.DBController;

public class OrderDetail {
	private int detailID;
	private int menuItemID;
	private int orderID;
	private double actualPrice;
	private String instructions;
	DBController dbc;
	
	public OrderDetail(int detailID, int menuItemID, int orderID, double actualPrice, String instructions) 
	{
		this.detailID = detailID;
		this.menuItemID = menuItemID;
		this.orderID = orderID;
		this.actualPrice = actualPrice;
		this.instructions = instructions;
	}
	
	public int createOrderDetail() 
	{
		dbc = new DBController();
		int result = 0;
		String sql = "INSERT INTO OrderDetail (menuItemID, actualPrice, instructions) "
					+ "VALUES ( '" + menuItemID + "' , '" + actualPrice + "' , '" + instructions +"');";
		
		result = dbc.executeNonQuery(sql);
		return result;
	}
}
