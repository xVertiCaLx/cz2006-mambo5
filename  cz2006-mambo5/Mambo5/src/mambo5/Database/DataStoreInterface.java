package mambo5.Database;

import java.util.ArrayList;

import mambo5.Entity.*;

//Strategy interface for data store objects
public interface DataStoreInterface {
	//methods
	
	//CANTEEN
	ArrayList<Canteen> retrieveCanteenList();
	int updateCanteenDetail(int canteenID, String canteenName, String canteenDesc, String canteenAddress, int maxStall);
	int deleteCanteen(int canteenID);
	
	//STALL
	ArrayList<Stall> retrieveStallList(int canteenID);
	int createStall(int canteenID, String stallUnit, String stallName, String stallDesc, String stallStatus);
	
	//ADMIN
	ArrayList<Admin>  retrieveAdminList();
	
	//MENU
	ArrayList<Menu> retrieveMenu(ArrayList<Stall> stallList);
	
	}