package com.kunal.project.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class UserInfoServiceAspect {
	@Before("execution(public String addUserInfo())")
	public void addUserInfoAdvice(){
		System.out.println("Executing Advice on addUserInfo()");
	}
}
