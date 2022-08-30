package name.beptest.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Utils {
	public static String uuid() {
		return UUID.randomUUID().toString();
	}
	
	public static String strDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}
}
