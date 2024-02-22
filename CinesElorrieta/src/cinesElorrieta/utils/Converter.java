package cinesElorrieta.utils;

import java.sql.Timestamp;
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

	public Timestamp convertJavaDateToTimeStamp(java.util.Date date) {

		Timestamp sqlDate = new Timestamp(date.getTime());
		sqlDate.setTime(date.getTime());

		return sqlDate;
	}

	public Date convertTimeStampJavaDate(Timestamp timestamp) {

		Date ret = new Date();
		ret.setTime(timestamp.getTime());

		return ret;
	}
}