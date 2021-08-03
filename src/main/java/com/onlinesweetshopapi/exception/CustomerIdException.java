package com.onlinesweetshopapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerIdException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * CustomerIdException Constructor
	 */
	public CustomerIdException() {
		super();
	}

	/**
	 * CustomerIdException Message Constructor
	 */
	public CustomerIdException(String errMsg) {
		super(errMsg);

	}

}
