package mambo5.Entity;

import java.sql.ResultSet;

import mambo5.Controller.DBController;

public class Access {
	private int accessID;
	private String accessDesc;
	
	public Access() {}

	public Access (int accessID, String accessDesc) {
		this.accessID = accessID;
		this.accessDesc = accessDesc;
	}
}
