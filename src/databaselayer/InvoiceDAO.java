package databaselayer;

import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Helpers.DatesConversion;
import modellayer.Invoice;

public class InvoiceDAO implements InvoiceDAOIF{
	private static final String SELECT_INVOICE_BY_ID = "SELECT * FROM Invoice where id = ?";
	private PreparedStatement psSelectInvoiceById;

	private static final String INSERT_INVOICE = "INSERT into Invoice VALUES (?,?,?,?)";
	private PreparedStatement psInsertInvoice;
	
	public InvoiceDAO() throws SQLException {

		initPreparedStatement();		
	}

	private void initPreparedStatement() {
		Connection connection = DBConnection.getInstance().getDBconnection();

		try {
			psSelectInvoiceById= connection.prepareStatement(SELECT_INVOICE_BY_ID);
			psInsertInvoice = connection.prepareStatement(INSERT_INVOICE);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertInvoice(Invoice invoice) throws SQLException {
		psInsertInvoice.setLong(1, invoice.getInvoiceNumber() );
		psInsertInvoice.setDate(2, DatesConversion.convertUtilToSql(invoice.getPaymentDate()));
		psInsertInvoice.setDouble(3, invoice.getTotalPrice());
		psInsertInvoice.setInt(4, invoice.getSaleOrderId());

		psInsertInvoice.executeUpdate();
	}

	@Override
	public Invoice retrieveInvoiceById(int id) throws SQLException {
		ResultSet rs;
		Invoice invoice = null;

		rs = psSelectInvoiceById.executeQuery();

		if(rs.next()) {
			invoice = buildObject(rs);
		}

		return invoice;


	}

	private Invoice buildObject(ResultSet rs) throws SQLException{
		Invoice invoice = null;

		try {
			invoice = new Invoice(rs.getLong("invoiceNumber"), rs.getDate("dateOfPayment"), rs.getDouble("totalPrice"), rs.getInt("saleOrderId"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return invoice;
	}

}
