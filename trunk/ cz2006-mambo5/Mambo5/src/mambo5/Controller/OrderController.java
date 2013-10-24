package mambo5.Controller;

import java.sql.ResultSet;
import java.util.Date;

import mambo5.Entity.Order;

public class OrderController { 

	private Order o;
	private DBController dbc;
	private ResultSet rs;
	private Order order;
	//private CamsCreateMenuItemForm form;
	//private DataStoreInterface dataStore;
	//private SystemConfiguration sysConfig;
	
	public OrderController() { }
		// TODO Auto-generated constructor stub
	
	//validating create order
		public int validateCreateOrder(int custID, Date purchaseDate, String orderStatus, int stallID){
			int validate = 0;
			
			o = new Order();
			validate = o.createOrder(custID, purchaseDate, orderStatus, stallID);
			
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
