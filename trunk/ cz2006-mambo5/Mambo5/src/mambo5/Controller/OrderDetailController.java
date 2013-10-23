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
	
	public OrderDetailController() { }

		//validating createOrderDetail
		public int validateCreateOrderDetail(int menuItemID, double actualPrice, String instructions){
			int validate = 0;
			
			od = new OrderDetail();
			validate = od.createOrderDetail(menuItemID, actualPrice, instructions);
			
			return validate;
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
