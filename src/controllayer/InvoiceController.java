package controllayer;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import databaselayer.InvoiceDAO;
import modellayer.Invoice;

public class InvoiceController {
	InvoiceDAO invoiceDao;
	
	public int createInvoice (int saleOrderId, double totalPrice) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 14);
		Date paymentDate = calendar.getTime();
		Invoice invoice = new Invoice();
		int randomNum = ThreadLocalRandom.current().nextInt(1, 999999 + 1);
		invoice.setInvoiceNumber(randomNum);
		invoice.setPaymentDate(paymentDate);
		invoice.setSaleOrderId(saleOrderId);
		invoice.setTotalPrice(totalPrice);
		
		return 0;
	}
}
