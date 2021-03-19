package controllayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import databaselayer.OrderDAO;
import modellayer.Customer;
import modellayer.OrderLineItem;
import modellayer.Product;
import modellayer.SaleOrder;

public class OrderController {
	SaleOrder order;
	HashMap<Integer, Integer> products;

	OrderDAO orderDAO;
	OrderLineItemController orderLineItemController;
	ProductController productController;
	CustomerController customerController;
	InvoiceController invoiceController;

	public OrderController() {
		orderLineItemController = new OrderLineItemController();
		productController = new ProductController();
		customerController = new CustomerController();
		invoiceController = new InvoiceController();
		
		try {
			orderDAO = new OrderDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int initOrder(int customerId) {
		order = new SaleOrder(customerId);
		ArrayList<SaleOrder> allOrders = null;

		try {
			allOrders = orderDAO.retrieveAllOrders();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int lastId = getLastIdFromOrders(allOrders);
		order.setId(++lastId);


		return lastId;
	}
	
	public void addProductToOrder(int productId, int quantity) {
		OrderLineItem item = new OrderLineItem(quantity, productId, this.order.getId());
		orderLineItemController.createOrderLineItem(item);
	}
	
	public void addProductsToOrder() {
		OrderLineItem item = new OrderLineItem(quantity, productId, this.order.getId());
		orderLineItemController.createOrderLineItem(item);
	}

	public SaleOrder finishOrder(Date dateOfOrder, Date deliveryDate, String discount) {
		// Set all values
		order.setDateOfOrder(dateOfOrder);
		order.setDeliveryDate(deliveryDate);
		order.setDiscount(discount);

		order.setDeliveryStatus("Completed");
		// insert order into database

		try {
			orderDAO.insertOrder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this.order;
	}


	private int getLastIdFromOrders(ArrayList<SaleOrder> orders) {
		int highestId = 0;

		for(SaleOrder order : orders) {
			if(order.getId() > highestId)
				highestId = order.getId();
		}

		return highestId;
	}

	public double calculateTotalPrice () {
		ArrayList<OrderLineItem> items = orderLineItemController.getOrderLineItemsByOrderId(this.order.getId());
		Customer customer = customerController.getCustomerById(this.order.getCustomerId());
		
		double price = 0;
		int shippingTax = 45;
		int discount = 10; // 10%
		
		for(OrderLineItem item : items) {
			Product product = productController.findProductById(item.getProductId());
			price += product.getSalesPrice() * item.getProductQuantity();
		}
		
		if(customer.getCustomerType().toLowerCase().equals("private") && (price < 2500)) {
			price += shippingTax;
		}else if(customer.getCustomerType().toLowerCase().equals("club") && (price >= 1500)) {
			price = price - ((price / 100) * discount);
			
			price += shippingTax;
		}
		
		return price;

	}
	
	public void createInvoice() {
		invoiceController.createInvoice(this.order.getId(), calculateTotalPrice());
	}


}
