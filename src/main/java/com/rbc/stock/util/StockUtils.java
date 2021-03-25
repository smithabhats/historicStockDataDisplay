package com.rbc.stock.util;

import java.time.LocalDate;
import java.time.temporal.IsoFields;

public class StockUtils {

	public static int getQuarter(LocalDate transDate) {
		
		return transDate.get(IsoFields.QUARTER_OF_YEAR);
	}
	
	public static float getPercentChange(float open, float close) {
		
		return (((close-open)/open)*100);
	}
}
