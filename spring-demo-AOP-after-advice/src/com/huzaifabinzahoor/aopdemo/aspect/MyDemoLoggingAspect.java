package com.huzaifabinzahoor.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.huzaifabinzahoor.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// adding @After advise
	@After("execution(* com.huzaifabinzahoor.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		// print which method we are applying advising
		String methodAfterAdvise = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ========>>>>>>> Executing ====>>>>@After (finally)<<<<<===== Advice on method: "
				+ methodAfterAdvise);

	}

	// after throwing exceptions
	@AfterThrowing(pointcut = "execution(* com.huzaifabinzahoor.aopdemo.dao.AccountDAO.findAccount(..))", throwing = "theException")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theException) {

		// print which method we are applying advising
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ========>>>>>>> Executing ======>>>>>>>@AfterThrowing<<<<<<<======="
				+ " Advice on method: " + method);
		// log the exception
		System.out.println("\n ========>>>>>>> Executing @is: " + theException);

	}

	// adding new advice for @AfterReturning on the findAccounts method

	@AfterReturning(pointcut = "execution(* com.huzaifabinzahoor.aopdemo.dao.AccountDAO.findAccount(..))", returning = "results")
	public void afterReturningAdvice(JoinPoint theJoinPoint, List<Account> results) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ========>>>>>>> Executing =====>>>>>@AfterReturning<<<<<<========"
				+ " Advice on method: " + method);
		// print out the results of the method call
		System.out.println("\n result is: " + results);

		// post-proccess the data and modify it

		// convert account names to upper case
		convertAccountNamesToUpperCase(results);

		System.out.println("\n result after Upper case is: " + results);

	}

	// this is an aspect - that is java class that has collections of related
	// Advises

	// lets start applying pointcut declarations with the @Before advice

	private void convertAccountNamesToUpperCase(List<Account> results) {
		// loop through the accounts
		for (Account tempAccount : results) {
			// get the uppercase version of account names
			String newUpperCaseName = tempAccount.getName().toUpperCase();
			// update the name on the account
			tempAccount.setName(newUpperCaseName);
		}

	}

	@Before("com.huzaifabinzahoor.aopdemo.aspect.UtilityClassForAopExpression_CombinedPointcut.forDAOPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\nI am in beforeAddAccountAdvice function ");

		// display method signature
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + theMethodSignature);
		// display method arguments

		// get the arguments
		Object[] arguments = theJoinPoint.getArgs();
		// loop through the arguments
		for (Object tempArgs : arguments) {
			System.out.println(tempArgs);

			if (tempArgs instanceof Account) {
				Account theAccount = (Account) tempArgs;

				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account Service Code: " + theAccount.getLevel());

			}
		}

	}

}
