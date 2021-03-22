package controllayer;

import modellayer.*;

import java.sql.SQLException;
import java.util.ArrayList;

import databaselayer.CustomerDAO;

public class CustomerController {
	private CustomerDAO customerDAO;
	
	private ArrayList<Customer> selectedCustomers;
	
	public CustomerController() {
		try {
			customerDAO = new CustomerDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param phoneNumber
	 * @return List of customers, because more customers can have the same phoneNumber
	 */
	public ArrayList<Customer> findCustomersByPhone (String phoneNumber) {
		ArrayList<Customer> customers = null;
		try {
			customers = customerDAO.retrieveCustomersByPhoneNumber(phoneNumber);
			selectedCustomers = customers;
		} catch (SQLException e) {
			System.out.println("Object was not found.");
			e.printStackTrace();
		}
		return customers;
	}
	
	/**
	 * This method simulates the UI -> user clicks on a customer
	 * @param name
	 * @return Customer that has been selected by user
	 */
	public Customer getClickedCustomer(String name) {
		Customer customerToReturn = null;
		
		for(Customer customer : this.selectedCustomers) {
			if(customer.getName().equals(name)) {
				customerToReturn = customer;
				break;
			}
		}
		
		//Clean the memory
		selectedCustomers = null;
		
		return customerToReturn;
	}
	
	public Customer getCustomerById(int id) {
		Customer customer = null;
		
		try {
			customer = customerDAO.retrieveCustomerById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
	}
	
	
}
