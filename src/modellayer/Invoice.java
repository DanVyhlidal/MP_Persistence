package modellayer;

import java.util.Date;

public class Invoice {
	
	private long invoiceNumber;
	private Date paymentDate;
	private double totalPrice;
	private SaleOrder saleOrder;
	
	public Invoice(long invoiceNumber, Date paymentDate, double totalPrice, SaleOrder saleOrder) {
		this.invoiceNumber = invoiceNumber;
		this.paymentDate = paymentDate;
		this.totalPrice = totalPrice;
		this.saleOrder = saleOrder;
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

	public SaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}
	
	
}
