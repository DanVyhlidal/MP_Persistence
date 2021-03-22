package UI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import controllayer.*;
import modellayer.*;


public class Test {
	/**
	 * This method simulates the UI and user behavior
	 * @param args
	 */
	public static void main(String[] args) {
		
		CustomerController customerController = new CustomerController();
		ProductController productController = new ProductController();
		OrderController orderController = new OrderController();
		
		ArrayList<Customer> customers = null;
		Customer customer = null;
		SaleOrder order = null;
		
		/*-----------First step------------*/
		customers = customerController.findCustomersByPhone("456245648");
		customer = customerController.getClickedCustomer("Dan");
		
		/*-----------Second step------------*/
		int orderId = orderController.initOrder(1);
		
		/*-----------Third step------------*/ 
		orderController.addProductToOrder(2,10); //Adding pistol belt
		orderController.addProductToOrder(6,5);  //Adding AR-15
		
		/*-----------Fourth step------------*/
		Calendar cal = Calendar.getInstance();
		Date dateOfOrder = cal.getTime();
		
		cal.set(2021, 3, 10); // The months start from 0 (Jan-0, Feb-1, ..., Dec-11)
		Date dateOfDelivery = cal.getTime();
		
		
		/*-----------Fifth step------------*/
		order = orderController.finishOrder(dateOfOrder, dateOfDelivery);
		orderController.addProductsToOrder();

		/*-----------Sixth step------------*/
		orderController.createInvoice();
	}

}
