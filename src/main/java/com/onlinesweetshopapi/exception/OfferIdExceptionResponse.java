package com.onlinesweetshopapi.exception;

public class OfferIdExceptionResponse {

	private String offerId;

	/**
	 * OfferIdentifierExceptionResponse parameterized constructor
	 * 
	 * @param offerIdentifier
	 */

	public OfferIdExceptionResponse(String offerId) {
		super();
		this.offerId = offerId;
	}
	
	/**
	 * Get offerIdentifier
	 * 
	 * @return offerIdentifier
	 */

	public String getOfferId() {
		return offerId;
	}
	
	/**
	 * Set offerIdentifier
	 * 
	 * @param offerIdentifier
	 */

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

}
