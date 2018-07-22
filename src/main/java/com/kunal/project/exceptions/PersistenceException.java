package com.kunal.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Persistence failed for Request!") //500
public class PersistenceException extends Exception {

	private static final long serialVersionUID = -3332292346834265371L;

	public PersistenceException(String name){
		super("Can not persist user with name="+name);
	}
}