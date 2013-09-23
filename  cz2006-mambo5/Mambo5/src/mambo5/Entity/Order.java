package mambo5.Entity;

import java.util.*;

public class Order {
	
	private int orderID;
	private int custID;
	private Date purchaseDate;
	
	public Order(int orderID, int custID, Date purchaseDate){
		this.orderID = orderID;
		this.custID = custID;
		this.purchaseDate = purchaseDate;
	}
}
