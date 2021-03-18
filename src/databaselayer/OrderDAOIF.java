package databaselayer;
import java.sql.SQLException;
import java.util.ArrayList;

import modellayer.SaleOrder;

public interface OrderDAOIF {
	void insertOrder(SaleOrder order) throws SQLException;
	ArrayList<SaleOrder> retrieveAllOrders() throws SQLException;
}
