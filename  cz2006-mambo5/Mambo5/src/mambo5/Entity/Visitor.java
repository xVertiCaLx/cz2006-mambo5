package mambo5.Entity;

public class Visitor extends Customer{
	private String vistorID;
	
	public Visitor(String vistorID) {
		this.vistorID = vistorID;
	}

	public void setVistorID(String vistorID) {
		this.vistorID = vistorID;
	}

	public String getVistorID() {
		return vistorID;
	}
	
}
