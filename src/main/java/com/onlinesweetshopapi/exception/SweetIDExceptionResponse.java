package com.onlinesweetshopapi.exception;

public class SweetIDExceptionResponse {
	
	private String sweetIdentifer;
	
	/**
	 * SweetIdentifierExceptionResponse parameterized constructor
	 * 
	 * @param sweetIdentifier
	 */
	
	public SweetIDExceptionResponse(String sweetIdentifer) {
		super();
		this.sweetIdentifer = sweetIdentifer;
	}
	
	/**
	 * Get sweetIdentifier
	 * @return sweetIdentifier
	 */

	public String getSweetIdentifer() {
		return sweetIdentifer;
	}
	
	/**
	 * Set sweetIdentifier
	 * @param sweetIdentifier
	 */

	public void setSweetIdentifer(String sweetIdentifer) {
		this.sweetIdentifer = sweetIdentifer;
	}
	
	
}
