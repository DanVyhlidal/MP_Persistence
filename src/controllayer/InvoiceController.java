package controllayer;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import databaselayer.InvoiceDAO;
import modellayer.Invoice;

public class InvoiceController {
	InvoiceDAO invoiceDao;
	
	public int createInvoice (Date paymentDate, int saleOrderId) {
		Invoice invoice = new Invoice();
		int randomNum = ThreadLocalRandom.current().nextInt(1, 999999 + 1);
		invoice.setInvoiceNumber(randomNum);
		invoice.setPaymentDate(paymentDate);
		invoice.setSaleOrderId(saleOrderId);
		
		
		
		return 0;
	}
	
}
