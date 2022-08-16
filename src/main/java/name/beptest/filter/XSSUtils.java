package name.beptest.filter;

import org.apache.commons.text.StringEscapeUtils;

public class XSSUtils {
	public static String charEscape(String value) {
		return value == null? value : StringEscapeUtils.escapeHtml4(value);
	}
}
