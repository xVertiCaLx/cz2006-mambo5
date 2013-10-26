package mambo5.Entity;

public class Staff extends Customer {
	private int staffID;
	
	public Staff(int staffID) {
		this.staffID = staffID;
	}
	
	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	
}
