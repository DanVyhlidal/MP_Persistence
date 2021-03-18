package modellayer;

public class Product {

	private int id;
	private String name;
	private double purchasePrice;
	private double salesPrice;
	private double rentPrice;
	private String countryOfOrigin;
	private int amountInStock;
	private Supplier supplier;
	
	public Product(int id, String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin,
			int amountInStock, Supplier supplier) {
		this.id = id;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.amountInStock = amountInStock;
		this.supplier = supplier;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public int getAmountInStock() {
		return amountInStock;
	}

	public void setMinStock(int amountInStock) {
		this.amountInStock = amountInStock;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
}