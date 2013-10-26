package mambo5.Entity;

public class Vistor extends Customer{
	private String vistorID;
	
	public Vistor(String vistorID) {
		this.vistorID = vistorID;
	}

	public void setVistorID(String vistorID) {
		this.vistorID = vistorID;
	}

	public String getVistorID() {
		return vistorID;
	}
	
}
