package com.msedcl.main.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
public class LoggingAspect 
{
	
	public LoggingAspect() {
		System.out.println("LoggingAspect() constructor called");
	}
	@Pointcut("execution(void com.msedcl.main.service.UserService.createUser(String))")
	public void logging()
	{
		
	}
	
	@Around("logging()")
	public void logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		
		System.out.println("[Around] advice called before method execution start");
		
		//call actual function
		proceedingJoinPoint.proceed();
		
		System.out.println("[Around] advice called after method execution complete");
		
	}
	@Before("logging()")
	public void logBefore(JoinPoint joinPoint)
	{
		System.out.println("[Before] advice called::"+ joinPoint.getSignature().getName());
	}
	
	
	
	
	
	@After("logging()")
	public void logAfter()
	{
		System.out.println("[After] advice called");
	}

}
