package mambo5.Database;

import java.util.ArrayList;
import java.util.Date;

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
	ArrayList<Menu> retrieveMenuList(ArrayList<Menu> menuList);
	int createMenu(int stallID, String menuType);
	
	//MENUITEM
	int createMenuItem(int menuID, String menuItemName, double menuItemPrice, double discount);
	int updateMenuItem(String menuItemName,double menuItemPrice,double discount, int menuItemID);
	int deleteMenuItem(int menuItemID);
	ArrayList<MenuItem> retrieveMenuItem(ArrayList<MenuItem> menuItemList);
	ArrayList<MenuItem> retrieveMenuItem(ArrayList<MenuItem> menuItemList, int menuItemID);
	
	//ORDER
	int createOrder(int custID, Date purchaseDate, String orderStatus, int stallID);
	int refundOrder(int orderID);
	int confirmOrder(int orderID);
	ArrayList<Order> retrieveOrderID(ArrayList<Order> orderIDList, int stallID, String orderStatus);
	ArrayList<Order> retrieveOrderList(ArrayList<Order> orderList);

	//ORDERDETAIL
	int createOrderDetail(int orderID, int menuItemID, double actualPrice, int quantity);
	ArrayList<OrderDetail> retrieveOrderDetailList(ArrayList<OrderDetail> orderDetailList);
	ArrayList<OrderDetail> retrieveOrderDetailTotalPrice(ArrayList<OrderDetail> orderDetailList, int orderID);
	
	//CUSTOMER
	int createCustomer(double cardBalance, String fullName, int accessID);
	int updateCustomerCardValue(int custID, double cardBalance);
	int refundCustomerCard(int custID);
	Customer retrieveCustomerDetail(int custID);
	ArrayList<String> retrieveCustomerPurchaseDate(int custID);
	ArrayList<MenuItem> retrieveSpecificPurchaseDate(String purchaseDate, int custID);
}