package com.onlinesweetshopapi.exception;

public class CustomerIdExceptionResponse {

	private String customerId;

	/**
	 * CustomerIdentifierExceptionResponse parameterized constructor
	 * 
	 * @param customerIdentifier
	 */
	
	public CustomerIdExceptionResponse(String customerId) {
		super();
		this.customerId = customerId;
	}
	
	/**
	 * Get customerIdentifier
	 * @return customerIdentifier
	 */

	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Set customerIdentifier
	 * @param customerIdentifier
	 */
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
}
