package com.onlinesweetshopapi.exception;

public class CategoryIDExceptionResponse {

	private String categoryIdentifier;

	/**
	 * CategoryIdentifierExceptionResponse parameterized constructor
	 * 
	 * @param categoryIdentifier
	 */
	public CategoryIDExceptionResponse(String categoryIdentifier) {
		super();
		this.categoryIdentifier = categoryIdentifier;
	}

	/**
	 * Get categoryIdentifier
	 * @return categoryIdentifier
	 */
	public String getCategoryIdentifier() {
		return categoryIdentifier;
	}

	/**
	 * Set categoryIdentifier
	 * @param categoryIdentifier
	 */
	public void setCategoryIdentifier(String categoryIdentifier) {
		this.categoryIdentifier = categoryIdentifier;
	}
	
	
}
