package mambo5.Entity;

public class Visitor extends Customer{
	private String visitorID;
	
	public Visitor(String vistorID) {
		this.visitorID = vistorID;
	}

	public void setVistorID(String vistorID) {
		this.visitorID = vistorID;
	}

	public String getVistorID() {
		return visitorID;
	}
	
}
