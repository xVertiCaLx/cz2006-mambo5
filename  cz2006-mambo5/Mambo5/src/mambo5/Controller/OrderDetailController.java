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
	//private CamsCreateMenuItemForm form;
	//private DataStoreInterface dataStore;
	//private SystemConfiguration sysConfig;
	private DBController dbc;
	
	public OrderDetailController() { }

		//validating createOrderDetail
		public int validateCreateOrderDetail(int orderID,int menuItemID, double actualPrice){
			int validate = 0;
			
			od = new OrderDetail();
			validate = od.createOrderDetail(orderID, menuItemID, actualPrice);
			
			return validate;
		}
		
		public void createOrderDetails(int orderID, int menuItemID, double actualPrice) 
		{
			dbc = new DBController();
			String sql = "INSERT INTO orderdetails (orderID, menuItemID, actualPrice)"
						+ "VALUES ( '"+ orderID +"', '" + menuItemID + "' , '" + actualPrice + "');";
			dbc.executeNonQuery(sql);
		}
		
		//validating deleteOrderDetail
		public int deleteOrderDetail(int detailID){
			
			int removeStatus = 0;
			
			od = new OrderDetail();
			removeStatus = od.deleteOrderDetail(detailID);
					
			return removeStatus;
		}
		
		public int validateCalculateTotalPrice(int orderID)
		{
			int validate = 0;
			
			od = new OrderDetail();
			validate = od.calculateTotalPrice(orderID);
			
			return validate;
		}
}
