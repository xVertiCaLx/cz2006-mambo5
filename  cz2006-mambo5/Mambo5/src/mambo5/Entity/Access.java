package mambo5.Entity;

public class Access {
	private int accessID;
	private String accessDesc;
	
	public Access() {}

	public Access (int accessID, String accessDesc) {
		this.accessID = accessID;
		this.accessDesc = accessDesc;
	}

	public int getAccessID() {
		return accessID;
	}

	public void setAccessID(int accessID) {
		this.accessID = accessID;
	}

	public String getAccessDesc() {
		return accessDesc;
	}

	public void setAccessDesc(String accessDesc) {
		this.accessDesc = accessDesc;
	}
	
	
}
