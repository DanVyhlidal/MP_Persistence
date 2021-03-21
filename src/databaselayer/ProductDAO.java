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
	
	private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM Product WHERE id = ?";
	private PreparedStatement psSelectProductById;
	
	private static final String RETRIEVE_ALL_PRODUCTS_BY_ID = "SELECT * FROM Product where id = ?";
	private PreparedStatement psRetrieveAllProductsById;
	
	private static final String RETRIEVE_AMOUNT_IN_STOCK_BY_NAME = "SELECT amountInStock FROM Product where name = ?";
	private PreparedStatement psRetrieveAmountInStockByName;
	
	private static final String UPDATE_AMOUNT_IN_STOCK_BY_NAME = "UPDATE Product SET amountInStock = ? where name = ?";
	private PreparedStatement psUpdateAmountInStockByName;
	
	public ProductDAO() throws SQLException {
		
		initPreparedStatement();		
	}
	
	private void initPreparedStatement() throws SQLException {
		
		Connection connection = DBConnection.getInstance().getDBconnection();
		
		try {
			psSelectProduct= connection.prepareStatement(SELECT_PRODUCT);
			psRetrieveAllProductsById= connection.prepareStatement(RETRIEVE_ALL_PRODUCTS_BY_ID);
			psSelectProductById = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
			psRetrieveAmountInStockByName = connection.prepareStatement(RETRIEVE_AMOUNT_IN_STOCK_BY_NAME);
			psUpdateAmountInStockByName = connection.prepareStatement(UPDATE_AMOUNT_IN_STOCK_BY_NAME);
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

	@Override
	public Product retrieveProductById(int id) throws SQLException {
		Product product = null;
		ResultSet rs;
		
		psSelectProductById.setInt(1, id);
		
		rs = psSelectProductById.executeQuery();
		
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

	@Override
	public int retrieveAmountInStock(String name) throws SQLException {
		int amountInStock = 0;
		ResultSet rs;
		
		psRetrieveAmountInStockByName.setString(1, name);
		
		rs = psRetrieveAmountInStockByName.executeQuery();
		
		amountInStock = rs.getInt(amountInStock);
		
		return amountInStock;
	}

	@Override
	public void updateAmountInStock(String name, int newAmountInStock) throws SQLException {
		psUpdateAmountInStockByName.setString(2, name);
		psUpdateAmountInStockByName.setInt(1, newAmountInStock);
		
		psUpdateAmountInStockByName.executeUpdate();
	}
}
