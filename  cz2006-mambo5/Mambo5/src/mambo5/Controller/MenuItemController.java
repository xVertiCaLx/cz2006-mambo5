package mambo5.Controller;

import mambo5.Entity.Canteen;
import mambo5.Entity.MenuItem;
import mambo5.Entity.OrderDetail;

public class MenuItemController {

	private MenuItem menuItem;
	
	public MenuItemController() {}

	public String retrieveMenuItem(int menuID)
	{
		String validate = "";

		menuItem = new MenuItem();
		validate = menuItem.retrieveMenu(menuID);
		
		return validate;
	}
	
	public int validateMenuItemDetail(int menuID, String menuItemName, double menuItemPrice, double discount){
		int validate = 0;
		
		menuItem = new MenuItem();
		validate = menuItem.createMenuItem(menuID, menuItemName, menuItemPrice, discount);
		
		return validate;
	}
	
}
