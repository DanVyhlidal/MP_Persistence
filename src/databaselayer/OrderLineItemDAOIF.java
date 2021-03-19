package databaselayer;

import java.sql.SQLException;
import java.util.ArrayList;

import modellayer.Invoice;
import modellayer.OrderLineItem;

public interface OrderLineItemDAOIF {
	void insertOrderLineItem(OrderLineItem item) throws SQLException;
	
	ArrayList<OrderLineItem> retrieveOrderLineItemsByOrderId(int id) throws SQLException;
}
