package com.report.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is DateUtil class, which can contains the Date related utility methods.
 * @author root
 *
 */
public class DateUtil {

	static final String DATE_FORMATE = "yyyy-MM-dd";
	public static Date getDateFromString(String inputDate) {
		try {
			DateFormat format = new SimpleDateFormat(DATE_FORMATE);
			return format.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
