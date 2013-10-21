package mambo5.Entity;

import mambo5.Form3.LoginFormEvent;
import mambo5.Form3.LoginListener;

public class Stall implements LoginListener {
	private int stallID;
	private int canteenID;
	private String stallUnit;
	private String stallName;
	private String stallDesc;
	private Boolean stallStatus;
	
	public Stall(){}
	
	public Stall(int stallID, int canteenID, String stallUnit, String stallName, String stallDesc, Boolean stallStatus) {
		this.stallID = stallID;
		this.canteenID = canteenID;
		this.stallUnit = stallUnit;
		this.stallName = stallName;
		this.stallDesc = stallDesc;
		this.stallStatus = stallStatus;
	}
	
	public int getStallId() {
		return stallID;
	}
	
	public int getCanteenId() {
		return canteenID;
	}
	
	public String getStallUnit() {
		return stallUnit;
	}
	
	public String getStallName() {
		return stallName;
	}
	
	public String getStallDesc() {
		return stallDesc;
	}
	
	public Boolean getStallStatus() {
		return stallStatus;
	}

	@Override
	public void loginListener(LoginFormEvent event) {
		// TODO Auto-generated method stub
		
	}
}
