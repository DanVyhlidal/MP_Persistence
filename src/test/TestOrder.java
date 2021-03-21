package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import controllayer.CustomerController;
import controllayer.OrderController;
import controllayer.ProductController;
import modellayer.Customer;
import modellayer.Invoice;
import modellayer.OrderLineItem;
import modellayer.Product;
import modellayer.SaleOrder;

public class TestOrder {
	
	ProductController productController;
	CustomerController customerController;
	OrderController orderController;
	
	@Before
	public void setUp() {
		productController = new ProductController();
		customerController = new CustomerController();
		orderController = new OrderController();
	}

	
	//Every time this test is performed a new Sale Order is added to database.
	@Test
	public void testIfTotalPriceIsCorrect() {
	
		// Arrange
		Product product = null;
		Customer customer = null;
		SaleOrder saleOrder = null;
		
		double expectedTotalPrice = 500;
		
		Calendar cal = Calendar.getInstance();
		Date dateOfOrder = cal.getTime();
		
		cal.set(2021, 10, 14);
		Date dateOfDelivery = cal.getTime();
		
		// Act
		product = productController.findProductByName("AR-15");
		customer = customerController.getCustomerById(1);
		int orderId = orderController.initOrder(1);
		orderController.addProductToOrder(product.getId(),10);
		saleOrder = orderController.finishOrder(dateOfOrder, dateOfDelivery);
		
		//This should create 2 records in OrderLineItem table
		orderController.addProductsToOrder();
		
		//This should create record in Invoice table
		orderController.createInvoice();
		
		// Assert
		assertEquals(expectedTotalPrice, orderController.calculateTotalPrice(), 0d);
		
		
	}

}
