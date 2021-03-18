package modellayer;

public class ClothingProduct extends Product {

	private String size;
	private String colour;
	
	public ClothingProduct(int id, String name, double purchasePrice, double salesPrice, double rentPrice,
			String countryOfOrigin, int amountInStock, String productType, int supplierId, String size, String colour) {
		super(id, colour, rentPrice, rentPrice, rentPrice, colour, amountInStock, productType, supplierId);
		this.size = size;
		this.colour = colour;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	

}
