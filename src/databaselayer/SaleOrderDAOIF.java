package databaselayer;

import java.sql.SQLException;

import modellayer.SaleOrder;

public interface SaleOrderDAOIF {

	SaleOrder retrieveSaleOrderById(int id) throws SQLException;
}
