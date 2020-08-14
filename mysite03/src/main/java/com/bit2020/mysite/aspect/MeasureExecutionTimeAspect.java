package com.bit2020.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class MeasureExecutionTimeAspect {
	 // 리턴타입은 모든 리턴타입, com.bit2020.mysite.repository, controller, service에 들어있는 모든 클래스와 그 안에 들어있는 모든 메소드.
	@Around("execution(* *..*.repository.*.*(..)) || execution(* *..*.controller.*.*(..)) || execution(* *..*.service.*.*(..))")
	public Object aroundAspect(ProceedingJoinPoint pjp) throws Throwable {
		
		// before
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object result = pjp.proceed();
		
		// after
		sw.stop();
		Long totalTime = sw.getTotalTimeMillis();
		
		
		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		String taskName = className + "." + methodName;
		System.out.println("[Execution Time][" + taskName +"] " + totalTime + "millis");
		return result;
	}
}
