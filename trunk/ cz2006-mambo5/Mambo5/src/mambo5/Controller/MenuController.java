package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.DataStoreFactory;
import mambo5.Database.DataStoreInterface;
import mambo5.Database.SystemConfiguration;
import mambo5.Entity.Menu;
import mambo5.Entity.Stall;

public class MenuController {
	
	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public MenuController() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Menu> retrieveMenu(ArrayList<Stall> stallList) {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return dataStore.retrieveMenu(stallList);
	}
	
	public ArrayList<Menu> retrieveMenuList(ArrayList<Menu> menuList) {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return dataStore.retrieveMenuList(menuList);
	}
	
	public int validateInsertMenu(int stallID, String menuType) {
		int validate = 0;
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		validate = dataStore.createMenu(stallID, menuType);
		
		return validate;
	}

}
