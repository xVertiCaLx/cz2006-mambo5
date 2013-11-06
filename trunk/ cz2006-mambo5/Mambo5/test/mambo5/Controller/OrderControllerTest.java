package mambo5.Controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrderControllerTest {

	private int orderID, expected;
	private OrderController orderController;
	
	@Before
	public void setUp() throws Exception {
		orderID = 1;
		expected = 1;
		orderController = new OrderController();
	}

	@Test
	public void testValidateConfirmOrder() {
		int result;
		result = orderController.validateConfirmOrder(orderID);
		assertEquals(result, expected);
	}
	
	@Test
	public void testValidateConfirmOrderFail() {
		orderID = 0;
		expected = 0;
		int result;
		result = orderController.validateConfirmOrder(orderID);
		assertEquals(result, expected);
	}

}
