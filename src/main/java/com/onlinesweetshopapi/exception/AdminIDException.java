package com.onlinesweetshopapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AdminIDException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * AdminIdException Constructor
	 */
	public AdminIDException() {
		super();
	}

	/**
	 * AdminIdException parameterized Constructor
	 */
	public AdminIDException(String errMsg) {
		super(errMsg);

	}

}
