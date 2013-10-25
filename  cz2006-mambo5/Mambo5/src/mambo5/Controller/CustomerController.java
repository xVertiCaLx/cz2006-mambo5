package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.*;
import mambo5.Entity.Canteen;
import mambo5.Entity.Customer;

public class CustomerController {
	

	private Customer cust;
	DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public CustomerController() {}
		
	public int validateCustomerDetail(double cardBalance, String fullName, int accessID){
		
		int validate = 0;
		
		cust = new Customer();
		validate = cust.createCustomer(cardBalance, fullName, accessID);
				
		return validate;
	}
	
	public int removeCustomerAccount(int custID){
		
		int removeStatus = 0;
		
		cust = new Customer();
		removeStatus = cust.refundCustomerCard(custID);
				
		return removeStatus;
	}
	
	public Customer retrieveCustInfo(int custID)
	{
		cust = new Customer();
		cust = cust.retrieveCustomerDetail(custID);
	
		return cust;
	}
	
}
