package Helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberConversion {
	/**
	 * Rounding the decimal places for inserting double values into database
	 * @param value
	 * @param places
	 * @return
	 */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
