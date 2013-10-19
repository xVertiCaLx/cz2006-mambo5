package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.DataStoreFactory;
import mambo5.Database.DataStoreInterface;
import mambo5.Database.SystemConfiguration;
import mambo5.Entity.Stall;

public class StallController {
	
	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	
	public ArrayList<Stall> processRetrieveStallList(int canteenID) {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return dataStore.retrieveStallList(canteenID);		
	}
	
	public int validateStallDetail(int canteenID, String stallUnit, String stallName, String stallDesc, String stallStatus){
		int validate = 0;
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		validate = dataStore.createStall(canteenID, stallUnit, stallName, stallDesc, stallStatus);
			
		return validate;
	}
}
