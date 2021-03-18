package modellayer;

import java.util.Date;

public class SaleOrder {
	
	private Date dateOfOrder;
	private Date deliveryDate;
	private String deliveryStatus;
	private String discount;
	private Customer customer;
	
	public SaleOrder(Date dateOfOrder, Date deliveryDate, String deliveryStatus, String discount, Customer customer) {
		this.dateOfOrder = dateOfOrder;
		this.deliveryDate = deliveryDate;
		this.deliveryStatus = deliveryStatus;
		this.discount = discount;
		this.customer = customer;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
