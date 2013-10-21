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
	
	private Stall stall;
	
	public Stall stallLogin(int stallId, int employeeId, String password) {
		System.out.println("entered login method");
		return stall;	
	}
}
