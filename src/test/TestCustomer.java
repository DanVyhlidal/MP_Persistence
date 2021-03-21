package test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import controllayer.CustomerController;
import modellayer.Customer;

public class TestCustomer {
	
	CustomerController customerController;
	
	@Before
	public void setUp() {
		customerController = new CustomerController();
	}
	
	@Test
	public void testIfRightCustomerIsSelected() {
		
		// Arrange
		String expectedCustomerName = "Matej";
		String phoneNumber = "456245648";
		Customer customer = null;
		
		// Act
		customerController.findCustomersbyPhone(phoneNumber);
		customer = customerController.getClickedCustomer("Matej");
		
		// Assert
		assertEquals("Expected customer name should be Matej", expectedCustomerName, customer.getName());
	}

}
