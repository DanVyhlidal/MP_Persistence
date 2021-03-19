package controllayer;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import databaselayer.InvoiceDAO;
import modellayer.Invoice;
import Helpers.NumberConversion;

public class InvoiceController {
	InvoiceDAO invoiceDao;
	
	public InvoiceController() {
		try {
			invoiceDao = new InvoiceDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int createInvoice (int saleOrderId, double totalPrice) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 14);
		Date paymentDate = calendar.getTime();
		Invoice invoice = new Invoice();
		int randomNum = ThreadLocalRandom.current().nextInt(1, 999999 + 1);
		invoice.setInvoiceNumber(randomNum);
		invoice.setPaymentDate(paymentDate);
		invoice.setSaleOrderId(saleOrderId);
		invoice.setTotalPrice(NumberConversion.round(totalPrice, 2));
		
		try {
			invoiceDao.insertInvoice(invoice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
