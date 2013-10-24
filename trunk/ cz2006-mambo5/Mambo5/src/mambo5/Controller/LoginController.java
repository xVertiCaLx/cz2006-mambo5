package mambo5.Controller;
import java.sql.ResultSet;

import mambo5.Entity.Customer;
import mambo5.Entity.Staff;

public class LoginController {
	
	private Customer cust;
	private Staff staff;
	private DBController dbcon;
	private String sql;
	private ResultSet rs;

	public LoginController() {
		System.out.println("Login Controller Initialised");
	}
	
	public Customer validateLoginDetail(int accessID, int custID) {	
		cust = new Customer();
		cust = cust.retrieveCustomerDetail(custID);
		return cust;		
	}
	
	public Staff login(String username, String password, int accessID) {
		sql = "SELECT staffID, accessID from mambojumbo.staff WHERE staffID = '" + username + "' AND password ='" + password + "' AND accessID = '"+accessID+";";
		dbcon = new DBController();
		
		try {
			rs = dbcon.execute(sql);
			if(rs.next())
				staff = new Staff(rs.getInt(1),rs.getInt(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return staff;
	}
	
	public boolean login(String username, String password) {
		return true;
	}
}
