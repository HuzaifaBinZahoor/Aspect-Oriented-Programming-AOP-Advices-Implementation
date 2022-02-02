package com.huzaifabinzahoor.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	@Before("com.huzaifabinzahoor.aopdemo.aspect.UtilityClassForAopExpression_CombinedPointcut.forDAOPackageNoGetterAndSetter()")
	public void logToCloudAsync() {
		System.out.println("\nPerfoming Cloud Logs");
	}

}
