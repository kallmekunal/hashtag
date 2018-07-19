package com.kunal.project.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kunal.project.controller.domain.User;

public class UserInfoValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors error) {
		if(((User)arg0).getUsername().isEmpty())
		ValidationUtils.rejectIfEmpty(error, "username", "name.required");
	}

}
