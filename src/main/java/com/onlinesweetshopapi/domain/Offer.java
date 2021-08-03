package com.onlinesweetshopapi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "offerId is required")
	@Column(unique = true, updatable = false)
	@Size(min = 4, max = 6, message = "Size must be between 4 to 6 characters")
	private String offerId;
	
	@NotBlank(message = "offerName is required")
	private String offerName;
	
	private double offerDiscount;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "offer")
	private List<Sweet> sweets = new ArrayList<Sweet>();

	/**
	 * Offer Constructor
	 */
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Offer Parameterized Constructor
	 * 
	 * @param offerId
	 * @param offerName
	 * @param offerDiscount
	 */
	public Offer(String offerId, String offerName, double offerDiscount) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
		this.offerDiscount = offerDiscount;
	}

	/**
	 * Gets offerId
	 * 
	 * @return offerId
	 */
	public String getOfferId() {
		return offerId;
	}

	/**
	 * Sets offerId
	 * 
	 * @param offerId
	 */
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	/**
	 * Gets Id
	 * 
	 * @return Id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets Id param Id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets OfferName
	 * 
	 * @return offerName
	 */
	public String getOfferName() {
		return offerName;
	}

	/**
	 * Sets OfferName
	 * 
	 * @param offerName
	 */
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	/**
	 * Gets OfferDiscount
	 * 
	 * @return offerDiscount
	 */
	public double getOfferDiscount() {
		return offerDiscount;
	}

	/**
	 * Sets OfferDiscount
	 * 
	 * @param offerDiscount
	 */
	public void setOfferDiscount(double offerDiscount) {
		this.offerDiscount = offerDiscount;
	}

	/**
	 * Gets list Sweets
	 * 
	 * @return list Sweets
	 */
	public List<Sweet> getSweets() {
		return sweets;
	}

	/**
	 * Sets Sweets List
	 * 
	 * @param Sweets List
	 */
	public void setSweets(List<Sweet> sweets) {
		this.sweets = sweets;
	}
}
