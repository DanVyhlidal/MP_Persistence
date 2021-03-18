package databaselayer;

import java.sql.SQLException;
import java.util.ArrayList;

import modellayer.Customer;

public interface CustomerDAOIF {
	
	ArrayList<Customer> retrieveCustomerByPhoneNumber(String phoneNumber) throws SQLException;
}
