package vn.edu.vnua.dse.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommonUtils {
	/**
	 * Phương thức xử lý đọc file sql
	 * 
	 * @param filename
	 * @return
	 */
	public static String readSqlFile(String filename) {
		ClassLoader classLoader = CommonUtils.class.getClassLoader();
		File file = new File(classLoader.getResource(filename).getFile());
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(file.getPath())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
}
