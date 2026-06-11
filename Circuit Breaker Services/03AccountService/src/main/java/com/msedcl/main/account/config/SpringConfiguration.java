package com.msedcl.main.account.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfiguration {

	//we removed this code to add fringe client
	
	/*
	 * @Bean
	 * 
	 * @LoadBalanced RestTemplate getRestTemplate() { return new RestTemplate(); }
	 */
	
	
	
}

