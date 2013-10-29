package mambo5.Entity;

public class Customer  {
	
	private int custID;
	private double cardBalance;
	private String fullName;
	private int accessID;
	private String email;
	
	public int getCustID() {
		return custID;
	}
	
	public String getEmail() {
		return email;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public double getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAccessID() {
		return accessID;
	}

	public void setAccessID(int accessID) {
		this.accessID = accessID;
	}
	
	public Customer() {}
	
	//1
	public Customer(int custID, double cardBalance, String fullName, int accessID, String email){
		this.custID = custID;
		this.cardBalance = cardBalance;
		this.fullName = fullName;
		this.accessID = accessID;
		this.email = email;
	}
}