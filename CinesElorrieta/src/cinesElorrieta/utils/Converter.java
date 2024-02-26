package cinesElorrieta.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Converts from a type of data to another different type of data.
 */
public class Converter {

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