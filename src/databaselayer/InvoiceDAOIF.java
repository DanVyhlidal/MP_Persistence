package databaselayer;

import java.sql.SQLException;

import modellayer.Invoice;
import modellayer.SaleOrder;

public interface InvoiceDAOIF {

	void insertInvoice(Invoice invoice) throws SQLException;
	Invoice retrieveInvoiceById(int id) throws SQLException;
}
