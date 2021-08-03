package com.onlinesweetshopapi.domain;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int rating;

	/**
	 * Feedback Constructor
	 */
	public Feedback() {
		super();
	}

	/*
	 * Gets id
	 * 
	 * @return id Long
	 */
	public Long getId() {
		return id;
	}

	/*
	 * Sets id
	 * 
	 * @param id Long
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * Gets rating
	 * 
	 * @return rating
	 */
	public int getRating() {
		return rating;
	}

	/*
	 * Sets rating
	 * 
	 * @return rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

}
