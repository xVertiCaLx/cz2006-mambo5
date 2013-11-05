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
		boolean result;
		result = loginController.validateLoginField(id, password);
		assertTrue(result);
	}
	
	@Test
	public void testLoginPass2() {
		id = "34";
		boolean result;
		result = loginController.validateLoginField(id, password);
		assertTrue(result);
	}

	@Test
	public void testLoginFailEmptyID() {
		id = "";
		boolean result;
		result = loginController.validateLoginField(id, password);
		assertFalse(result);
	}
	
	@Test
	public void testLoginFailMTID() {
		id = "123456789012";
		boolean result;
		result = loginController.validateLoginField(id, password);
		assertFalse(result);
	}
	
	@Test
	public void testLoginFailEmptyPassword() {
		password ="";
		boolean result;
		result = loginController.validateLoginField(id, password);
		assertFalse(result);
	}
	
	@Test
	public void testLoginFailCharID() {
		id = "a1";
		boolean result;
		result = loginController.validateLoginField(id, password);
		assertFalse(result);
	}

}
