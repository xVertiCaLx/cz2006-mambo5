package mambo5.Controller;

import java.util.ArrayList;
import mambo5.Database.*;
import mambo5.Entity.Canteen;

public class CanteenController {

	private Canteen c;
	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public CanteenController() {}
	
	// FOLLOW THIS METHOD FIRST
	public int validateCanteenDetail(String canteenName, String canteenDesc, String canteenAddress){
		int validate = 0;
		
		c = new Canteen();
		validate = c.createCanteen(canteenName, canteenDesc, canteenAddress);
		
		return validate;
	}
	
	//this is later on
	public int validateCanteenDetail(int canteenID, String canteenName, String canteenDesc, String canteenAddress){
		int validate = 0;
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		validate = dataStore.updateCanteenDetail(canteenID, canteenName, canteenDesc, canteenAddress);
			
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

}
