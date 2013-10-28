package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.*;
import mambo5.Entity.Canteen;
import mambo5.Entity.Menu;
import mambo5.Entity.Stall;

public class CanteenController {

	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public CanteenController() {}

	public int validateCanteenDetail(String canteenName, String canteenDesc, String canteenAddress, int maxStall){
		int validate = 0;
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		validate = dataStore.createCanteen(canteenName, canteenDesc, canteenAddress, maxStall);
			
		return validate;
		
	}
		
	public int validateCanteenDetail(int canteenID, String canteenName, String canteenDesc, String canteenAddress, int maxStall){
		int validate = 0;
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		validate = dataStore.updateCanteenDetail(canteenID, canteenName, canteenDesc, canteenAddress, maxStall);
			
		return validate;
	}
	
	public ArrayList<Canteen> processRetrieveCanteenList() {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return dataStore.retrieveCanteenList();		
	}
	
	public int processDeleteCanteen(int canteenID) {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return dataStore.deleteCanteen(canteenID);
	}
	
	public ArrayList<Menu> triggerRetrieveMenu(int canteenID) {
		MenuController mc = new MenuController();
		StallController sc = new StallController();
		
		ArrayList<Stall> stallList = new ArrayList<Stall>();
		stallList = sc.processRetrieveStallList(canteenID);
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		
		menuList = mc.retrieveMenu(stallList);	
		return menuList;
	}

}
