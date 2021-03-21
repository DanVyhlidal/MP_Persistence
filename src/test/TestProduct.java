package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controllayer.ProductController;
import modellayer.Product;

public class TestProduct {
	
	ProductController productController;
	
	@Before
	public void setUp() {
		
		productController = new ProductController();
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

}
