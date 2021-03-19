package modellayer;

public class OrderLineItem {
	
	private int productQuantity;
	private int productId;
	private int saleOrderId;
	
	public OrderLineItem(int productQuantity, int productId, int saleOrderId) {
		this.productQuantity = productQuantity;
		this.productId = productId;
		this.saleOrderId = saleOrderId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProduct(int productId) {
		this.productId = productId;
	}

	public int getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	

}
