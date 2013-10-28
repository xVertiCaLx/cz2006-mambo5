package mambo5.Controller;

import java.util.ArrayList;
import java.util.Date;

import mambo5.Database.DataStoreFactory;
import mambo5.Database.DataStoreInterface;
import mambo5.Database.SystemConfiguration;
import mambo5.Entity.Order;

public class OrderController {

	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;

	public OrderController() {
	}

	// validating create order
	public int validateCreateOrder(int custID, Date purchaseDate,
			String orderStatus, int stallID) {
		int validate = 0;

		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);

		validate = dataStore.createOrder(custID, purchaseDate, orderStatus, stallID);

		return validate;
	}

	// validating refund order
	public int validateRefundOrder(int orderID) {
		int validate = 0;

		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		validate = dataStore.refundOrder(orderID);

		return validate;
	}

	// validating confirm order
	public int validateConfirmOrder(int orderID) {
		int validate = 0;

		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		validate = dataStore.confirmOrder(orderID);

		return validate;
	}
	
	public ArrayList<Order> retrieveOrderList(ArrayList<Order> orderList) {
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);

		return dataStore.retrieveOrderList(orderList);
	}
	
}
