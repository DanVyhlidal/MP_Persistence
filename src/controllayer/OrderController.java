package controllayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import databaselayer.OrderDAO;
import modellayer.SaleOrder;

public class OrderController {
	SaleOrder order;
	
	OrderDAO orderDAO;
	
	public OrderController() {
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
	
}
