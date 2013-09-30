package mambo5.Entity;

public class Stall {
	private int stallID;
	private int canteenID;
	private String stallUnit;
	private String stallName;
	private String stallDesc;
	private Boolean stallStatus;
	
	public Stall(int stallID, int canteenID, String stallUnit, String stallName, String stallDesc, Boolean stallStatus) {
		this.stallID = stallID;
		this.canteenID = canteenID;
		this.stallUnit = stallUnit;
		this.stallName = stallName;
		this.stallDesc = stallDesc;
		this.stallStatus = stallStatus;
	}
}