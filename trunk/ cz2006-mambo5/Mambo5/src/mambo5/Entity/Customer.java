package mambo5.Entity;

public class Customer {
	
	private int custID;
	private double cardBalance;
	private String fullName;
	private int accessID;
	
	public Customer(int custID, double cardBalance, String fullName, int accessID){
		this.custID = custID;
		this.cardBalance = cardBalance;
		this.fullName = fullName;
		this.accessID = accessID;
	}
	
}
