package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.DataStoreFactory;
import mambo5.Database.DataStoreInterface;
import mambo5.Database.SystemConfiguration;
import mambo5.Entity.Admin;

public class AdminController {

	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public AdminController() {
		
	}
	
	public ArrayList<Admin> processRetrieveAdminnList() {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return dataStore.retrieveAdminList();
	}

}
