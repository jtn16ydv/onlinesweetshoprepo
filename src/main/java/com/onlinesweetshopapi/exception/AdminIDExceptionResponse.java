package com.onlinesweetshopapi.exception;

public class AdminIDExceptionResponse {
	private String userId;

	/**
	 * AdminIDExceptionResponse parameterized constructor
	 * 
	 * @param userId
	 */
	public AdminIDExceptionResponse(String userId) {
		super();
		this.userId = userId;
	}

	/**
	 * Get UserId
	 * 
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Set UserId
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
