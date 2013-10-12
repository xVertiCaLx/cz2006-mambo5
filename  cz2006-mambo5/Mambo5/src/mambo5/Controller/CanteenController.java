package mambo5.Controller;

import java.util.ArrayList;
import mambo5.Database.*;
import mambo5.Entity.Canteen;

public class CanteenController {
	private String canteenName;
	private String canteenAddress;
	private String canteenDesc;
	private Canteen c;
	DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public CanteenController() {}
	
	public CanteenController(String canteenName, String canteenAddress, String canteenDesc) {
		this.canteenName = canteenName;
		this.canteenAddress = canteenAddress;
		this.canteenDesc = canteenDesc;
	}
	
	public int validateCanteenDetail(){
		int validate = 0;
		c = new Canteen(canteenName, canteenDesc, canteenAddress);
		validate = c.createCanteen();
				
		return validate;
	}
	
	public ArrayList<Canteen> processRetrieveCanteenList() {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return dataStore.retrieveCanteenList();		
	}
}
