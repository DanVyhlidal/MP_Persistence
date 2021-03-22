package controllayer;
import java.sql.SQLException;

import databaselayer.*;
import modellayer.*;

public class ProductController {

	private ProductDAO productDAO;
	
	public ProductController() {
		try {
			productDAO = new ProductDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Product findProductByName(String name) {
		Product product = null;
		
		try {
			product = productDAO.retrieveProduct(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	public Product findProductById(int id) {
		Product product = null;
		
		try {
			product = productDAO.retrieveProductById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public int getProductAmountInStock(String name) {
		int amountInStock = 0;
		
		try {
			amountInStock = productDAO.retrieveAmountInStock(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return amountInStock;
	}
		
	public void updateProductAmountInStock(String name, int newAmountInStock) {
		try {
			productDAO.updateAmountInStock(name, newAmountInStock);;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
