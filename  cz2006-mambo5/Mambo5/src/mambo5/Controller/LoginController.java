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
	
	
	public Customer validateLoginDetail(int accessID, int custID) {	
		cust = new Customer();
		cust = cust.retrieveCustomerDetail(custID);
		return cust;		
	}
	
	public Staff login(String username, String password) {
		sql = "SELECT staffID, accessID from staff WHERE staffID = '" + username + "' AND password ='" + password + "';";
		dbcon = new DBController();
		rs = dbcon.executeQuery(sql);
		try {
			while (rs.next()) {
				staff = new Staff(rs.getInt(0), rs.getInt(1));
			}
		} catch (Exception e) {
			
		}
		
		return staff;
	}
}
