package UI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import controllayer.*;
import modellayer.*;


public class Test {
	public static void main(String[] args) {
		CustomerController cc = new CustomerController();
		ProductController pc = new ProductController();
		OrderController oc = new OrderController();
		
		ArrayList<Customer> customers = null;
		Customer customer = null;
		
		customers = cc.findCustomersbyPhone("456245648");
		customer = cc.getClickedCustomer("Matej");
		
		Product product = null;
		product = pc.findProductByName("AR-15");
		
		Calendar cal = Calendar.getInstance();
		Date dateOfOrder = cal.getTime();
		
		// The months start from 0 (Jan-0, Feb-1, ..., Dec-11)
		cal.set(2021, 10, 14);
		Date dateOfDelivery = cal.getTime();
		
		
		
		int orderId = oc.initOrder(1);
		SaleOrder order = null;
		order = oc.finishOrder(dateOfOrder, dateOfDelivery, "private");
		
		
		System.out.println("...");
	}

}
