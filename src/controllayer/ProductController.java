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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Product findProductByName(String name) {
		Product product = null;
		
		try {
			product = productDAO.retrieveProduct(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}
	
	public Product findProductById(int id) {
		Product product = null;
		
		try {
			product = productDAO.retrieveProductById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
}
