package controllayer;

import java.sql.SQLException;
import java.util.ArrayList;

import databaselayer.OrderLineItemDAO;
import modellayer.OrderLineItem;

public class OrderLineItemController {
	
	OrderLineItemDAO orderLineItemDAO;
	
	public OrderLineItemController() {
		try {
			orderLineItemDAO = new OrderLineItemDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createOrderLineItem(OrderLineItem item) {
		try {
			orderLineItemDAO.insertOrderLineItem(item);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<OrderLineItem> getOrderLineItemsByOrderId(int id){
		ArrayList<OrderLineItem> items = null;
		
		try {
			items = orderLineItemDAO.retrieveOrderLineItemsByOrderId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return items;
	}
}
