package controllayer;

import modellayer.*;

import java.sql.SQLException;
import java.util.ArrayList;

import databaselayer.CustomerDAO;

public class CustomerController {
	private CustomerDAO customerDAO;
	
	public Customer findCustomerbyId (String phoneNumber) {
		ArrayList<Customer> customers = null;
		try {
			customers = customerDAO.retrieveCustomerByPhoneNumber(phoneNumber);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Object was not found.");
			e.printStackTrace();
		}
		return customers;
	}
	
	
}
