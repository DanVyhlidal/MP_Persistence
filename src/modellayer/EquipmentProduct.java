package modellayer;

public class EquipmentProduct extends Product {

	private String type;
	private String description;
	
	public EquipmentProduct(int id, String name, double purchasePrice, double salesPrice, double rentPrice,
			String countryOfOrigin, int amountInStock, String productType,int supplierId, String type, String description) {
		super(id, name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, amountInStock, productType, supplierId);
		this.type = type;
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
