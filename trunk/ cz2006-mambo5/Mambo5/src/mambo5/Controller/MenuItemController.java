package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.DataStoreFactory;
import mambo5.Database.DataStoreInterface;
import mambo5.Database.SystemConfiguration;
import mambo5.Entity.MenuItem;

public class MenuItemController {

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
	
	public int validateUpdateMenuItem(String menuItemName, double menuItemPrice, double discount, int menuItemID){
		int validate = 0;
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		validate = dataStore.updateMenuItem(menuItemName, menuItemPrice, discount, menuItemID);
		
		return validate;
	}
	
	public int validateDeleteMenuItem(int menuItemID){
		int validate = 0;
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		validate = dataStore.deleteMenuItem(menuItemID);
		
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
