package com.nikorp.myspring.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Nikhil.Rastogi
 *
 */
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
	
	@Pointcut("execution(java.util.List com.nikorp.myspring.aop.MembershipDAO.populate*(..))")
	private void expressionFour() {}
	
	@Before("expressionOne()")
	public void beforeAddAccountAdvice() {
		logger.debug("@Before(\"expressionOne()\")");
	}
	
	@Before("expressionThree()")
	public void beforeAddAccountAdvice2(JoinPoint joinPoint) {
		logger.debug("@Before(\"expressionOne()\") 222222222222");
		var methSig = (MethodSignature) joinPoint.getSignature();
		logger.debug("Method Signature:" + methSig);
		var args = joinPoint.getArgs();
		for (var temp : args) {
			logger.debug("ARGS=" + temp);
		}
	}

	@AfterReturning(pointcut = "expressionFour()", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint, List<String> result) {
		logger.debug("afterReturningAdvice. JP=" + joinPoint.getSignature().toShortString() + "; Returning=" + result);
		for (int i = 0; i < result.size(); i++) {
			result.set(i, result.get(i).toUpperCase());
		}
//		result = result.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
	}
	
	@Around("expressionFour()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		var startMS = System.currentTimeMillis();
		var result = joinPoint.proceed();
		logger.debug(joinPoint.getSignature().toShortString() + ". It took " + (System.currentTimeMillis() - startMS) + " millis to complete!");
		return result;
	}
}
