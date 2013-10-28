package mambo5.Entity;

import java.util.ArrayList;

public class MenuItem {
	private int menuItemID;
	private int menuID;
	private String menuItemName;
	private double menuItemPrice;
	private double discount;
	
	public MenuItem() {}
	
	public MenuItem(String menuItemName, double menuItemPrice) {
		this.menuItemName = menuItemName;
		this.menuItemPrice = menuItemPrice;
	}
	
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
}
