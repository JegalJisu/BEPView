package name.beptest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import name.beptest.filter.XSSProtectSupport;

@Configuration
@RequiredArgsConstructor
public class XSSProtectConfig {
	private final ObjectMapper mapper;
	
	@Bean
	public MappingJackson2HttpMessageConverter characterEscapeConverter() {
		ObjectMapper objectMapper = mapper.copy();
		objectMapper.getFactory().setCharacterEscapes(new XSSProtectSupport());
		return new MappingJackson2HttpMessageConverter(objectMapper);
	}
}
