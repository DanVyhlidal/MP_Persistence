package modellayer;

import java.util.Date;

public class SaleOrder {
	
	private int id;
	private Date dateOfOrder;
	private Date deliveryDate;
	private String deliveryStatus;
	private String discount;
	private int customerId;
	
	public SaleOrder(int id, Date dateOfOrder, Date deliveryDate, String deliveryStatus, String discount, int customerId) {
		this.id = id;
		this.dateOfOrder = dateOfOrder;
		this.deliveryDate = deliveryDate;
		this.deliveryStatus = deliveryStatus;
		this.discount = discount;
		this.customerId = customerId;
	}

	public SaleOrder(int customerId) {
		this.customerId = customerId;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomer(int customerId) {
		this.customerId = customerId;
	}
	
	
	
}
