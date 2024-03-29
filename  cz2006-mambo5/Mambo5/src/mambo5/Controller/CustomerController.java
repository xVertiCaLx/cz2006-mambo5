package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.*;
import mambo5.Entity.Customer;
import mambo5.Entity.MenuItem;

public class CustomerController {
	

	private Customer cust;
	private DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public CustomerController() {}
		
	public int validateCustomerDetail(double cardBalance, String fullName, int accessID){
		
		int validate = 0;
		if (cardBalance < 10 || fullName.isEmpty() || accessID < 1) {
			validate = 0;
		} else {
			sysConfig = new SystemConfiguration();
			dataStore = DataStoreFactory.createDataStore(sysConfig);
			validate = 1;
			dataStore.createCustomer(cardBalance, fullName, accessID);
		}
			
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
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		cust = dataStore.retrieveCustomerDetail(custID);
	
		return cust;
	}
	
	public ArrayList<String> getCustomerPuchaseDate(int custID) {
		
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		return dataStore.retrieveCustomerPurchaseDate(custID);
		
	}
	
	public ArrayList<MenuItem> getCustomerMenuItem(String purchaseDate, int custID) {
		sysConfig = new SystemConfiguration();
		dataStore = DataStoreFactory.createDataStore(sysConfig);
		return dataStore.retrieveSpecificPurchaseDate(purchaseDate, custID);	
	}
	
}
