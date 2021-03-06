package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;

import modellayer.Product;
import modellayer.SaleOrder;
import Helpers.*;

public class OrderDAO implements OrderDAOIF{

	private static final String SELECT_ALL_ORDERS = "SELECT * FROM SaleOrder";
	private PreparedStatement psSelectAllOrders;
	
	private static final String INSERT_ORDER = "INSERT into SaleOrder VALUES (?,?,?,?)";
	private PreparedStatement psInsertOrder;
	
	public OrderDAO() throws SQLException {
		
		initPreparedStatement();		
	}
	
	private void initPreparedStatement() throws SQLException {
		
		Connection connection = DBConnection.getInstance().getDBconnection();
		
		try {
			psSelectAllOrders= connection.prepareStatement(SELECT_ALL_ORDERS);
			psInsertOrder = connection.prepareStatement(INSERT_ORDER);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertOrder(SaleOrder order) throws SQLException {
		psInsertOrder.setDate(1, DatesConversion.convertUtilToSql(order.getDateOfOrder()));
		psInsertOrder.setString(2, order.getDeliveryStatus());
		psInsertOrder.setDate(3, DatesConversion.convertUtilToSql(order.getDeliveryDate()));
		psInsertOrder.setInt(4, order.getCustomerId());
		
		psInsertOrder.executeUpdate();
	}

	@Override
	public ArrayList<SaleOrder> retrieveAllOrders() throws SQLException {
		ArrayList<SaleOrder> orders = new ArrayList<SaleOrder>();
		ResultSet rs;
		
		rs = psSelectAllOrders.executeQuery();
		
		while(rs.next()) {
			SaleOrder order = buildObject(rs);
			orders.add(order);
		}
		
		
		return orders;
	}
	
	private SaleOrder buildObject(ResultSet rs) throws SQLException {
		
		SaleOrder order = null;
		
		try {
			order = new SaleOrder(rs.getInt("id"), rs.getDate("dateOfOrder"), rs.getDate("deliveryDate"), rs.getString("deliveryStatus"), rs.getInt("customerId"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
	}

}
