package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.DataStoreFactory;
import mambo5.Database.DataStoreInterface;
import mambo5.Database.SystemConfiguration;
import mambo5.Entity.Canteen;
import mambo5.Entity.Menu;
import mambo5.Entity.MenuItem;
import mambo5.Entity.OrderDetail;
import mambo5.Entity.Stall;

public class MenuItemController {

	private Menu m;
	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public MenuItemController() {}
	
	public int validateMenuItemDetail(int menuID, String menuItemName, double menuItemPrice, double discount){
		int validate = 0;
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		validate = dataStore.createMenuItem(menuID, menuItemName, menuItemPrice, discount);
		
		return validate;
	}
	
	public ArrayList<MenuItem> retrieveMenuItemList(ArrayList<MenuItem> menuItemList) {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return dataStore.retrieveMenuItem(menuItemList);
	}
	
	public ArrayList<MenuItem> retrieveMenuItemList(ArrayList<MenuItem> menuItemList, int menuItemID) {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return dataStore.retrieveMenuItem(menuItemList, menuItemID);
	}
	
	
}
