package com.msedcl.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class FeignConfig {
	
	@Bean
	RequestInterceptor getRequestInterceptor() {
		return requestTemplate -> {
			RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
			ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) attributes;
			if (servletRequestAttributes != null) {
				
				//Request received to Application
				HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
				//Retrieving Token from request
				String token = httpServletRequest.getHeader("Authorization");
				
				if (token != null) {
					//sending token to new request object which will sent to Department Service
					requestTemplate.header("Authorization", token);
				}
			}
		};

	}
}

