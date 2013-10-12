package mambo5.Entity;

import java.sql.ResultSet;

import mambo5.Controller.DBController;

public class Canteen {
	private int canteenID;
	private String canteenName;
	private String canteenDesc;
	private String canteenAddress;
	private DBController dbc;
	
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
	
	public int createCanteen() {
		dbc = new DBController();
		int result = 0;
		
		String sql = "INSERT INTO canteen ( canteenName, canteenDesc, canteenAddress) "
					+ "VALUES ( '" + canteenName + "' , '" + canteenDesc + "' , '" +canteenAddress +"');";
		
		result = dbc.executeNonQuery(sql);
		dbc.terminate();
		
		return result;
	}
}
