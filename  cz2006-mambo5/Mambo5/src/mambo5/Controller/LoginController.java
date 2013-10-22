package mambo5.Controller;
import mambo5.Entity.Customer;
import mambo5.Entity.Stall;

public class LoginController {
	
	private Customer cust;
	
	public Customer validateLoginDetail(int accessID, int custID) {	
		cust = new Customer();
		cust = cust.retrieveCustomerDetail(custID);
		return cust;		
	}
	
	public void login(String username, String password) {
		
	}
}
