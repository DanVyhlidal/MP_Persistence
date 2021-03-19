package modellayer;

public class OrderLineItem {
	
	private int productQuantity;
	private Product product;
	private SaleOrder saleOrder;
	
	public OrderLineItem(int productQuantity, Product product, SaleOrder saleOrder) {
		this.productQuantity = productQuantity;
		this.product = product;
		this.saleOrder = saleOrder;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}
	

}
