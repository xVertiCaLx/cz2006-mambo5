package mambo5.Entity;

public class MenuItem {
	private int menuItemID;
	private int menuID;
	private String menuItemName;
	private double menuItemPrice;
	private double discount;
	
	public MenuItem (int menuItemID, int menuID, String menuItemName, double menuItemPrice, double discount) {
		this.menuItemID = menuItemID;
		this.menuID = menuID;
		this.menuItemName = menuItemName;
		this.menuItemPrice = menuItemPrice;
		this.discount = discount;
	}
	
}
