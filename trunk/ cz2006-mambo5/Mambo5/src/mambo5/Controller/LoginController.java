package mambo5.Controller;

import mambo5.Database.DataStoreFactory;
import mambo5.Database.DataStoreInterface;
import mambo5.Database.SystemConfiguration;
import mambo5.Entity.Admin;


public class LoginController {

	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public LoginController() {
		System.out.println("Login Controller Initialised");
	}

	public boolean validateLoginField(String userid, String password) {
		if (userid.isEmpty() || password.isEmpty()) return false;
		else if (userid.length()>11 || userid.length()<1) return false;
		else if (!userid.matches("[0-9]+")) return false;
		else return true;
	}
	
	public Admin login(String userid, String password) {
		if (validateLoginField(userid, password)) {
			sysConfig = new SystemConfiguration();
			dataStore = DataStoreFactory.createDataStore(sysConfig);
			return dataStore.login(userid, password);
		} 
		else
			return null;	
	}
}
