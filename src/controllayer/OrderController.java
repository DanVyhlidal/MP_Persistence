package controllayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import databaselayer.OrderDAO;
import modellayer.Customer;
import modellayer.OrderLineItem;
import modellayer.Product;
import modellayer.SaleOrder;

public class OrderController {
	SaleOrder order;

	OrderDAO orderDAO;
	OrderLineItemController oliController;
	ProductController pController;
	CustomerController cController;

	public OrderController() {
		oliController = new OrderLineItemController();
		pController = new ProductController();
		cController = new CustomerController();
		
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
		oliController.createOrderLineItem(item);
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
		ArrayList<OrderLineItem> items = oliController.getOrderLineItemsByOrderId(this.order.getId());
		Customer customer = cController.getCustomerById(this.order.getCustomerId());
		
		double price = 0;
		int shippingTax = 45;
		int discount = 10; // 10%
		
		for(OrderLineItem item : items) {
			Product product = pController.findProductById(item.getProductId());
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


}
