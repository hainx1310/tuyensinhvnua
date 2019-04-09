package vn.edu.vnua.dse.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {

	/**
	 * Lấy ra ngày hiện tại
	 * 
	 * @return YYYYMMDD
	 */
	public static String getDate() {
		Date date1 = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		return sdf1.format(date1);
	}
}
