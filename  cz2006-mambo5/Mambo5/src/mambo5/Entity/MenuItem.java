package mambo5.Entity;

import java.sql.ResultSet;

import mambo5.Controller.DBController;

public class MenuItem {
	private int menuItemID;
	private int menuID;
	private String menuItemName;
	private double menuItemPrice;
	private double discount;
	
	private DBController dbc;
	private ResultSet rs;
	String sql;
	
	public MenuItem() {}
	
	public MenuItem (int menuItemID, int menuID, String menuItemName, double menuItemPrice, double discount) {
		this.menuItemID = menuItemID;
		this.menuID = menuID;
		this.menuItemName = menuItemName;
		this.menuItemPrice = menuItemPrice;
		this.discount = discount;
	}
	
	public int getMenuItemID() {
		return menuItemID;
	}

	public int getMenuID() {
		return menuID;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public double getMenuItemPrice() {
		return menuItemPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public int createMenuItem(int menuID, String menuItemName, String menuItemPrice, String discounts) 
	{
		dbc = new DBController();
		int result = 0;
		sql = "INSERT INTO mambojumbo.menuitem (menuID, menuItemName, menuItemPrice, discounts)"
					+ "VALUES ( '"+ menuID +"', '"+ menuItemName +"', '" + menuItemPrice + "' , '" + discounts + "');";
		
		result = dbc.executeNonQuery(sql);
		
		return result;
	}
	
	public int retrieveMenu(int menuID)
	{
		dbc = new DBController();
		int result = 0;
		//not sure on the sql part
		sql = "Select menuItemName from mambojumbo.menuitem where menuID = 5";
		
		try {
			rs = dbc.execute(sql);
			rs.next();
			result = rs.getInt("orderID"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
