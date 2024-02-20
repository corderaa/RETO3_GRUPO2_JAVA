package cinesElorrieta.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Converts from a type of data to another different type of data.
 */
public class Converter {

	/**
	 * Converts a Date.Util
	 * 
	 * @param fecha
	 * @return la fecha convertida
	 */
	public Date SQLDateToUTILDate(String fecha) {
		return null;
	}

	/**
	 * Converts a SQL.Date
	 * 
	 * @param fecha
	 * @return la fecha convertida
	 */
	public Date UtilDateToSQLDate(String fecha) {
		return null;
	}

	public void converter() {

		java.util.Calendar cal = Calendar.getInstance();
		java.util.Date utilDate = new java.util.Date(); // your util date
		cal.setTime(utilDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime()); // your sql date
		System.out.println("utilDate:" + utilDate);
		System.out.println("sqlDate:" + sqlDate);
	}

	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}
}