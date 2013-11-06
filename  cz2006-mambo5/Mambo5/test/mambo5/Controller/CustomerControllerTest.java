package mambo5.Controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerControllerTest {

	private CustomerController customerController;
	int cardBalance, accessID;
	String name;
	int expected;
	
	@Before
	public void setUp() throws Exception {
		customerController = new CustomerController();
		cardBalance = 10;
		name = "Tan";
		accessID = 1;
		expected = 0;
	}
	
	@Test
	public void testRetrieveCustomerInfoPass() {
		expected = 1;
		int result = customerController.validateCustomerDetail(cardBalance, name, accessID);
		assertEquals(result, expected);
	}
	
	@Test
	public void testRetrieveCustomerInfoLessBalance() {
		cardBalance = 9;
		int result = customerController.validateCustomerDetail(cardBalance, name, accessID);
		assertEquals(result, expected);
	}
	
	@Test
	public void testRetrieveCustomerInfoEmptyName() {
		name = "";
		int result = customerController.validateCustomerDetail(cardBalance, name, accessID);
		assertEquals(result, expected);
	}

	@Test
	public void testRetrieveCustomerInfoAccessID() {
		accessID = 0;
		int result = customerController.validateCustomerDetail(cardBalance, name, accessID);
		assertEquals(result, expected);
	}
	
}
