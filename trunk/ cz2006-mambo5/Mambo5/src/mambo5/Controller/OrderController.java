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

	public Order createOrder(int custID, Date purchaseDate, String orderStatus, int stallID) {
		dbc = new DBController();
		String sql = "INSERT INTO mambojumbo.orders (custID, purchaseDate, orderStatus, stallID) "
				+ "VALUES ( '" + custID + "' , '" + purchaseDate + "' , '" + orderStatus +"' , '" + stallID +"');";
		System.out.println("Attempting to " + sql);
		
		dbc.executeNonQuery(sql);
		sql = "Select orderID from mambojumbo.orders order by orderID desc limit 1;";
		
		try {
			rs = dbc.execute(sql);
 			if (rs.next()) {
 				order = new Order(rs.getInt(1), custID, purchaseDate, orderStatus, stallID);
 			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
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
