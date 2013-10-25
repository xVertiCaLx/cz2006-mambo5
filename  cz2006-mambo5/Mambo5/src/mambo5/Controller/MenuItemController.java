package mambo5.Controller;

import mambo5.Entity.MenuItem;
import mambo5.Entity.OrderDetail;

public class MenuItemController {

	private MenuItem Mi;
	
	public MenuItemController() {}
	
	public int validateCreateMenuItem(int menuID, String itemName, String itemPrice, String itemDiscount) {
		int validate = 0;
		
		Mi = new MenuItem();
		validate = Mi.createMenuItem(menuID,itemName,itemPrice,itemDiscount);
		
		return validate;
	}

	public String retrieveMenuItem(int menuID)
	{
		String validate = "";

		Mi = new MenuItem();
		validate = Mi.retrieveMenu(menuID);
		
		return validate;
	}
}
