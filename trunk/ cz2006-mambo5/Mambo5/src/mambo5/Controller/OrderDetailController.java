package mambo5.Controller;

import java.util.ArrayList;
import java.util.Date;

import mambo5.Database.*;
import mambo5.Entity.Canteen;
import mambo5.Entity.Customer;
import mambo5.Entity.Order;
import mambo5.Entity.MenuItem;
import mambo5.Entity.OrderDetail;
import mambo5.Form2.CamsCreateMenuItemForm;

public class OrderDetailController { 

	private OrderDetail od;
	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public OrderDetailController() { }

		//validating createOrderDetail
		public int validateCreateOrderDetail(int orderID,int menuItemID, double actualPrice){
			int validate = 0;
			
			od = new OrderDetail();
			validate = od.createOrderDetail(orderID, menuItemID, actualPrice);
			
			return validate;
		}
		
		//guohao
		public ArrayList<Order> retrieveOrderIDList(ArrayList<Order> orderIDList, int stallID, String orderStatus) {
			sysConfig = new SystemConfiguration();
			dataStore = DataStoreFactory.createDataStore(sysConfig);
			
			return dataStore.retrieveOrderID(orderIDList, stallID, orderStatus);
		}
		
		//guohao - testing
		public ArrayList<OrderDetail> retrieveOrderDetailList(ArrayList<OrderDetail> orderDetailList, int orderID) {
			System.out.println("REACH retrieveOrderDetailList");
			sysConfig = new SystemConfiguration();
			dataStore = DataStoreFactory.createDataStore(sysConfig);
			
			return dataStore.retrieveOrderDetailList(orderDetailList, orderID);
		}
}
