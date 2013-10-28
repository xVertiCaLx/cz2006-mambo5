package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.*;
import mambo5.Entity.Canteen;
import mambo5.Entity.Customer;
import mambo5.Entity.MenuItem;

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
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		
		addValueStatus = dataStore.updateCustomerCardValue(custID, cardBalance);
		
		return addValueStatus;
	}
	
	public int removeCustomerAccount(int custID){
		
		int removeStatus = 0;
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		removeStatus = dataStore.refundCustomerCard(custID);
				
		return removeStatus;
	}
	
	public Customer retrieveCustomerInfo(int custID)
	{
		cust = new Customer();
		cust = cust.retrieveCustomerDetail(custID);
	
		return cust;
	}
	
	public ArrayList<String> getCustomerPuchaseDate(int custID) {
		
		cust = new Customer();
		return cust.retrieveCustomerPurchaseDate(custID);
		
	}
	
	public ArrayList<MenuItem> getCustomerMenuItem(String purchaseDate, int custID) {
		cust = new Customer();
		return cust.retrieveSpecificPurchaseDate(purchaseDate, custID);	
	}
	
}
