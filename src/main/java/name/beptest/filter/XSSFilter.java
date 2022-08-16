package name.beptest.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class XSSFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		XSSRequestWrapper wrappedRequest = new XSSRequestWrapper((HttpServletRequest) request);
		String body = IOUtils.toString(wrappedRequest.getReader());
		
		if (!StringUtils.isBlank(body)) {
			Map<String, Object> oldJsonObject = new ObjectMapper().readValue(body, HashMap.class);
			Map<String, Object> newJsonObject = new HashMap<String, Object>();
			oldJsonObject.forEach((key, value) -> newJsonObject.put(key, XSSUtils.charEscape(value.toString())));
			wrappedRequest.resetInputStream(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(newJsonObject).getBytes());
		}
		
		chain.doFilter(wrappedRequest, response);
	}
	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
