package mambo5.Entity;

public class Admin {
	private int adminID,accessID;
	private int stallID;
	private String adminName, password;
	
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

	public String getPassword() {
		return password;
	}
	
}
