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
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;

	@NotBlank(message = "categoryIdentifier is required")
	@Column(unique = true, updatable = false)
	@Size(min = 4, max = 6, message = "Size must be between 4 to 6 characters")
	private String categoryIdentifier;

	@NotBlank(message = "categoryName is required")
	private String categoryName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
	private List<Sweet> sweets = new ArrayList<Sweet>();

	/**
	 * Category constructor
	 */
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Category Parameterized constructor
	 * 
	 * @param categoryIdentifier
	 * @param categoryName
	 */
	public Category(
			@NotBlank(message = "categoryIdentifier is required") @Size(min = 4, max = 6, message = "Size must be between 4 to 6 characters") String categoryIdentifier,
			@NotBlank(message = "categoryName is required") String categoryName) {
		super();
		this.categoryIdentifier = categoryIdentifier;
		this.categoryName = categoryName;
	}

	/**
	 * Gets categoryIdentifier
	 * 
	 * @return categoryIdentifier String
	 */
	public String getCategoryIdentifier() {
		return categoryIdentifier;
	}

	/**
	 * Sets categoryIdenitifer
	 * 
	 * @param categoryIdentifier String
	 */
	public void setCategoryIdentifier(String categoryIdentifier) {
		this.categoryIdentifier = categoryIdentifier;
	}

	/**
	 * Gets categoryId
	 * 
	 * @return categoryId int
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * Sets the CategoryId
	 * 
	 * @param categoryId int
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Gets the categoryName
	 * 
	 * @return categoryName String
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the categoryName
	 * 
	 * @param categoryName String
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Gets the list of Sweets
	 * 
	 * @return Sweets list
	 */
	public List<Sweet> getSweets() {
		return sweets;
	}

	/**
	 * Sets the list of Sweets
	 * 
	 * @param Sweets list
	 */
	public void setSweets(List<Sweet> sweets) {
		this.sweets = sweets;
	}

}
