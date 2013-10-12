package mambo5.Database;

public class DataStoreFactory {
	// This factory method returns a concrete data store object that implements DataStoreInterface based on system configuration
	public static DataStoreInterface createDataStore(SystemConfiguration sysConfig) {
		String dataStoreConfig = sysConfig.getAccess();
		if(dataStoreConfig.equals("MYSQL")) {
			return new MySQLImpl();
		} 
		else {
			return null;
		}
	}
}