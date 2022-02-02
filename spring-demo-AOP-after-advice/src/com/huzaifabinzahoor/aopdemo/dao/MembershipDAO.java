package com.huzaifabinzahoor.aopdemo.dao;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyMembership() {
		System.out.println(getClass() + ": ====>>>> WORK FOR FURTURE: FOR MEMBERSHIP ACCOUNT <<<<=====: ");
		return true;
	}
	
	public void goToSleep() {
		System.out.println("I am sleeping function");
	}

}
