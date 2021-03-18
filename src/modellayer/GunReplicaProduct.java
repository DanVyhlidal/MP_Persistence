package modellayer;

public class GunReplicaProduct extends Product {

	private int calibre;
	private String material;
	
	public GunReplicaProduct(int id, String name, double purchasePrice, double salesPrice, double rentPrice,
			String countryOfOrigin, int amountInStock, Supplier supplier, int calibre, String material) {
		super(id, name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, amountInStock, supplier);
		this.calibre = calibre;
		this.material = material;
	}

	public int getCalibre() {
		return calibre;
	}

	public void setCalibre(int calibre) {
		this.calibre = calibre;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	
}
