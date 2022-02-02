package com.huzaifabinzahoor.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UtilityClassForAopExpression_CombinedPointcut {

	// pointcut declarations
	@Pointcut("execution(* com.huzaifabinzahoor.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {
	}

	// create a point cut for getter methods
	@Pointcut("execution(* com.huzaifabinzahoor.aopdemo.dao.*.get*(..))")
	public void getter() {
	}

	// create a point cut for setter methods
	@Pointcut("execution(* com.huzaifabinzahoor.aopdemo.dao.*.set*(..))")
	public void setter() {
	}

	// create a point cut to include package ... exclude getter and setters
	@Pointcut("forDAOPackage() &&  !(getter() || setter())")
	public void forDAOPackageNoGetterAndSetter() {
	}

}
