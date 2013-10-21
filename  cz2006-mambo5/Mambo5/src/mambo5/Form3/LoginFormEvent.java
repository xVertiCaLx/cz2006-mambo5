package mambo5.Form3;

public class LoginFormEvent {

	private int stallId, staffId;
	private String password;
	
	public LoginFormEvent(int stallId, int staffId, String password) {
		this.stallId = stallId;
		this.staffId = staffId;
		this.password = password;
	}

}
