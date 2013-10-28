package mambo5.Entity;

public class Staff extends Customer {
	private String staffID;
	
	public Staff(String staffID) {
		this.staffID = staffID;
	}
	
	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	
}
