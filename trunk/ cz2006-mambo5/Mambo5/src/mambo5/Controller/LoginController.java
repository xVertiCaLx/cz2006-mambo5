package mambo5.Controller;
import java.sql.*;

import mambo5.Entity.Customer;

public class LoginController {
	
	private Customer cust;
	public Customer validateLoginDetail(int accessID, int custID) {
		cust = null;
		cust = cust.retrieveCustomerDetail(custID);
		return cust;		
	}

}
