package mambo5.Entity;

import mambo5.Controller.DBController;

public class Canteen {
	private int canteenID;
	private String canteenName;
	private String canteenDesc;
	private String canteenAddress;
	private int maxStall;
	
	
	public Canteen(){}
	
	public Canteen(String canteenName, String canteenDesc, String canteenAddress) {
		this.canteenName = canteenName;
		this.canteenDesc = canteenDesc;
		this.canteenAddress = canteenAddress;
	}
	
	public Canteen(int canteenID, String canteenName, String canteenDesc, String canteenAddress, int maxStall) {
		this.canteenID = canteenID;
		this.canteenName = canteenName;
		this.canteenDesc = canteenDesc;
		this.canteenAddress = canteenAddress;
		this.maxStall = maxStall;
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
	
	public int getMaxStall() {
		return maxStall;
	}
}
