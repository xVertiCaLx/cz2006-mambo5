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
	int updateStallDetail(int stallID, String stallName, String stallDesc, String stallStatus);
	int deleteStall(int stallID);
	
	//ADMIN
	ArrayList<Admin>  retrieveAdminList();
	
	//MENU
	ArrayList<Menu> retrieveMenu(ArrayList<Stall> stallList);
	
	//MENUITEM
	public ArrayList<MenuItem> retrieveMenuItem(ArrayList<MenuItem> menuItemList);
	public ArrayList<MenuItem> retrieveMenuItem(ArrayList<MenuItem> menuItemList, int menuItemID);
	
	//ORDER
	public ArrayList<Order> retrieveOrderID(ArrayList<Order> orderIDList, int stallID, String orderStatus);

	//ORDERDETAIL - testing
	public ArrayList<OrderDetail> retrieveOrderDetailList(ArrayList<OrderDetail> orderDetailList, int orderID);
}