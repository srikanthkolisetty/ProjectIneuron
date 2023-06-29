package com.example.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aops {

	@Pointcut("execution(* com.example.service.IServiceImpl.*())")
	public void method()
	{
		
	}
	
	@Before("method()")
	public void advice()
	{
		System.out.println("before the invocation of the service method");
	}
	
}
