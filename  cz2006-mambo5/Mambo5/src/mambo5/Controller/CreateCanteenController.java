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
	
	public boolean validateCanteenDetail(){
		boolean validate = false;
		Canteen c = new Canteen(canteenName, canteenDesc, canteenAddress);
		c.createCanteen();
		validate = true;
				
		return validate;
	}
}
