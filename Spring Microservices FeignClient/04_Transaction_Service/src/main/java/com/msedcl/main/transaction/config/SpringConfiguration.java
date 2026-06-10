package com.msedcl.main.transaction.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfiguration {

	//WE REMOVED BELOW CODE TO ADD FEIGN CLIENT 
	/*
	 * @Bean
	 * 
	 * @LoadBalanced RestTemplate getRestTemplate() { return new RestTemplate(); }
	 */
}

