package mambo5.Controller;

import java.util.ArrayList;
import mambo5.Database.*;
import mambo5.Entity.Canteen;

public class CanteenController {
	private String canteenName;
	private String canteenAddress;
	private String canteenDesc;
	private int canteenID;
	private Canteen c;
	DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public CanteenController() {}
	
	public CanteenController(String canteenName, String canteenAddress, String canteenDesc) {
		this.canteenName = canteenName;
		this.canteenAddress = canteenAddress;
		this.canteenDesc = canteenDesc;
	}
	
	public CanteenController(int canteenID, String canteenName, String canteenAddress, String canteenDesc) {
		this.canteenID = canteenID;
		this.canteenName = canteenName;
		this.canteenAddress = canteenAddress;
		this.canteenDesc = canteenDesc;
	}
	
	public int validateCanteenDetail(int method){
		int validate = 0;
		if (method == 1) {
			c = new Canteen(canteenName, canteenDesc, canteenAddress);
			validate = c.createCanteen();
		}
		else if (method == 2) {
			sysConfig = new SystemConfiguration();
			dataStore = DataStoreFactory.createDataStore(sysConfig);
			validate = dataStore.updateCanteenDetail(canteenID, canteenName, canteenDesc, canteenAddress);
		}
			
			
		return validate;
	}
	
	public ArrayList<Canteen> processRetrieveCanteenList() {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return dataStore.retrieveCanteenList();		
	}
}
