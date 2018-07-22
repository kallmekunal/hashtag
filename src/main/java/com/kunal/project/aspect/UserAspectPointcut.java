package com.kunal.project.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class UserAspectPointcut {
	@Before("addUserInfo()")
	public void loggingAdvice(){
		System.out.println("Executing loggingAdvice on addUserInfo()");
	}
	
}
