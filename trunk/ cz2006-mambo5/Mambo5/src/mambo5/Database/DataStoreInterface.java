package mambo5.Database;

import java.util.ArrayList;

import mambo5.Entity.*;

//Strategy interface for data store objects
public interface DataStoreInterface {
	//methods
	
	//CANTEEN
	int createCanteen( String canteenName, String canteenDesc, String canteenAddress, int  maxStall);
	ArrayList<Canteen> retrieveCanteenList();
	int updateCanteenDetail(int canteenID, String canteenName, String canteenDesc, String canteenAddress, int maxStall);
	int deleteCanteen(int canteenID);
	
	//STALL
	ArrayList<Stall> retrieveStallList(int canteenID);
	int createStall(int canteenID, String stallUnit, String stallName, String stallDesc, String stallStatus);
	int updateStallDetail(int stallID, String stallName, String stallDesc, String stallStatus);
	int deleteStall(int stallID);
	
	//ADMIN
	ArrayList<Admin> retrieveAdminList();
	
	//MENU
	ArrayList<Menu> retrieveMenu(ArrayList<Stall> stallList);
	
	//MENUITEM
	ArrayList<MenuItem> retrieveMenuItem(ArrayList<MenuItem> menuItemList);
	ArrayList<MenuItem> retrieveMenuItem(ArrayList<MenuItem> menuItemList, int menuItemID);
	
	//ORDER
	ArrayList<Order> retrieveOrderID(ArrayList<Order> orderIDList, int stallID, String orderStatus);
	ArrayList<Order> retrieveOrderList(ArrayList<Order> orderList);

	//ORDERDETAIL - testing
	ArrayList<OrderDetail> retrieveOrderDetailList(ArrayList<OrderDetail> orderDetailList);
	
	//CUSTOMER
	int createCustomer(double cardBalance, String fullName, int accessID);
	int updateCustomerCardValue(int custID, double cardBalance);
	int refundCustomerCard(int custID);
}