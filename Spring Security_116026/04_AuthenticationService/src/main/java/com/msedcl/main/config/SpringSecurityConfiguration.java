package com.msedcl.main.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.security.autoconfigure.web.servlet.SecurityFilterProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration
public class SpringSecurityConfiguration {
	@Bean
	@Order(SecurityFilterProperties.BASIC_AUTH_ORDER)
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
		log.info("Spring Security Configuration is working");
		//following code to customize pages authentication, like myaccounts and mytransactions will have authentication and contact-us, notices will directly accessible
		
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/myaccounts","/mytransactions").authenticated()
				.requestMatchers("/contact-us","/notices").permitAll()); 
		//authenticate()->to authenticate via username password,denyall()->toDeny,permitall()->to permit all without authentication
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();
	}

}
