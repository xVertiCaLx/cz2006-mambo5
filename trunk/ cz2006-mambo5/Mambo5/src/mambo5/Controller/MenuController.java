package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.DataStoreFactory;
import mambo5.Database.DataStoreInterface;
import mambo5.Database.SystemConfiguration;
import mambo5.Entity.Menu;
import mambo5.Entity.Stall;

public class MenuController {

	private DBController dbcon;
	private Menu m;
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

}
