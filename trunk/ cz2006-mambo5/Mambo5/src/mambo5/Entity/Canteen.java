package mambo5.Entity;

import mambo5.Controller.DBController;

public class Canteen {
	private int canteenID;
	private String canteenName;
	private String canteenDesc;
	private String canteenAddress;
	private DBController dbc;
	
	
	public Canteen(){}
	
	public Canteen(String canteenName, String canteenDesc, String canteenAddress) {
		this.canteenName = canteenName;
		this.canteenDesc = canteenDesc;
		this.canteenAddress = canteenAddress;
	}
	
	public Canteen(int canteenID, String canteenName, String canteenDesc, String canteenAddress) {
		this.canteenID = canteenID;
		this.canteenName = canteenName;
		this.canteenDesc = canteenDesc;
		this.canteenAddress = canteenAddress;
	}

	public int getCanteenID() {
		return canteenID;
	}

	public String getCanteenDesc() {
		return canteenDesc;
	}

	public String getCanteenAddress() {
		return canteenAddress;
	}

	public String getCanteenName() {
		return canteenName;
	}
	
	public int createCanteen( String canteenName, String canteenDesc, String canteenAddress) {
		dbc = new DBController();
		int result = 0;
		
		String sql = "INSERT INTO canteen ( canteenName, canteenDesc, canteenAddress) "
					+ "VALUES ( '" + canteenName + "' , '" + canteenDesc + "' , '" +canteenAddress +"');";
		
		result = dbc.executeNonQuery(sql);
				
		return result;
	}
}
