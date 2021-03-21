package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import controllayer.OrderController;
import controllayer.ProductController;
import modellayer.Product;

public class TestProduct {
	
	ProductController productController;
	OrderController orderController;
	
	@Before
	public void setUp() {
		
		productController = new ProductController();
		orderController = new OrderController();
	}

	@Test
	public void testIfProductExistsInDatabase() {
		
		// Arrange
		Product product;
		String expectedProductName = "cowboy hat";
		
		// Act
		product = productController.findProductByName("Cowboy hat");
		
		// Assert
		assertEquals("Expected product name should be Cowboy hat", expectedProductName, product.getName().toLowerCase());
	
	}
	
	@Test 
	public void testQuantityTooHigh() {
		
		// Arrange
		Product product;
		int amountInStock;
		int quantity;
		
		// Act
		product = productController.findProductByName("Cowboy hat");
		amountInStock = product.getAmountInStock();
		quantity = amountInStock +1;
		
		// Assert
		assertFalse(orderController.addProductToOrder(1, quantity));
	
	}
	
	@Test 
	public void testQuantityTooLow() {
		
		// Arrange
		Product product;
		int amountInStock;
		int quantity;
		
		// Act
		product = productController.findProductByName("Cowboy hat");
		amountInStock = product.getAmountInStock();
		quantity = 0;
		
		// Assert
		assertFalse(orderController.addProductToOrder(1, quantity));
	
	}
	
	@Test 
	public void testQuantityOK() {
		
		// Arrange
		Product product;
		int amountInStock;
		int quantity;
		
		// Act
		product = productController.findProductByName("Cowboy hat");
		amountInStock = product.getAmountInStock();
		quantity = amountInStock;
		
		// Assert
		assertTrue(orderController.addProductToOrder(1, quantity));
	
	}

}
