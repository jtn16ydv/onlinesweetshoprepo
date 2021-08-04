package com.onlinesweetshopapi.exception;

public class OrderIDExceptionResponse {
	private String orderId;

	/**
	 * OrderIdentifierExceptionResponse parameterized constructor
	 * 
	 * @param orderIdentifier
	 */

	public OrderIDExceptionResponse(String orderId) {
		super();
		this.orderId = orderId;

	}

	/**
	 * Get OrderIdentifier
	 * 
	 * @return OrderIdentifier
	 */

	public String getOrderId() {
		return orderId;
	}

	/**
	 * Set OrderIdentifier
	 * 
	 * @param OrderIdentifier
	 */

	public void setOrderId(String userId) {
		this.orderId = userId;
	}
}
