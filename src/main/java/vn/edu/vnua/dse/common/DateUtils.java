package vn.edu.vnua.dse.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/**
	 * Convert string to date "MM/dd/yyyy"
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date stringToDate(String strDate) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			date = sdf.parse(strDate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return date;
	}
	
	
	/**
	 * Convert string to datetime dd-MM-yyyy HH:mm:ss.S
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date stringToDateTime(String strDate) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S");
		try {
			date = sdf.parse(strDate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return date;
	}

}
