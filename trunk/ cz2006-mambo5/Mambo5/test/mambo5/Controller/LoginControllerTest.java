package mambo5.Controller;

import static org.junit.Assert.*;
import mambo5.Entity.Admin;

import org.junit.Before;
import org.junit.Test;

public class LoginControllerTest {

	private LoginController loginController;
	String id;
	String password;

	@Before
	public void setUp() throws Exception {
		loginController = new LoginController();
		id = "2";
		password = "anything";
	}

	@Test
	public void testLoginPass() {
		Admin result;
		result = loginController.login(id, password);
		assertNotNull(result);		
	}

	@Test
	public void testLoginFailPassword() {
		password = "something";
		Admin result;
		result = loginController.login(id, password);
		assertNull(result);
	}
	
	@Test
	public void testLoginFailID() {
		id = "20";
		System.out.println(password);
		Admin result;
		result = loginController.login(id, password);
		assertNull(result);
	}

}
