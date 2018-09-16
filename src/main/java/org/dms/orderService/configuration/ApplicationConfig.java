/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.orderService.configuration;

import org.dms.orderService.handlers.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

	/**
	 * Zuul's service base url
	 */
	@Value("${zuul.url}")
	private String gatewayUrl;

	/**
	 * @param builder
	 *            the rest template builder
	 * @return a RestTemplate bean
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.errorHandler(new RestTemplateResponseErrorHandler()).rootUri(this.gatewayUrl).build();
	}
}
