package mambo5.Entity;

import java.sql.ResultSet;

import mambo5.Controller.DBController;

public class Admin {
	private int adminID,accessID;
	private int stallID;
	private String adminName, password, sql;
	private Admin admin;
	private DBController dbc;
	private ResultSet rs;
	
	public Admin (int adminID, int accessID, int stallID, String adminName, String password) {
		this.adminID = adminID;
		this.accessID = accessID;
		this.stallID = stallID;
		this.adminName = adminName;
		this.password = password;
	}
	
	public int getAdminID() {
		return adminID;
	}
	
	public int getAccessID() {
		return accessID;
	}
	
	public int getStallID() {
		return stallID;
	}
	
	public String getAdminName() {
		return adminName;
	}
}
