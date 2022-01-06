package com.nikorp.myspring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

	private final static Logger logger = LoggerFactory.getLogger(MyLoggingAspect.class);

	@Pointcut("execution(* com.nikorp.myspring.aop.*.*(..))")
	private void expressionOne() {}
	
	@Pointcut("execution(* com.nikorp.myspring.aop.*.get*(..))")
	private void expressionTwo() {}
	
	@Pointcut("expressionOne() && !expressionTwo()")
	private void expressionThree() {}
	
	@Before("expressionOne()")
	public void beforeAddAccountAdvice() {
		logger.debug("@Before(\"expressionOne()\")");
	}
	
	@Before("expressionThree()")
	public void beforeAddAccountAdvice2() {
		logger.debug("@Before(\"expressionOne()\") 222222222222");
	}
	
}
