package mambo5.Controller;

import java.util.ArrayList;
import java.util.Date;

import mambo5.Database.*;
import mambo5.Entity.Canteen;
import mambo5.Entity.Order;

public class OrderController { 

	private Order o;
	//private DataStoreInterface dataStore;
	//private SystemConfiguration sysConfig;
	
	public OrderController() { }
		// TODO Auto-generated constructor stub

	//validating create order
	public int validateCreateOrder(int custID, Date purchaseDate, String orderStatus){
		int validate = 0;
		
		o = new Order();
		validate = o.createOrder(custID, purchaseDate, orderStatus);
		
		return validate;
	}
	
	//validating delete order
	public int validateDeleteOrder(int orderID){
		int validate = 0;
		
		o = new Order();
		validate = o.deleteOrder(orderID);
		
		return validate;
	}
	
	//validating refund order
	public int validateRefundOrder(int orderID){
		int validate = 0;
		
		o = new Order();
		validate = o.refundOrder(orderID);
		
		return validate;
	}
}
