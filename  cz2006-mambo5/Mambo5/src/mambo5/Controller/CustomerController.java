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
	
	public int validateCustomerDetail(double cardBalance, String fullName, int accessID){
		int validate = 0;
		
		cust = new Customer();
		validate = cust.createCustomer(cardBalance, fullName, 6);
				
		return validate;
	}
	
	
}
