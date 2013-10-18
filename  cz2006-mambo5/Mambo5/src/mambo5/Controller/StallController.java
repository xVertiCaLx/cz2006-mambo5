package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.DataStoreFactory;
import mambo5.Database.DataStoreInterface;
import mambo5.Database.SystemConfiguration;
import mambo5.Entity.Stall;

public class StallController {
	
	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	
	public ArrayList<Stall> processRetrieveStallList() {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return dataStore.retrieveStallList();		
	}
}
