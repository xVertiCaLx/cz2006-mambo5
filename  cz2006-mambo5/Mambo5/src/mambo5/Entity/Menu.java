package mambo5.Entity;

public class Menu {
	private int menuID;
	private int stallID;
	private String menuType;
	
	public Menu(int menuID, int stallID, String menuType) {
		this.menuID = menuID;
		this.stallID = stallID;
		this.menuType = menuType;
	}
}
