package com.huzaifabinzahoor.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huzaifabinzahoor.aopdemo.dao.AccountDAO;

public class AfterRetuningDemoApp {

	public static void main(String[] args) {
		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call the method to find the Accounts
		List<Account> theAccounts = theAccountDAO.findAccount(false);

		// display the accounts
		System.out.println("\n \n Main Program is running and displaying the Accounts: " + theAccounts);

		// close the context
		context.close();
	}

}
