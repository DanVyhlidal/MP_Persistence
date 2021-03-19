package modellayer;

import java.util.Date;

public class Invoice {
	
	private long invoiceNumber;
	private Date paymentDate;
	private double totalPrice;
	private int saleOrderId;
	
	public Invoice() {
		
	}
	
	public Invoice(long invoiceNumber, Date paymentDate, double totalPrice, int saleOrderId) {
		this.invoiceNumber = invoiceNumber;
		this.paymentDate = paymentDate;
		this.totalPrice = totalPrice;
		this.saleOrderId = saleOrderId;
	}

	public long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	
	
}
