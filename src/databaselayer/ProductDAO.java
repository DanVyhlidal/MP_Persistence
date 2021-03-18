package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modellayer.Customer;
import modellayer.Product;
import modellayer.*;

public class ProductDAO implements ProductDAOIF{
	private static final String SELECT_PRODUCT = "SELECT * FROM Product WHERE name = ?";
	private PreparedStatement psSelectProduct;
	
	public ProductDAO() throws SQLException {
		
		initPreparedStatement();		
	}
	
	private void initPreparedStatement() throws SQLException {
		
		Connection connection = DBConnection.getInstance().getDBcon();
		
		try {
			psSelectProduct= connection.prepareStatement(SELECT_PRODUCT);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Product retrieveProduct(String name) throws SQLException {
		Product product = null;
		ResultSet rs;
		
		psSelectProduct.setString(1, name);
		
		rs = psSelectProduct.executeQuery();
		
		if(rs.next()) {
			product = buildObject(rs);
		}
		
		return product;
	}
	
	private Product buildObject(ResultSet rs) throws SQLException {
		
		Product product = null;
		
		try {
			product = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("purchasePrice"), rs.getDouble("salesPrice"), rs.getDouble("rentPrice"), rs.getString("countryOfOrigin"), rs.getInt("amountInStock"), rs.getString("productType"), rs.getInt("supplierId"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}
}
