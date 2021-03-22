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
	private SaleOrder order;
	private HashMap<Integer, Integer> products;

	private OrderDAO orderDAO;
	private OrderLineItemController orderLineItemController;
	private ProductController productController;
	private CustomerController customerController;
	private InvoiceController invoiceController;

	public OrderController() {
		orderLineItemController = new OrderLineItemController();
		productController = new ProductController();
		customerController = new CustomerController();
		invoiceController = new InvoiceController();
		products = new HashMap<Integer, Integer>();
		
		try {
			orderDAO = new OrderDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Initializing the empty order
	 * @param customerId
	 * @return orderId for future reference in UI
	 */
	public int initOrder(int customerId) {
		order = new SaleOrder(customerId);
		ArrayList<SaleOrder> allOrders = null;

		try {
			allOrders = orderDAO.retrieveAllOrders();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int lastId = getLastIdFromOrders(allOrders);
		order.setId(++lastId);


		return lastId;
	}
	/**
	 * This method adds selected product by user to HashMap
	 * @param productId
	 * @param quantity
	 * @return boolean value for testing
	 */
	public boolean addProductToOrder(int productId, int quantity) {
		
		boolean isRight;
		
		int amountInStock = productController.findProductById(productId).getAmountInStock();
		
		if(quantity > 0 && quantity <= amountInStock) {
			products.put(productId, quantity);
			isRight = true;
		} else {
			isRight = false;
		}
		
		return isRight;
	}
	/**
	 * Iterating through the products HashMap and creating record in database of OrderLineItem
	 */
	public void addProductsToOrder() {
		products.forEach((key,value) -> {
			OrderLineItem item = new OrderLineItem(value, key, this.order.getId());
			orderLineItemController.createOrderLineItem(item);
		});
	}

	/**
	 * Finishing up the order
	 * @param dateOfOrder
	 * @param deliveryDate
	 * @return
	 */
	public SaleOrder finishOrder(Date dateOfOrder, Date deliveryDate) {
		// Set all values
		order.setDateOfOrder(dateOfOrder);
		order.setDeliveryDate(deliveryDate);

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
	
	/**
	 * Helper method which helps us to retrieve the highest orderId from database
	 * @param orders
	 * @return highest orderId
	 */
	private int getLastIdFromOrders(ArrayList<SaleOrder> orders) {
		int highestId = 0;

		for(SaleOrder order : orders) {
			if(order.getId() > highestId)
				highestId = order.getId();
		}

		return highestId;
	}
	/**
	 * Calculating the final price with shippingTax and discount
	 * Updating the amount in stock of products based on a quantity in the order
	 * @return the final price of the order
	 */
	public double calculateTotalPrice () {
		ArrayList<OrderLineItem> items = orderLineItemController.getOrderLineItemsByOrderId(this.order.getId());
		Customer customer = customerController.getCustomerById(this.order.getCustomerId());
		
		double price = 0;
		int shippingTax = 45;
		int discount = 10; // 10%
		
		for(OrderLineItem item : items) {
			Product product = productController.findProductById(item.getProductId());
			price += product.getSalesPrice() * item.getProductQuantity();
			productController.updateProductAmountInStock(product.getName(), product.getAmountInStock()-item.getProductQuantity());
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
