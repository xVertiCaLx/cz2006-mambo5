package mambo5.Controller;
import java.sql.ResultSet;

import mambo5.Entity.Admin;


public class LoginController {

	private Admin admin;
	private DBController dbc;
	private String sql;
	private ResultSet rs;
	
	//login remind wei long should be in interface

	public LoginController() {
		System.out.println("Login Controller Initialised");
	}

	public boolean validateLoginField(String userid, String password) {
		if (userid.isEmpty() || password.isEmpty()) return false;
		else if (userid.length()>11 || userid.length()<1) return false;
		else if (!userid.matches("[0-9]+")) return false;
		else return true;
	}
	
	public Admin login(String userid, String password) {
		dbc = new DBController();
		if (validateLoginField(userid, password)) {
			sql = "SELECT * FROM admin WHERE adminID = '" + userid + "' AND password = '" + password + "';";
			rs = dbc.execute(sql);
			try {
				if(rs.next())
					admin = new Admin(rs.getInt("adminID"), rs.getInt("accessID"), rs.getInt("stallID"), rs.getString("adminName"), rs.getString("password"));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dbc.terminate();
			}
		} 
		
		return admin;
	}
}
