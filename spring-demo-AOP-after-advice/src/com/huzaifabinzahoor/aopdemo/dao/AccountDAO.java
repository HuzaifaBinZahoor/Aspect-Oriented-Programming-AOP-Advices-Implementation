package com.huzaifabinzahoor.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

import com.huzaifabinzahoor.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	// adding new method find account that will return the list of the Account
	// objects
	public List<Account> findAccount(boolean tripWire) {
		List<Account> myAccounts = new ArrayList<>();
		
		// for academic purposes // to stimulate an exception
		if(tripWire) {
			throw new RuntimeException("I WILL NOT WORK !!");
		}
		
		// create simple accounts
		Account acc1 = new Account("Black", "A");
		Account acc2 = new Account("White", "B");
		Account acc3 = new Account("Blue", "A");

		// add them to our account lists
		myAccounts.add(acc1);
		myAccounts.add(acc2);
		myAccounts.add(acc3);
		
		return myAccounts;
	}

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK FOR FURTURE: FOR ADDING ACCOUNT");
		System.out.println("Here are the results for name: " + theAccount.getName());
		System.out.println("Here are the results for level: " + theAccount.getLevel());
	}

	public boolean doWork() {
		System.out.println(getClass() + ": Boolean Function");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
