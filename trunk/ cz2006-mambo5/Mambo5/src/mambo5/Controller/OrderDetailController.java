package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.*;
import mambo5.Entity.OrderDetail;

public class OrderDetailController { 

	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public OrderDetailController() { }

		//create order details
		public int validateCreateOrderDetail(int orderID,int menuItemID, double actualPrice, int quantity){
			int validate = 0;
			
			sysConfig = new SystemConfiguration();
			dataStore = DataStoreFactory.createDataStore(sysConfig);
			
			validate = dataStore.createOrderDetail(orderID, menuItemID, actualPrice, quantity);
			
			return validate;
		}
		public ArrayList<OrderDetail> retrieveOrderDetailList(ArrayList<OrderDetail> orderDetailList) {
			sysConfig = new SystemConfiguration();
			dataStore = DataStoreFactory.createDataStore(sysConfig);
			
			return dataStore.retrieveOrderDetailList(orderDetailList);
		}
}
