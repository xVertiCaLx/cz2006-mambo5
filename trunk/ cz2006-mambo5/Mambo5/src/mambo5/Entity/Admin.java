package mambo5.Entity;

public class Admin {
	private int adminID;
	private int accessID;
	private int stallID;
	private String adminName;
	private String password;
	
	public Admin (int adminID, int accessID, int stallID, String adminName, String password) {
		this.adminID = adminID;
		this.accessID = accessID;
		this.stallID = stallID;
		this.adminName = adminName;
		this.password = password;
	}
}
