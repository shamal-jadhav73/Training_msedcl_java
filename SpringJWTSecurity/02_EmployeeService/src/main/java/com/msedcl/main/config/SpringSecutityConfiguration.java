package com.msedcl.main.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.security.autoconfigure.web.servlet.SecurityFilterProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.msedcl.main.security.JwtAuthenticationFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SpringSecutityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    SpringSecutityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }
	
	@Bean
		SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
		log.info("Spring Security Configuration is working");
	
		http.csrf((csrf)->csrf.disable()).authorizeHttpRequests((requests) -> requests.anyRequest().authenticated())
		//tell spring that use our custom filter to authenticate
		.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		//csrf this is added to disable security for post requests
		
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();
	}

}
