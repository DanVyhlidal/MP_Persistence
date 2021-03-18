package databaselayer;

import java.sql.SQLException;
import java.util.ArrayList;

import modellayer.Product;

public interface ProductDAOIF {
	Product retrieveProduct(String name) throws SQLException;
}
