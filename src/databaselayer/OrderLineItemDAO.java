package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modellayer.OrderLineItem;
import modellayer.SaleOrder;

public class OrderLineItemDAO implements OrderLineItemDAOIF {
	private static final String INSERT_ORDERLINEITEM = "INSERT into OrderLineItem VALUES (?,?,?)";
	private PreparedStatement psInsertOrderLineItem;
	
	private static final String RETRIEVE_ORDERLINEITEMS= "SELECT * from OrderLineItem where saleOrderId = ?";
	private PreparedStatement psRetrieveOrderLineItems;
	
	public OrderLineItemDAO() throws SQLException {
		
		initPreparedStatement();		
	}
	
	private void initPreparedStatement() throws SQLException {
		
		Connection connection = DBConnection.getInstance().getDBconnection();
		
		try {
			psInsertOrderLineItem= connection.prepareStatement(INSERT_ORDERLINEITEM);
			psRetrieveOrderLineItems = connection.prepareStatement(RETRIEVE_ORDERLINEITEMS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertOrderLineItem(OrderLineItem item) throws SQLException {
		// TODO Auto-generated method stub
		psInsertOrderLineItem.setInt(1, item.getProductId());
		psInsertOrderLineItem.setInt(2, item.getSaleOrderId());
		psInsertOrderLineItem.setInt(3, item.getProductQuantity());
		
		psInsertOrderLineItem.executeUpdate();
	}

	@Override
	public ArrayList<OrderLineItem> retrieveOrderLineItemsByOrderId(int id) throws SQLException {
		// TODO Auto-generated method stub	
		ArrayList<OrderLineItem> orderLineItems = new ArrayList<OrderLineItem>();
		psRetrieveOrderLineItems.setInt(1, id);
		ResultSet rs;
		
		rs = psRetrieveOrderLineItems.executeQuery();
		
		while(rs.next()) {
			OrderLineItem item = buildObject(rs);
			orderLineItems.add(item);
		}
		
		return orderLineItems;
	}
	
	private OrderLineItem buildObject(ResultSet rs) throws SQLException {
		
		OrderLineItem orderLineItem = null;
		
		try {
			orderLineItem = new OrderLineItem(rs.getInt("productQuantity"),rs.getInt("productId"), rs.getInt("saleOrderId") );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderLineItem;
	}


}
