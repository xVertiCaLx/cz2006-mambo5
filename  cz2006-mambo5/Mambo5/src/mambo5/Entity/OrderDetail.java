package mambo5.Entity;

public class OrderDetail {
	private int detailID;
	private int menuItemID;
	private int orderID;
	private double actualPrice;
	private String instructions;
	
	public OrderDetail(int detailID, int menuItemID, int orderID, double actualPrice, String instructions) {
		this.detailID = detailID;
		this.menuItemID = menuItemID;
		this.orderID = orderID;
		this.actualPrice = actualPrice;
		this.instructions = instructions;
	}
}
