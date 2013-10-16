package mambo5.Controller;

import java.util.ArrayList;

import mambo5.Database.*;
import mambo5.Entity.Canteen;
import mambo5.Entity.Customer;

public class CustomerController {
	
	private int custID;
	private double cardBalance;
	private String fullName;
	private int accessID;
	private Customer cust;
	DataStoreInterface dataStore;
	private SystemConfiguration sysConfig;
	
	public CustomerController() {}
	
	public CustomerController(int custID, double cardBalance, String fullName, int accessID) {
		this.custID = custID;
		this.cardBalance = cardBalance;
		this.fullName = fullName;
		this.accessID = accessID;
	}
	
	public int validateCustomerDetail(int method){
		int validate = 0;
		if (method == 1) {
			cust = new Customer(custID, cardBalance, fullName, accessID);
			validate = cust.createCustomer();
		}
		else if (method == 2) {
			sysConfig = new SystemConfiguration();
			dataStore = DataStoreFactory.createDataStore(sysConfig);
			validate = dataStore.updateCustomerDetail(custID, cardBalance,  fullName, accessID);
		}
			
			
		return validate;
	}
}
