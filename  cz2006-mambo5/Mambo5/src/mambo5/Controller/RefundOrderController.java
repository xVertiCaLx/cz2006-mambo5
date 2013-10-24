package mambo5.Controller;

import java.util.ArrayList;
import java.util.Date;

import mambo5.Database.*;
import mambo5.Entity.Canteen;
import mambo5.Entity.Customer;
import mambo5.Entity.Order;
import mambo5.Form2.CamsCreateMenuItemForm;

public class RefundOrderController { 

	private Order od;
	//private CamsCreateMenuItemForm form;
	//private DataStoreInterface dataStore;
	//private SystemConfiguration sysConfig;
	private DBController dbc;
	
	public RefundOrderController() { }
	
		//validating createOrderDetail
		public int validateRefundOrder(int orderID){
			int validate = 0;
			
			od = new Order();
			validate = od.RefundOrder(orderID);
			
			return validate;
		}

}
