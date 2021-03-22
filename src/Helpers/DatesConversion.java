package Helpers;

public class DatesConversion {
	/**
	 * Converting the java.util.Date into java.sql.Date
	 * in order to insert date into database
	 * @param uDate
	 * @return
	 */
	public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
