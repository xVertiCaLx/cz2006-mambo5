package mambo5.Controller;

import mambo5.Entity.Canteen;

public class CreateCanteenController {
	private String canteenName;
	private String canteenAddress;
	private String canteenDesc;
	
	public CreateCanteenController(String canteenName, String canteenAddress, String canteenDesc) {
		this.canteenName = canteenName;
		this.canteenAddress = canteenAddress;
		this.canteenDesc = canteenDesc;
	}
	
	public int validateCanteenDetail(){
		int validate = 0;
		Canteen c = new Canteen(canteenName, canteenDesc, canteenAddress);
		validate = c.createCanteen();
				
		return validate;
	}
}
