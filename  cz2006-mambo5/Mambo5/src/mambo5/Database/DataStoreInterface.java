package mambo5.Database;

import java.util.ArrayList;

import mambo5.Entity.*;

//Strategy interface for data store objects
public interface DataStoreInterface {
	//methods
	
	//CANTEEN
	ArrayList<Canteen> retrieveCanteenList();
	int updateCanteenDetail(int canteenID, String canteenName, String canteenDesc, String canteenAddress);
	int deleteCanteen(int canteenID);
	
	//STALL
	ArrayList<Stall> retrieveStallList(int canteenID);
	
	//int updateCustomerDetail(int custID, double cardBalance, String fullNddame, int accessID);
	
	}