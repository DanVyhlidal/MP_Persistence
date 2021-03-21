package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modellayer.Customer;

public class CustomerDAO implements CustomerDAOIF {
	
	private static final String SELECT_CUSTOMER = "SELECT * FROM Customer WHERE phoneNumber = ?";
	private PreparedStatement psSelectCustomer;
	
	private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM Customer WHERE id = ?";
	private PreparedStatement psSelectCustomerById;
	
	public CustomerDAO() throws SQLException {
		
		initPreparedStatement();		
	}
	
	private void initPreparedStatement() throws SQLException {
		
		Connection connection = DBConnection.getInstance().getDBconnection();
		
		try {
			psSelectCustomer= connection.prepareStatement(SELECT_CUSTOMER);
			psSelectCustomerById= connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public ArrayList<Customer> retrieveCustomerByPhoneNumber(String phoneNumber) throws SQLException {
		Customer customer = null;
		ResultSet rs;
		ArrayList<Customer> customers = new ArrayList<>();
		
		psSelectCustomer.setString(1, phoneNumber);
		
		rs = psSelectCustomer.executeQuery();
		
		while(rs.next()) {
			customer = buildObject(rs);
			customers.add(customer);
		}
		
		return customers;
	}


	@Override
	public Customer retrieveCustomerById(int id) throws SQLException {
		Customer customer = null;
		ResultSet rs;
		
		psSelectCustomerById.setInt(1, id);
		
		rs = psSelectCustomerById.executeQuery();
		
		if(rs.next()) {
			customer = buildObject(rs);
		}
		
		return customer;
	}

	private Customer buildObject(ResultSet rs) throws SQLException {
		Customer customer = null;
		
		try {
			customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("street"), rs.getInt("houseNumber"), rs.getString("zipcode"), rs.getString("city"), rs.getString("phoneNumber"), rs.getString("customerType"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
	}

}
