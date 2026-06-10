package com.msedcl.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import com.msedcl.main.aspects.LoggingAspect;
import com.msedcl.main.service.UserService;

@Configuration()
//@ComponentScan(basePackages = "com.msedcl.main")

@EnableAspectJAutoProxy
public class SpringConfiguration {
	
	@Bean
	@Scope(scopeName="prototype")
	UserService getUserService()
	{
		System.out.println("SpringConfiguration CLASS getUserService() CALLED FOR OBJECT CREATION USING JAVA CONFIGURATION");
		return new UserService();
	}
	
	@Bean
	@Scope(scopeName="prototype")
	LoggingAspect getLoggingAspect()
	{
		System.out.println("SpringConfiguration CLASS getLoggingAspect() CALLED FOR OBJECT CREATION USING JAVA CONFIGURATION");
		return new LoggingAspect();
	}

}
