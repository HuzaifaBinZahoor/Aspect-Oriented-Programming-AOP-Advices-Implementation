package com.huzaifabinzahoor.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huzaifabinzahoor.aopdemo.dao.AccountDAO;
import com.huzaifabinzahoor.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get the Membership bean from the spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account theAccount = new Account("HU", "1");
		theAccountDAO.addAccount(theAccount, true);
		theAccountDAO.doWork();
		
		// calling the get and set methods from AccountDAO
		theAccountDAO.setName("Huzaifa");
		theAccountDAO.setServiceCode("Junior Developer");
		
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();

		// call the business method
		theMembershipDAO.addSillyMembership();
		theMembershipDAO.goToSleep();

		// close the context
		context.close();
	}

}
