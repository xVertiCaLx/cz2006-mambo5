package mambo5.Controller;

import java.util.ArrayList;
import mambo5.Database.*;
import mambo5.Entity.Order;
import mambo5.Entity.OrderDetail;

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
		
		//Retrieving orderID
		public ArrayList<Order> retrieveOrderIDList(ArrayList<Order> orderIDList, int stallID, String orderStatus) {
			sysConfig = new SystemConfiguration();
			dataStore = DataStoreFactory.createDataStore(sysConfig);
			
			return dataStore.retrieveOrderID(orderIDList, stallID, orderStatus);
		}
		
		//Retrieving orderDetails
		public ArrayList<OrderDetail> retrieveOrderDetailList(ArrayList<OrderDetail> orderDetailList, int orderID) {
			sysConfig = new SystemConfiguration();
			dataStore = DataStoreFactory.createDataStore(sysConfig);
			
			return dataStore.retrieveOrderDetailList(orderDetailList, orderID);
		}
}
