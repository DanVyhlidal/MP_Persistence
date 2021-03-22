package databaselayer;

import java.sql.SQLException;
import java.util.ArrayList;

import modellayer.Customer;

public interface CustomerDAOIF {
	
	ArrayList<Customer> retrieveCustomersByPhoneNumber(String phoneNumber) throws SQLException;
	
	Customer retrieveCustomerById(int id) throws SQLException;
}
