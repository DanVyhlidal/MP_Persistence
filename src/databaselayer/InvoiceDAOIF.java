package databaselayer;

import java.sql.SQLException;

import modellayer.Invoice;

public interface InvoiceDAOIF {

	Invoice retrieveInvoiceByInvoiceNumber(int id) throws SQLException;
}
