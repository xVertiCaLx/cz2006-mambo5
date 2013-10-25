package mambo5.Controller;

import mambo5.Database.DataStoreFactory;
import mambo5.Database.DataStoreInterface;
import mambo5.Database.SystemConfiguration;
import mambo5.Entity.Menu;

public class MenuController {

	private DBController dbcon;
	private Menu m;
	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public MenuController() {
		// TODO Auto-generated constructor stub
	}
	
	public Menu retrieveMenu(int stallID) {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return dataStore.retrieveMenu(stallID);
	}

}
