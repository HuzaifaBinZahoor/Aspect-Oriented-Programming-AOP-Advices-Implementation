package com.huzaifabinzahoor.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.huzaifabinzahoor.aopdemo")
public class DemoConfig {
	
}
