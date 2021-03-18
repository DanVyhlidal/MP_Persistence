package modellayer;

public class Customer {

	private String name;
	private String email;
	private String street;
	private int houseNumber;
	private String zipcode;
	private String city;
	private String phoneNumber;
	private String customerType;
	
	public Customer(String name, String email, String street, int houseNumber, String zipcode, String city,
			String phoneNumber, String customerType) {
		this.name = name;
		this.email = email;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipcode = zipcode;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.customerType = customerType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	
	
}
