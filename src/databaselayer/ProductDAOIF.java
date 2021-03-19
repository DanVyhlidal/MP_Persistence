package databaselayer;

import java.sql.SQLException;
import java.util.ArrayList;

import modellayer.Product;

public interface ProductDAOIF {
	Product retrieveProduct(String name) throws SQLException;
	Product retrieveProductById(int id) throws SQLException;
	int retrieveAmountInStock(String name) throws SQLException;
	void updateAmountInStock(String name, int newAmountInStock) throws SQLException;
}
