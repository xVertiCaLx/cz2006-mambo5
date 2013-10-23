package mambo5.Entity;

public class Staff extends Member {
	private int staffID, accessID;
	
	public Staff(int staffID, int accessID) {
		this.staffID = staffID;
		this.accessID = accessID;
	}
	
	public int getStaffID() {
		return staffID;
	}
	
	public int getAccessID() {
		return accessID;
	}
}
