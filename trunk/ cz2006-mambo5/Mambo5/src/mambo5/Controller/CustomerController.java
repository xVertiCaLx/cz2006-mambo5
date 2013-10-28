package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.*;
import mambo5.Entity.Canteen;
import mambo5.Entity.Customer;

public class CustomerController {
	

	private Customer cust;
	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public CustomerController() {}
		
	public int validateCustomerDetail(double cardBalance, String fullName, int accessID){
		
		int validate = 0;
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		validate = dataStore.createCustomer(cardBalance, fullName, accessID);
				
		return validate;
	}
	
	public int updateCustomerCardBalance(int custID, double cardBalance)
	{
		int addValueStatus = 0;
		
		cust = new Customer();
		addValueStatus = cust.updateCustomerCardValue(custID, cardBalance);
		
		return addValueStatus;
	}
	
	public int removeCustomerAccount(int custID){
		
		int removeStatus = 0;
		
		cust = new Customer();
		removeStatus = cust.refundCustomerCard(custID);
				
		return removeStatus;
	}
	
	public Customer retrieveCustomerInfo(int custID)
	{
		cust = new Customer();
		cust = cust.retrieveCustomerDetail(custID);
	
		return cust;
	}
	
	public ArrayList<Customer> getCustomerPuchaseDate() {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		return null;		
	}
		
	
}
