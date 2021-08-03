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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sweet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sweetId;

	@NotBlank(message = "Sweet name is required")
	private String sweetName;

	@NotBlank(message = "SweetIdentifier is required")
	@Column(unique = true, updatable = false)
	private String sweetIdentifier;

	@NotBlank(message = "categoryIdentifier is required")
	@Size(min = 4, max = 6, message = "Size must be between 4 to 6 characters")
	private String categoryIdentifier;

	@NotBlank(message = "offerIdentifier is required")
	@Size(min = 4, max = 6, message = "Size must be between 4 to 6 characters")
	private String offerIdentifier;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "sweets")
	private List<Order> orders = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "category_id", updatable = false, nullable = false)
	@JsonIgnore
	private Category category;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "offer_id", updatable = false, nullable = false)
	@JsonIgnore
	private Offer offer;

	private int quantityAvailable;

	private double price;

	private double netPrice;

	/**
	 * Constructor Sweet
	 */
	public Sweet() {
		super();

	}
	
	/**
	 * Parameterized Constructor
	 * @param sweetName
	 * @param sweetIdentifier
	 * @param categoryIdentifier
	 * @param offerIdentifier
	 * @param quantityAvailable
	 * @param price
	 */
	
public Sweet(@NotBlank(message = "Sweet name is required") String sweetName,
			@NotBlank(message = "SweetIdentifier is required") String sweetIdentifier,
			@NotBlank(message = "categoryIdentifier is required") @Size(min = 4, max = 6, message = "Size must be between 4 to 6 characters") String categoryIdentifier,
			@NotBlank(message = "offerIdentifier is required") @Size(min = 4, max = 6, message = "Size must be between 4 to 6 characters") String offerIdentifier,
			int quantityAvailable, double price) {
		super();
		this.sweetName = sweetName;
		this.sweetIdentifier = sweetIdentifier;
		this.categoryIdentifier = categoryIdentifier;
		this.offerIdentifier = offerIdentifier;
		this.quantityAvailable = quantityAvailable;
		this.price = price;
	}








	/**
	 * Gets Order List
	 * 
	 * @return orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * Sets Order List
	 * 
	 * @param orders
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	/**
	 * Gets SweetId
	 * 
	 * @return sweetId
	 */
	public Long getSweetId() {
		return sweetId;
	}

	/**
	 * Sets SweetId
	 * 
	 * @param sweetId
	 */
	public void setSweetId(Long sweetId) {
		this.sweetId = sweetId;
	}

	/**
	 * Gets SweetName
	 * 
	 * @return sweetName
	 */
	public String getSweetName() {
		return sweetName;
	}

	/**
	 * Sets SweetName
	 * 
	 * @param sweetName
	 */
	public void setSweetName(String sweetName) {
		this.sweetName = sweetName;
	}

	/**
	 * Gets Category
	 * 
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Sets Category
	 * 
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Gets quantityAvailable
	 * 
	 * @return quantityAvailable
	 */
	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	/**
	 * Sets quantityAvailable
	 * 
	 * @param quantityAvailable
	 */
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	/**
	 * Gets price
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets price
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets CategoryIdentifier
	 * 
	 * @return categoryIdentifier
	 */
	public String getCategoryIdentifier() {
		return categoryIdentifier;
	}

	/**
	 * Sets CategoryIdentifier
	 * 
	 * @param categoryIdentifier
	 */
	public void setCategoryIdentifier(String categoryIdentifier) {
		this.categoryIdentifier = categoryIdentifier;
	}

	/**
	 * Gets offer
	 * 
	 * @return offer
	 */
	public Offer getOffer() {
		return offer;
	}

	/**
	 * Sets offer
	 * 
	 * @param offer
	 */
	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	/**
	 * Gets netPrice
	 * 
	 * @return netPrice
	 */
	public double getNetPrice() {
		return netPrice;
	}

	/**
	 * Sets netPrice
	 * 
	 * @param netPrice
	 */
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	/**
	 * Gets SweetIddentifier
	 * 
	 * @return sweetIdentifier
	 */
	public String getSweetIdentifier() {
		return sweetIdentifier;
	}

	/**
	 * Sets SweetIddentifier
	 * 
	 * @param sweetIdentifier
	 */
	public void setSweetIdentifier(String sweetIdentifier) {
		this.sweetIdentifier = sweetIdentifier;
	}

	/**
	 * Gets OfferIddentifier
	 * 
	 * @return offerIdentifier
	 */
	public String getOfferIdentifier() {
		return offerIdentifier;
	}

	/**
	 * Sets OfferIddentifier
	 * 
	 * @param offerIdentifier
	 */
	public void setOfferIdentifier(String offerIdentifier) {
		this.offerIdentifier = offerIdentifier;
	}

}
