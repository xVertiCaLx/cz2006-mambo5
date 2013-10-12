package mambo5.Database;

import java.util.ArrayList;

import mambo5.Entity.Canteen;

//Strategy interface for data store objects
public interface DataStoreInterface {
	//methods
	
	ArrayList<Canteen> retrieveCanteenList();
}