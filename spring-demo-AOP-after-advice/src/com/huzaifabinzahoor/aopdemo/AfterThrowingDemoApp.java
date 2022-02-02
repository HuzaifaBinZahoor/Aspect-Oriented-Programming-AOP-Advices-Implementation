package com.huzaifabinzahoor.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huzaifabinzahoor.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call the method to find the Accounts
		List<Account> theAccounts = null;
		
		try {
			// adding boolean flag to stimulate exceptions
			boolean tripWire = true;
			theAccountDAO.findAccount(tripWire);
		} catch (Exception e) {
			System.out.println("Main Program caught the exception: "+ e);
		}

		// display the accounts
		System.out.println("\n \n Main Program is running and displaying the Accounts: " + theAccounts);

		// close the context
		context.close();
	}

}
