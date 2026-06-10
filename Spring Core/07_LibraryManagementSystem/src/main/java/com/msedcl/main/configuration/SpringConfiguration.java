package com.msedcl.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfiguration 
{

public SpringConfiguration() {
	// TODO Auto-generated constructor stub
	
	System.out.println("Default Constructor called-springConfiguration");
}

@Bean
JdbcTemplate getJdbcTemplate()
{
	System.out.println("getJdbcTemplate() CALLED");
	
	
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate_db");
	dataSource.setUsername("root");
	dataSource.setPassword("root123");
	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
	return jdbcTemplate;
	
}
}
