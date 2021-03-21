package UI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import controllayer.*;
import modellayer.*;


public class Test {
	public static void main(String[] args) {
		
		CustomerController customerController = new CustomerController();
		ProductController productController = new ProductController();
		OrderController orderController = new OrderController();
		
		ArrayList<Customer> customers = null;
		Customer customer = null;
		
		customers = customerController.findCustomersbyPhone("456245648");
		customer = customerController.getClickedCustomer("Dan");
		
		Calendar cal = Calendar.getInstance();
		Date dateOfOrder = cal.getTime();
		
		// The months start from 0 (Jan-0, Feb-1, ..., Dec-11)
		cal.set(2021, 3, 10);
		Date dateOfDelivery = cal.getTime();
		
		int orderId = orderController.initOrder(1);
		
		//Adding pistol belt
		orderController.addProductToOrder(2,10);
		//Adding AR-15
		orderController.addProductToOrder(6,5);
		
		SaleOrder order = null;
		order = orderController.finishOrder(dateOfOrder, dateOfDelivery);
		
		//This should create 2 records in OrderLineItem table
		orderController.addProductsToOrder();
		
		//This should create record in Invoice table
		orderController.createInvoice();

	}

}
