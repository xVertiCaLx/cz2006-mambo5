package mambo5.Controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerControllerTest {

	private CustomerController customerController;
	int custID;
	int expected;
	
	@Before
	public void setUp() throws Exception {
		customerController = new CustomerController();
		custID = 1;
		expected = 1;
	}

	@Test
	public void testRetrieveCustomerInfoPass() {
		//int result = customerController.retrieveCustomerInfo(custID);
	}

}
